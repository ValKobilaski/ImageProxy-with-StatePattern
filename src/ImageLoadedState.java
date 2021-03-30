import java.awt.Component;
import java.awt.Graphics;

public class ImageLoadedState implements State, Icon {
	ImageProxy imageProxy;
	
	public ImageLoadedState(ImageProxy imageProxy) {
		this.imageProxy = imageProxy;
	}
	public int getIconWidth() {
		return imageProxy.imageIcon.getIconWidth();
	}
	 
	public int getIconHeight() {
		return imageProxy.imageIcon.getIconHeight();
	}
     
	public void paintIcon(final Component c, Graphics  g, int x,  int y) {
		imageProxy.imageIcon.paintIcon(c, g, x, y);
	}
	
}
