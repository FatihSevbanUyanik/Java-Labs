package Shape;
/**
 * adds selectable features to a class.
 * @author Fatih Sevban Uyanik
 * @version 14,03,2018
 */
public interface Selectable
{
    boolean getSelected();
    void setSelected( boolean b );
    Shape contains( double x, double y);
}
