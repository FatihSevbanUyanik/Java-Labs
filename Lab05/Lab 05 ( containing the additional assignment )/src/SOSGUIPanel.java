import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Creates a panel that contains SOS game.
 * @author Fatih Sevban Uyanik
 * @version 04,04,2018
 */
public class SOSGUIPanel extends JPanel
{
    // properties
    private JLabel    nameOfPlayer1Label;
    private JLabel    nameOfPlayer2Label;
    private JLabel   scoreOfPlayer1Label;
    private JLabel   scoreOfPlayer2Label;
    private JRadioButton    sRadioButton;
    private JRadioButton    oRadioButton;
    private SOSCanvas      sosCanvasGame;
    private JPanel labelsAndButtonsPanel;
    private ButtonGroup      buttonGroup;
    private int                dimension;
    private int             widthOfPanel;
    private int            heightOfPanel;

    // constructor
    public SOSGUIPanel( String nameOfPlayer1 , String nameOfPlayer2 )
    {
        super();

        // declaring labels and making them opaque.
        nameOfPlayer1Label  = new JLabel( nameOfPlayer1 );
        nameOfPlayer2Label  = new JLabel( nameOfPlayer2  );
        scoreOfPlayer1Label = new JLabel( " : 0" );
        scoreOfPlayer2Label = new JLabel( " : 0" );

        nameOfPlayer1Label.setOpaque(  true );
        nameOfPlayer2Label.setOpaque(  true );
        scoreOfPlayer1Label.setOpaque( true );
        scoreOfPlayer2Label.setOpaque( true );

        // adding mouse listeners
        nameOfPlayer1Label.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                String newName = JOptionPane.showInputDialog( null , "type new name : " );
                if ( newName != null )
                    nameOfPlayer1Label.setText( newName );
            }
        });

        nameOfPlayer2Label.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                String newName = JOptionPane.showInputDialog( null , "type new name : " );
                if ( newName != null )
                    nameOfPlayer2Label.setText( newName );
            }
        });


        // declaring radio buttons and grouping them
        sRadioButton = new JRadioButton( "S" , true );
        oRadioButton = new JRadioButton( "O" , true );

        buttonGroup = new ButtonGroup();
        buttonGroup.add( sRadioButton );
        buttonGroup.add( oRadioButton );

        // setting dimension
        dimension = 5;
        sosCanvasGame = new SOSCanvas( dimension );

        // adding labels and radio buttons to the panel
        labelsAndButtonsPanel = new JPanel();
        labelsAndButtonsPanel.add( nameOfPlayer1Label );
        labelsAndButtonsPanel.add( scoreOfPlayer1Label );
        labelsAndButtonsPanel.add( nameOfPlayer2Label );
        labelsAndButtonsPanel.add( scoreOfPlayer2Label );
        labelsAndButtonsPanel.add( sRadioButton );
        labelsAndButtonsPanel.add( oRadioButton );

        // setting border layout to the panel.
        setLayout( new BorderLayout() );
        add( labelsAndButtonsPanel , BorderLayout.SOUTH  );
        add( sosCanvasGame         , BorderLayout.CENTER );

        // setting mouse listener and indicating turn
        sosCanvasGame.addMouseListener( new MouseHandler() );
        indicateTurn();


        // arranging height and width.
        widthOfPanel  = ( dimension + 2 ) * getSosCanvasGame().getCellSide();
        heightOfPanel = ( dimension + 3 ) * getSosCanvasGame().getCellSide();

        // setting panels size.
        setPreferredSize( new Dimension( widthOfPanel  , heightOfPanel ) );
    }

    /**
     * gets the width of the panel
     * @return the width of the panel.
     */
    public int getWidthOfPanel()
    {
        return widthOfPanel;
    }

    /**
     * gets the width of the panel
     * @return the height of the panel.
     */
    public int getHeightOfPanel()
    {
        return heightOfPanel;
    }

    /**
     * gets all labels
     * @return all labels.
     */
    public JPanel getLabelsPanel()
    {
        JPanel panel = new JPanel();

        panel.add( new JLabel( nameOfPlayer1Label.getText() ) );
        panel.add( new JLabel( scoreOfPlayer1Label.getText() ) );
        panel.add( new JLabel( nameOfPlayer2Label.getText() ) );
        panel.add( new JLabel( scoreOfPlayer2Label.getText() ) );
        panel.setPreferredSize( new Dimension( 100 , 50 ) );
        return panel;
    }

    /**
     * indicates the turn of the players
     * through coloring their background.
     */
    public void indicateTurn()
    {
        if ( sosCanvasGame.getSosGame().getTurn() == 1 )
        {
            nameOfPlayer1Label.setBackground( Color.RED   );
            nameOfPlayer2Label.setBackground( Color.WHITE );
        }

        else if ( sosCanvasGame.getSosGame().getTurn() == 2 )
        {
            nameOfPlayer1Label.setBackground( Color.WHITE );
            nameOfPlayer2Label.setBackground( Color.RED   );
        }
    }

    /**
     * gets sosCanvasGame.
     * @return sosCanvasGame.
     */
    public SOSCanvas getSosCanvasGame()
    {
        return sosCanvasGame;
    }

    // Inner class : Mouse Handler
    private class MouseHandler extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent e)
        {
            super.mousePressed(e);

            // computes the indexes
            int rowIndex    = e.getY() / sosCanvasGame.getCellSide();
            int columnIndex = e.getX() / sosCanvasGame.getCellSide();

            // plays the turn
            if ( sRadioButton.isSelected() )
                sosCanvasGame.getSosGame().play( 's' , rowIndex , columnIndex );
            else if ( oRadioButton.isSelected() )
                sosCanvasGame.getSosGame().play( 'o' , rowIndex , columnIndex );

            // setting score labels of the game.
            scoreOfPlayer1Label.setText( " : " + sosCanvasGame.getSosGame().getPlayerScore1() + "" );
            scoreOfPlayer2Label.setText( " : " + sosCanvasGame.getSosGame().getPlayerScore2() + "" );

            // repainting and indicating the turn.
            repaint();
            indicateTurn();

            // printing board.
            sosCanvasGame.getSosGame().printBoard();

        }

    }

}