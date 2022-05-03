package main;

import entity.player;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    KeyHandler keyH = new KeyHandler();
    player player = new player(this,keyH);
    
    //FPS
    int FPS = 60;
    
    //Screen Settings
    final int OriginalTileSize = 16;
    final int Scale = 4;
    public int TileSize = Scale * OriginalTileSize;
    final int maxTileCol = 16;
    final int maxTileRow = 12;
    final int ScreenWidth = TileSize * maxTileCol; // Width = 1024
    final int ScreenHeight = TileSize * maxTileRow; // Length = 768

    public GamePanel()
    {

        this.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.requestFocus();
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.requestFocusInWindow();
        //add Component
        this.addKeyListener(keyH);
    }
    Thread gamethread = new Thread();

    public void StartGameThread ()
    {
        gamethread = new Thread(this);
        gamethread.start();
    }

    @Override
    public void run() {

        while (gamethread != null)
        {
            long drawInterval = 1000000000/FPS;
            double nextDrawTime = System.nanoTime() + drawInterval;

            update();
            repaint();

            try {
                double RemainingTime = nextDrawTime - System.nanoTime();
                RemainingTime = RemainingTime/1000000;
                if (RemainingTime<0){RemainingTime = 0;}

                Thread.sleep((long) RemainingTime);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void update()
    {
        player.update();
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g);
        player.draw(g2);
        g2.dispose();
    }
}
