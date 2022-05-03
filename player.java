package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public player (GamePanel gp , KeyHandler keyH)
    {
        this.gp = gp;
        this.keyH = keyH;
        DefaultsPlayerValues();
        getPlayerImage();
    }
    public void DefaultsPlayerValues()
    {
        //Player Settings
        x = 100;
        y= 100;
        speed = 4;
        direction = "right";

    }
    public void getPlayerImage()
    {
        try {
            up1= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("2D_MiniGame/res/player/boy_up_1.png")));
            up2= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("2D_MiniGame/res/player/boy_up_2.png")));
            down1= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("2D_MiniGame/res/player/boy_down_1.png")));
            down2= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("2D_MiniGame/res/player/boy_down_2.png")));
            left1= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("2D_MiniGame/res/player/boy_left_1.png")));
            left2= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("2D_MiniGame/res/player/boy_left_2.png")));
            right1= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("2D_MiniGame/res/player/boy_right_1.png")));
            right2= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("2D_MiniGame/res/player/boy_right_2.png")));
        }
        catch (IOException exception)
        {exception.printStackTrace();}
    }
    public void update()
    {
        //Go Down
        if (keyH.downpressed)
        {direction = "down";
            if (keyH.shiftpressed) {y += speed*1.3;}
            else y += speed;}
        //Go Right
        if (keyH.rightpressed)
        {direction = "right";
            if (keyH.shiftpressed) {x += speed*1.3;}
        else x += speed;
        }
        //Go Left
        if (keyH.leftpressed)
        {direction = "left";
            if (keyH.shiftpressed) {x -= speed*1.3;}
            else x -= speed;}
        //Go Up
        if (keyH.uppressed)
        {direction = "up";
            if (keyH.shiftpressed) {y -= speed*1.3;}
            else y -= speed;}
    }
    public void draw(Graphics2D g2)
    {
        BufferedImage image = null;
        switch (direction)
        {
            case "up":
                image = up1;
            break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }
        g2.drawImage(image,x,y,gp.TileSize, gp.TileSize, null);
    }
}
