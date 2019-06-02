package ApplicationPackage;

import javax.swing.*;
/**
 * Creates the frame for the game.
 * @author Fatih Sevban Uyanik
 * @version 28,03,2018
 */
public class Lab04b
{
    public static void main(String[] args)
    {
        // creating frame
        JFrame frame = new JFrame( "Bursting for a challenge?" );

        // creating BalloonsGamePanel
        BalloonsGamePanel balloonsGamePanel = new BalloonsGamePanel();

        // adding panel to Frame
        frame.add( balloonsGamePanel );

        // adjusting frame
        frame.setVisible( true );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 500 , 500 );
    }

}