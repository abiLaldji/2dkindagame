package Game;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Mobile {

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    private int dx;
    private int dy;
    protected boolean visible;
    protected Image image;

    public Mobile(int x, int y) {

        this.x = x;
        this.y = y;
        visible = true;
    }

    protected void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }
    
    protected void resizeImage(Image image, int h ,int l) {
    	this.image = image.getScaledInstance(h, l, Image.SCALE_DEFAULT);
    }
    
    protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
        
    }    
    
    public void move() {
        x += dx;
        y += dy;
        if (x < 1) {
        	x = 900;
        	}
        	 
        if (y < 1) {
        	y = 900;
        	}
        
        if (y > 900) {
        	y = 1;
        	}
        
        if (x > 900) {
        	x = 1;
        } 
        
      
    }
    

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setDx(int direction) {
    	this.dx = direction;
    }
    
    public void setDy(int direction) {
    	this.dy = direction;
    }
    

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}