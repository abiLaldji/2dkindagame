package Game;


public class Missile extends Mobile {
	
	private final int SPEED = 4;
	private final int mesure = 70;

    public Missile(int x, int y, int direction) {
        super(x, y);  
        initMissile();
        launchMissile(direction);
        
        
    }
    
    private void initMissile() {
        
        loadImage("images/missile.png");  
        resizeImage(this.image, mesure, mesure);
        getImageDimensions();
    }
    
    private void launchMissile(int direction) {
    	switch (direction) {
    		case 1: setDy(-SPEED); break;
    		case 2: setDy(SPEED); break;
    		case 3: setDx(-SPEED); break;
    		case 4: setDx(SPEED); break;
    	}
    }     
}