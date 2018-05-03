package Game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Image sky;
	
	public GamePanel() {
	       initGamePanel();
	    }
	    
	    private void initGamePanel() {
	        
	        loadImage();
	        
	        int w = sky.getWidth(this);
	        int h =  sky.getHeight(this);
	        setPreferredSize(new Dimension(w, h));        
	    }
	    
	    private void loadImage() {
	        
	        ImageIcon ii = new ImageIcon("images/sky.png");
	        sky = ii.getImage();        
	    }

	    @Override
	    public void paintComponent(Graphics g) {

	        g.drawImage(sky, 0, 0, null);
	    }
}