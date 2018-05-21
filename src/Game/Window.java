package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Window extends JPanel implements ActionListener {

    private final int SPAWN_X_1 = 100;
    private final int SPAWN_Y_1 = 500;
    private final int SPAWN_X_2 = 800;
    private final int SPAWN_Y_2 = 500;
	private final int MIN_SPAWN_CLOUD = 200;
	private final int MAX_SPAWN_CLOUD = 800;
	Random rand = new Random();
	private int location = rand.nextInt(MAX_SPAWN_CLOUD - MIN_SPAWN_CLOUD + 1) + MIN_SPAWN_CLOUD;
    private final int DELAY = 10;
    private Timer timer;
    private Plane plane;
    private Plane plane2;
    private Cloud cloud1;
    private Cloud cloud2;
    private Cloud cloud3;
    private Cloud cloud4;


    public Window() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        Color lightBlue= new Color(135,206,235);
        setBackground(lightBlue);
        setDoubleBuffered(true);

        plane = new Plane(SPAWN_X_1, SPAWN_Y_1);
        plane2 = new Plane(SPAWN_X_2, SPAWN_Y_2);
        cloud1 = new Cloud(location, location);
        cloud2 = new Cloud(location, location);
        cloud3 = new Cloud(location, location);
        cloud4 = new Cloud(location, location);

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawingCloud(g, cloud2);
        doDrawingCloud(g, cloud3);
        doDrawingCloud(g, cloud4);
        doDrawingPlane(g, plane);
        doDrawingPlane(g, plane2);
        doDrawingCloud(g, cloud1);
        

        Toolkit.getDefaultToolkit().sync();
    }


    private void doDrawingPlane(Graphics g, Plane plane) {

        Graphics2D g2d = (Graphics2D) g;
        
        g2d.drawImage(plane.getImage(), plane.getX(),
                plane.getY(), this);

        List<Missile> missiles = plane.getMissiles();

        for (Missile missile : missiles) {
            
            g2d.drawImage(missile.getImage(), missile.getX(),
                    missile.getY(), this);
        }
    }
    
    private void doDrawingCloud(Graphics g, Cloud cloud) {

        Graphics2D g2d = (Graphics2D) g;
        
        g2d.drawImage(cloud.getImage(), cloud.getX(),
                cloud.getY(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        updateMissiles();
        updateObjects();
        
        checkCollisions();
        check();
        repaint();

    }

    private void updateMissiles() {

        List<Missile> missiles = plane.getMissiles();
        List<Missile> missiles2 = plane2.getMissiles();


        for (int i = 0; i < missiles.size(); i++) {

            Missile missile = missiles.get(i);
            missile.move();       
        }
        
        for (int i = 0; i < missiles2.size(); i++) {

            Missile missile = missiles2.get(i);
            missile.move();
 
        }
    }

    private void updateObjects() {

        plane.move();
        plane2.move();
        cloud1.move1();
        cloud2.move2();
        cloud3.move1();
        cloud4.move2();
    }
    
    public void checkCollisions() {

        Rectangle r4 = plane2.getBounds();
        Rectangle r3 = plane.getBounds();
        
        List<Missile> ms2 = plane2.getMissiles();
        List<Missile> ms = plane.getMissiles();
        
        if (r4.intersects(r3)) {
        	System.out.println("ouch");
        }
        
        for (Missile m : ms) {
        	Rectangle r1 = m.getBounds();
        	if (r4.intersects(r1)) {   
        		System.out.println("GO");
                m.setVisible(false);
                plane.setVisible(false);
            }
        }
        
        for (Missile m2 : ms2) {
    		Rectangle r2 = m2.getBounds();
            if (r2.intersects(r3)) {
            	m2.setVisible(false);
            	plane.setVisible(false);
                }
            }
        }
    
    public void check() {
    	if (collision()) {
    		System.out.println("check");
    	}
    }
    
    private boolean collision() {
		return plane.getBounds().intersects(plane2.getBounds());
	}
    

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            plane.keyReleased(e);
            plane2.keyReleased2(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            plane.keyPressed(e);
            plane2.keyPressed2(e);
        }
    }
}