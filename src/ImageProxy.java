import java.net.*;
import java.awt.*;
import javax.swing.*;

class ImageProxy implements Icon{
	State imageLoadedState;
	State imageNotLoadedState;

	State state;

	volatile ImageIcon imageIcon;
	final URL imageURL;
	Thread retrievalThread;
	boolean retrieving = false;

	public ImageProxy(URL url) {

		imageURL = url;
		imageLoadedState = new ImageLoadedState(this);
		imageNotLoadedState = new ImageNotLoadedState(this);
		
		if(imageIcon != null) {
			state = imageLoadedState;
		} else {
			state = imageNotLoadedState;
		}
		
	}
	
	public int getIconWidth() {
		return state.getIconWidth();
	}
	
	public int getIconHeight() {
		return state.getHeight();
	}
	
	public void paintIcon(final Component c, Graphics  g, int x,  int y) {
		state.paintIcon(c, g, x, y);
	}

	synchronized void setImageIcon(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public State getState() {
		return this.state;
	}
	
	public State getImageLoadedState() {
		return this.imageLoadedState;
	}
	
	public State getImageNotLoadedState() {
		return this.imageNotLoadedState;
	}

	
}
