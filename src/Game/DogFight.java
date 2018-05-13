package Game;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class DogFight extends JFrame {
	
	private int WIDTH = 1000;
	private int HEIGHT = 1000;


    public DogFight() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Window());
        
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        
        setTitle("Dogfight");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
        	DogFight ex = new DogFight();
            ex.setVisible(true);
        });
    }
}