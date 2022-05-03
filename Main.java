package main;

import javax.swing.*;

public class Main {
    static JFrame f = new JFrame();

    public static void  main(String[] args)
    {
        //Add to Main Frame
        GamePanel gamePanel = new GamePanel();
        f.add(gamePanel);
        gamePanel.StartGameThread();
        //Main Frame
        f.setTitle("2D Mini Game");
        f.setResizable(false);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}
