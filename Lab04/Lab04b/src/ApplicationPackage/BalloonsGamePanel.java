package ApplicationPackage;

import Shape.Circle;
import Shape.ShapeContainer;
import Shape.Drawable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
/**
 * Creates balloons for the game and indicates score and time.
 * @author Fatih Sevban Uyanik
 * @version 28,03,2018
 */
public class BalloonsGamePanel extends JPanel implements MouseListener
{
    // constants
    private final int TIME_INTERVAL = 20000;
    private final int TIMER_PERIOD = 50;

    // properties
    private ShapeContainer balloons;
    private Timer timer;
    private Iterator iterator;
    private JLabel scoreTable;
    private JLabel remainingTimeTable;
    private int elapsedTime;
    private int points;

    // constructors

    public BalloonsGamePanel()
    {
        super();

        // declaring variables
        balloons = new ShapeContainer();
        iterator = balloons.iterator();

        elapsedTime = 0;
        points = 0;

        scoreTable = new JLabel( "SCORE : " + points );
        scoreTable.setFont( new Font( "Serif" , Font.BOLD , 20 ) );
        add( scoreTable );

        remainingTimeTable = new JLabel( "Remaining Time " + ( (10000 - elapsedTime) / 100) );
        remainingTimeTable.setFont( new Font( "Serif" , Font.BOLD , 20 ) );
        add( remainingTimeTable );



        // setting panel
        addMouseListener( this );
        setOpaque( true );
        setBackground( Color.ORANGE );

        // creating 25 balloons in random points.
        for ( int i = 0 ; i < 25 ; i++ )
        {
            int randomX = (int) ( Math.random() * 500 + 1 );
            int randomY = (int) ( Math.random() * 500 + 1 );
            balloons.add( new Balloon( randomX , randomY ) );
        }

        // starting timer.
        startTimer();
    }

    // methods

    /**
     * paints drawings to the panel.
     * @param g is the graphics object that draws the shapes.
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor( Color.RED );

        while ( iterator.hasNext() )
        {
            Object object = iterator.next();
            ((Drawable)object).draw( g );
        }

    }

    /**
     * starts timer.
     */
    public void startTimer()
    {
        // adjusting timer
        timer = new Timer(TIMER_PERIOD, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                balloons.removeSelectedShapesFromTheCollection();

                // increasing time and showing remaining time
                elapsedTime += TIMER_PERIOD;
                remainingTimeTable.setText( "Remaining Time "
                        + (int)((TIME_INTERVAL - elapsedTime) / 1000 ) );

                // stopping timer at 10th second.
                if ( elapsedTime == TIME_INTERVAL )
                {
                    timer.stop();

                    int response = JOptionPane.showConfirmDialog(
                            null , "Do wou want to play again ?",
                            "Game Over!!!" , JOptionPane.YES_NO_OPTION );

                    if ( response == 0 )
                    {
                        timer.start();
                        elapsedTime = 0;
                        points = 0;
                        scoreTable.setText( "SCORE : " + points );
                    }
                    else
                        System.exit(0);
                }

                // if balloons are less than 15, adding balloons to collection.
                if ( balloons.size() < 15 )
                {
                    int randomX = (int) ( Math.random() * 500 + 1 );
                    int randomY = (int) ( Math.random() * 500 + 1 );
                    balloons.add( new Balloon( randomX , randomY ) );
                }

                // calling the grow method of the shapes in the collection.
                while ( iterator.hasNext() )
                {
                    Object object = iterator.next();
                    ((Balloon)object).grow();
                }

                repaint();
            }
        });

        timer.start();
    }


    /**
     * pins the balloons and gives points.
     * @param e is the event that happened
     */
    @Override
    public void mousePressed(MouseEvent e)
    {
        int pinnedBalloons = balloons.selectAll( e.getX() , e.getY() );

        if ( pinnedBalloons >= 2 )
            scoreTable.setText( "SCORE : " + ( ++points ) );
    }


    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}
}