package Game;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Plane extends Mobile {

    private int dx;
    private int dy;
    private List<Missile> missiles;

    public Plane(int x, int y) {
        super(x, y);
        
        initPlane();
    }

    private void initPlane() {

        missiles = new ArrayList<>();
        
        loadImage("images/plane.png"); 
        resizeImage(this.image,100, 100);
        getImageDimensions();
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

    public List<Missile> getMissiles() {
        return missiles;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            fire();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }
    }
    
    public void keyPressed2(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_C) {
            fire();
        }

        if (key == KeyEvent.VK_Q) {
            dx = -2;
        }

        if (key == KeyEvent.VK_D) {
            dx = 2;
        }

        if (key == KeyEvent.VK_Z) {
            dy = -2;
        }

        if (key == KeyEvent.VK_S) {
            dy = 2;
        }
    }
    
    

    public void fire() {
        missiles.add(new Missile(x + width, y + height / 2));
    }

    public void keyReleased2(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_Q) {
            dx = 0;
        }

        if (key == KeyEvent.VK_D) {
            dx = 0;
        }

        if (key == KeyEvent.VK_Z) {
            dy = 0;
        }

        if (key == KeyEvent.VK_S) {
            dy = 0;
        }
    }
    
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
  
}