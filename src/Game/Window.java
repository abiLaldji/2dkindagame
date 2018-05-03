package Game;

import java.awt.EventQueue;
import javax.swing.JFrame;
import Game.GamePanel;

public class Window extends JFrame {
    
    public Window() {

        initUI();
    }

    private void initUI() {

        add(new GamePanel());

        setSize(250, 200);

        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
    
    
}

