package Game;

import java.util.Random;

public class Cloud extends Mobile {
	private int minSize = 250;
	private int maxSize = 500;
		
	Random rand = new Random();
	private int size = rand.nextInt(maxSize - minSize + 1) + minSize;

	
	public Cloud(int x, int y) {
		super(x, y);
		initCloud();
	}
	
	private void initCloud() {
		loadImage("images/cloud.png");  
        resizeImage(this.image, size, size);
        getImageDimensions();
	}
	
	public void move1() {
		this.x += 1;
		
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
	
	public void move2() {
		this.x -= 1;
		
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
}
