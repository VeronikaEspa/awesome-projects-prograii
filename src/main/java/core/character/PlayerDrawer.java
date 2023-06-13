package core.character;

import enumerators.Directions;
import interfaces.PlayerMovement;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class PlayerDrawer {
    public int worldX;

    public int worldY;
    public int speed;
    public BufferedImage upLeft, upRight, left1, right1, left2, left3, right2, right3, up1, up2;
    public Directions direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public int screenX;
    public int screenY;

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    public int getWorldY() {
        return worldY;
    }

    public int getWorldX() {
        return worldX;
    }

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public Rectangle solidArea;
    public boolean collision = false;

    public void update() {
    }
    public void draw(Graphics2D g2d) {
    }
}