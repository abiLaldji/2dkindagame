package Game;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Plane extends Mobile {


    private List<Missile> missiles;
    private Order direction = Order.UP;


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
    
    public void fire() {
    	switch (direction) {
    	case UP:
    		missiles.add(new Missile(x + width, y + height / 2, 1));
    		System.out.println("up");
    		break;
    	case DOWN:
            missiles.add(new Missile(x + width, y + height / 2, 2));
            break;
    	case LEFT:
            missiles.add(new Missile(x + width, y + height / 2, 3));
            break;
    	case RIGHT:    
            missiles.add(new Missile(x + width, y + height / 2, 4));
            break;
        default:
        	System.out.println("donne pas direction");
       }
    }


    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            fire();
        }

        if (key == KeyEvent.VK_LEFT) {
            setDx(-2);
            setDirection(Order.LEFT);
            
        }

        if (key == KeyEvent.VK_RIGHT) {
            setDx(2);
            setDirection(Order.RIGHT);

        }

        if (key == KeyEvent.VK_UP) {
            setDy(-2);
            setDirection(Order.UP);

        }

        if (key == KeyEvent.VK_DOWN) {
            setDy(2);
            setDirection(Order.DOWN);

        }
    }
    
    public void keyPressed2(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_C) {
            fire();
        }

        if (key == KeyEvent.VK_Q) {
            setDx(-2);
            setDirection(Order.LEFT);

        }

        if (key == KeyEvent.VK_D) {
            setDx(2);
            setDirection(Order.RIGHT);

        }

        if (key == KeyEvent.VK_Z) {
            setDy(-2);
            setDirection(Order.UP);

        }

        if (key == KeyEvent.VK_S) {
            setDy(2);
            setDirection(Order.DOWN);

        }
    }
    

    public void keyReleased2(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_Q) {
            setDx(0);
        }

        if (key == KeyEvent.VK_D) {
            setDx(0);
        }

        if (key == KeyEvent.VK_Z) {
            setDy(0);
        }

        if (key == KeyEvent.VK_S) {
            setDy(0);
        }
    }
    
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            setDx(0);
        }

        if (key == KeyEvent.VK_RIGHT) {
            setDx(0);
        }

        if (key == KeyEvent.VK_UP) {
            setDy(0);
        }

        if (key == KeyEvent.VK_DOWN) {
            setDy(0);
        }
    }
    
    public void setDirection(Order dir) {
    	this.direction = dir;
    }
    
    public Order getDirection() {
    	return this.direction;
    }
    
    public List<Missile> getMissiles() {
        return missiles;
    }
  
}