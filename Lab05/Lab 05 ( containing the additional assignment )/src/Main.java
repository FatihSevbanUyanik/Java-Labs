import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * tests the classes SOSCanvas and SOSGUIPanel
 * @author Fatih Sevban Uyanik
 * @version 04,04,2018
 */
public class Main
{
    public static void main(String[] args)
    {
        // declaring JFrame
        JFrame frame = new JFrame( "SOS" );
        JLabel heading = new JLabel( "SOS GAME!!!" );

        // centering heading
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setVerticalAlignment(SwingConstants.CENTER);
        heading.setFont( new Font( "Arial" , Font.BOLD , 20 ) );
        heading.setPreferredSize( new Dimension( 500 , 20 ) );

        // declaring SOSGUIPanel

        SOSGUIPanel[] sosGuiPanels = {
                new SOSGUIPanel( "Player1" , "Player2" ),
                new SOSGUIPanel( "Player1" , "Player2" ),
                new SOSGUIPanel( "Player1" , "Player2" ),
                new SOSGUIPanel( "Player1" , "Player2" )
        };


        frame.setLayout( new FlowLayout());
        frame.add( heading );
        final JPanel panel = new JPanel();

        // adding panel to frame
        for ( SOSGUIPanel sosguiPanel : sosGuiPanels ) {
            frame.add(sosguiPanel);
            panel.add( sosguiPanel.getLabelsPanel() );
        }

        panel.setOpaque(true);
        panel.setBackground( Color.blue );
        frame.add( panel );


        // setting frame.
        frame.setSize( sosGuiPanels[0].getWidthOfPanel() * 2 + 200  , sosGuiPanels[0].getHeightOfPanel() * 2 + 200 );
        frame.setVisible( true );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        Timer timer = new Timer(0, e ->
        {
            panel.removeAll();
            for ( SOSGUIPanel sosguiPanel : sosGuiPanels )
                panel.add( sosguiPanel.getLabelsPanel() );
            frame.add( panel );

            // looking whether game is over.
            boolean isGameOver = true;

            for ( SOSGUIPanel sosguiPanel : sosGuiPanels )
                if ( sosguiPanel.getSosCanvasGame().getSosGame().isGameOver() == false )
                    isGameOver = false;

            if ( isGameOver == true )
            {
                JOptionPane.showMessageDialog( null  ,"Game Over"  );
                System.exit(0);
            }
        });

        timer.start();
    }

}
