package Main;

import javax.swing.*;
import java.awt.*;

public class Test extends JPanel implements Runnable {
    Thread runner;
    KeyHandler keyH = new KeyHandler();
    public Test() {

        this.setPreferredSize(new Dimension(12*48,16*48));
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.setVisible(true);
        this.runner = new Thread(this);
        this.runner.start();
    }

    @Override
    public void run() {
        System.out.println("ya");
    }

    public static void main(String[] args) {

        new Test();
    }


}
