import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Creates the frame and adds number panel and result label.
 * @author Fatih Sevban Uyanik
 * @version 28,03,2018
 */
public class Frame extends JFrame
{
    // properties
    JPanel numberPanel;
    JLabel resultLabel;
    Button[] buttons;
    int hiddenButtonNumber;
    int noOfTrial;

    // constructors

    /**
     * Constructor
     */
    public Frame()
    {
        super( "Pot Luck" );

        // declaring variables
        resultLabel  = new JLabel( "Trial : 0" );
        numberPanel = new JPanel();
        buttons     = new Button[ 25 ];
        noOfTrial = 0;
        hiddenButtonNumber = ( int ) ( Math.random() * 25 + 1 );

        System.out.println( "hidden button is " + (hiddenButtonNumber + 1) );

        // setting layout of the panel and result label
        numberPanel.setLayout( new GridLayout( 5, 5 ) );
        resultLabel.setFont( new Font( "Arial" , Font.BOLD , 30 ) );
        resultLabel.setOpaque( true );
        resultLabel.setBackground( Color.ORANGE );
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setVerticalAlignment(SwingConstants.CENTER);

        // adding buttons to the panel and setting their action listeners.
        for ( int i = 0; i < 25 ; i++ )
        {
            buttons[ i ] = new Button( (i + 1) + "" );
            buttons[ i ].addActionListener( new TheHandler() );
            numberPanel.add( buttons[ i ] );
        }

        // adding numberPanel and resultLabel to frame.
        add( numberPanel , BorderLayout.CENTER );
        add( resultLabel , BorderLayout.NORTH );

        // setting other settings of the frame.
        setVisible( true );
        setSize( 500 , 500 );
        setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    /**
     * inner class containing Action Listener that handles the buttons.
     */
    private class TheHandler implements ActionListener
    {
        @Override
        public void actionPerformed( ActionEvent e )
        {
            // in case of finding hidden Button
            if ( e.getSource() == buttons[ hiddenButtonNumber ] )
            {
                resultLabel.setText( "You got it in " + (++noOfTrial) + " attempts!" );
                int response = JOptionPane.showConfirmDialog(
                        null , "Do wou want to play again ?",
                        "Game Over!!!" , JOptionPane.YES_NO_OPTION );

                // asking user for restart.
                if ( response == 0 )
                {
                    hiddenButtonNumber = (int) ( Math.random() * 25 + 1 );
                    System.out.println( "hidden button is " + (hiddenButtonNumber+1) );
                    resultLabel.setText( "Trial : 0" );
                    noOfTrial = 0;
                }
                // exiting
                else
                    System.exit(0);
            }
            // in case of not finding hidden Button.
            else
                resultLabel.setText( "Trial : " + (++noOfTrial) );
        }
    }

}