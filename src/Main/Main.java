package Main;

import javax.swing.*;
import java.awt.*;
public class Main{
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Idk bro do you");
        window.setBackground(Color.BLACK);
        GamePanel zeGame = new GamePanel();
        window.add(zeGame);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        zeGame.startGameThread();


        
    }


}
