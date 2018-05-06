package Game;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class ShootingMissilesEx extends JFrame {
	
	
	private int WIDTH = 1000;
	private int HEIGHT = 1000;


    public ShootingMissilesEx() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Window());
        
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        
        setTitle("Shooting missiles");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            ShootingMissilesEx ex = new ShootingMissilesEx();
            ex.setVisible(true);
        });
    }
}