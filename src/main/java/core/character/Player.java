package core.character;

import enumerators.Directions;
import enumerators.TransportTypes;
import interfaces.PlayerMovement;
import view.WorldHandler;

import java.awt.*;

public class Player extends PlayerDrawer implements PlayerMovement {
    WorldHandler gameWindow;
    KeyHandler keyHandler;
    private TransportTypes currentTransport;

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }

    public Player(WorldHandler gameWindow, KeyHandler keyHandler) {
        super();
        this.gameWindow = gameWindow;
        this.keyHandler = keyHandler;
        this.screenX = gameWindow.getScreenWidth() / 2 - (gameWindow.getOriginalSize() / 2);
        this.screenY = gameWindow.getScreenHeight() / 2 - (gameWindow.getOriginalSize() / 2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 12;
        solidArea.height = 32;
        currentTransport = TransportTypes.FOOT;
        setDefaultValue();
    }

    public void setDefaultValue() {
        worldX = gameWindow.getOriginalSize() * 1;
        worldY = gameWindow.getOriginalSize() * 1;
        speed = 4;
        direction = Directions.RIGHT;
    }

    public void update() {
        if (keyHandler.inputKeyEvent) {
            if (keyHandler.getKeyName() == "upPressed") {
                direction = Directions.UP;
            }
            if (keyHandler.getKeyName() == "downPressed") {
                direction = Directions.DOWN;
            }
            if (keyHandler.getKeyName() == "leftPressed") {
                direction = Directions.LEFT;
            }
            if (keyHandler.getKeyName() == "rightPressed") {
                direction = Directions.RIGHT;
            }

            collision = false;
            gameWindow.getCollisionChecker().checkTile(this);
            updatePlayerSpeed();

            if (collision == false) {
                switch (direction) {
                    case UP:
                        worldY -= speed;
                        break;
                    case DOWN:
                        worldY += speed;
                        break;
                    case LEFT:
                        worldX -= speed;
                        break;
                    case RIGHT:
                        worldX += speed;
                        break;
                }
            }
        }
    }

    public void updatePlayerSpeed() {
        switch (currentTransport) {
            case FOOT -> this.speed = TransportTypes.FOOT.getSpeed();
            case HORSE -> this.speed = TransportTypes.HORSE.getSpeed();
            case BOAT -> this.speed = TransportTypes.BOAT.getSpeed();
            case CARPET -> this.speed = TransportTypes.CARPET.getSpeed();
        }
    }

    public TransportTypes getCurrentTransport() {
        return currentTransport;
    }

    public void setCurrentTransport(TransportTypes currentTransport) {
        this.currentTransport = currentTransport;
    }

    public Point getPosition() {
        return new Point(screenX, screenY);
    }

    public Directions getDirection() {
        return direction;
    }


}