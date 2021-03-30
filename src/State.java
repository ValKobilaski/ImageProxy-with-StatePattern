import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;

public interface State {
    
	public int getIconWidth();
 
	public int getIconHeight();
     
	public void paintIcon(final Component c, Graphics  g, int x,  int y);

}
