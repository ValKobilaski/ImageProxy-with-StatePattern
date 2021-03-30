import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class ImageNotLoadedState implements State, Icon {
	ImageProxy imageProxy;
	
	public ImageNotLoadedState(ImageProxy imageProxy) {
		this.imageProxy = imageProxy;
	}
	
	public int getIconWidth() {
		return 800;
	}
	 
	public int getIconHeight() {
		return 600;
	}
     
	public void paintIcon(final Component c, Graphics  g, int x,  int y) {
		g.drawString("Loading album cover, please wait...", x + 300, y + 190);
		if (!imageProxy.retrieving) {
			imageProxy.retrieving = true;

			imageProxy.retrievalThread = new Thread(new Runnable() {
				public void run() {
					try {
						imageProxy.setImageIcon(new ImageIcon(imageProxy.imageURL, "Album Cover"));
						c.repaint();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

			imageProxy.retrievalThread = new Thread(() -> {
				try {
					imageProxy.setImageIcon(new ImageIcon(imageProxy.imageURL, "Album Cover"));
					c.repaint();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			imageProxy.retrievalThread.start();
		
		imageProxy.setState(imageProxy.getImageLoadedState());
	}
	}
	
}