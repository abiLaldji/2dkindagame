package Game;

import javax.swing.JFrame;

public class Window extends JFrame{
	public Window() {
		setTitle("2d Dogfight");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new GamePanel(512, 512));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
