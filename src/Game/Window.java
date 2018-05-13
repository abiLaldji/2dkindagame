package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Window extends JPanel implements ActionListener {

    private final int SPAWN_X_1 = 100;
    private final int SPAWN_Y_1 = 500;
    private final int SPAWN_X_2 = 800;
    private final int SPAWN_Y_2 = 500;
    private final int DELAY = 10;
    private Timer timer;
    private Plane plane;
    private Plane plane2;

    public Window() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.CYAN);
        setDoubleBuffered(true);

        plane = new Plane(SPAWN_X_1, SPAWN_Y_1);
        plane2 = new Plane(SPAWN_X_2, SPAWN_Y_2);


        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g, plane);
        doDrawing(g, plane2);

        Toolkit.getDefaultToolkit().sync();
    }
    
    /*public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(degrees));
        //draw shape/image (will be rotated)
        g2d.setTransform(old);
        //things you draw after here will not be rotated
    }*/

    private void doDrawing(Graphics g, Plane plane) {

        Graphics2D g2d = (Graphics2D) g;
        
        g2d.drawImage(plane.getImage(), plane.getX(),
                plane.getY(), this);
        //g2d.rotate(Math.toRadians(45));

        List<Missile> missiles = plane.getMissiles();

        for (Missile missile : missiles) {
            
            g2d.drawImage(missile.getImage(), missile.getX(),
                    missile.getY(), this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        updateMissiles();
        updatePlane();

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

    private void updatePlane() {

        plane.move();
        plane2.move();
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