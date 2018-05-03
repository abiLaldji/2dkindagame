package Game;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	public GamePanel() {
	       initGamePanel();
	    }
	    
	    private void initGamePanel() {
	        
	        loadImage();
	        
	        int w = bardejov.getWidth(this);
	        int h =  bardejov.getHeight(this);
	        setPreferredSize(new Dimension(w, h));        
	    }
	    
	    private void loadImage() {
	        
	        ImageIcon ii = new ImageIcon("src/resources/bardejov.png");
	        bardejov = ii.getImage();        
	    }

	    @Override
	    public void paintComponent(Graphics g) {

	        g.drawImage(bardejov, 0, 0, null);
	    }
}