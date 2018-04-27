package Game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

	private static int width;
	private static int height;
	
	private Thread thread;
	private boolean running;
	
	private BufferedImage img;
	private Graphics2D g;
	
	
	public GamePanel(int width, int height) {
		this.width = width;
		this.height = height;
		
		setPreferredSize(new Dimension(width, height));
		setFocusable(true);
		requestFocus();
	}
	
	public void addNotify() {
		super.addNotify();
		
		if(thread == null) {
			thread = new Thread(this, "GameThread");
			thread.start();
		}
	}
	
	public void init(){
		running = true;
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g = (Graphics2D) img.getGraphics();
	}
	
	public void run() {
		init();
		
	
		while(running) {
			update();
			renders();
			draw();
			
		}
	}
	
	public void update() {
		
	}
	
	public void renders() {
		
	}
	
	public void draw() {
		Graphics g2 = (Graphics) this.getGraphics();
		
		
	}

}
