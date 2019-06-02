import javax.swing.*;
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

        // declaring SOSGUIPanel
        SOSGUIPanel sosGuiPanel = new SOSGUIPanel( "Player1" , "Player2" );

        // adding panel to frame
        frame.add( sosGuiPanel );

        // arranging height and width.
        int width = ( sosGuiPanel.getDimension() + 2 ) * sosGuiPanel.getSosCanvasGame().getCellSide() + 10 ;
        int height = ( sosGuiPanel.getDimension() + 3 ) * sosGuiPanel.getSosCanvasGame().getCellSide();

        // setting frame.
        frame.setSize( width , height );
        frame.setVisible( true );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

}
