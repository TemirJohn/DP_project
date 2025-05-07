package org.Temirjohn.entity.enemies;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;

import org.Temirjohn.entity.Direction;
import org.Temirjohn.entity.Entity;


public class Enemy extends Entity implements IEnemy {
    // Attributes
    protected int speed = 2;	// Pixels per update. Default is 2
    protected int distTraveled = 0;	// The distance traveled in pixels
    private EnemyType currentType;	// This is currently needed to keep track of the type of enemy it is
    protected int originalHealth;

    public Enemy(int x, int y, EnemyType type, Direction dir) {
        super(x, y, type.getSpritePath());
        this.setDirection(dir);
        this.setHealth(type.getHealth());
        this.setOriginalHealth(type.getHealth());
        this.setStrength(type.getStrength());
        this.setCollisionBox(new Rectangle(10,10));	// This might have to be updated

        switch(currentDirection) {
            case UP:
                this.angle = Math.toRadians(-90);
                break;
            case DOWN:
                this.angle = Math.toRadians(90);
                break;
            case LEFT:
                this.angle = Math.toRadians(180);
                break;
            case RIGHT:
                this.angle = Math.toRadians(0);
                break;
        }
        // Store the enemy type
        currentType = type;
    }


    protected void move() {
        updateDirection();

        switch(currentDirection) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
        }

        // Add to the distance traveled
        addDistance();

        if(distTraveled >= gp.getState().getLevel().getPathLength()) {
            gp.getState().getPlayer().removeHealth(health);
            destroy();
        }
    }

    private void updateDirection() {
        switch (this.currentDirection) {
            case UP:
                if(y % gp.TILE_SIZE == 0) {
                    int row = y / gp.TILE_SIZE;
                    int col = x / gp.TILE_SIZE;
                    if(row > 0) { // if not on top of screen
                        int nextTile = gp.getState().getLevel().getMap()[col][row - 1];
                        if(nextTile == 0) { // if tile above is not path
                            if(col != 0 && gp.getState().getLevel().getMap()[col - 1][row] == 1) { // if tile left is path
                                this.setDirection(Direction.LEFT);
                                this.setAngle(Math.toRadians(180));
                            }
                            else if(col != gp.MAX_SCREEN_COL && gp.getState().getLevel().getMap()[col + 1][row] == 1) { // if tile right is path
                                this.setDirection(Direction.RIGHT);
                                this.setAngle(Math.toRadians(0));
                            }
                        }
                    }
                }
                break;
            case DOWN:
                if(y % gp.TILE_SIZE == 0) {
                    int row = y / gp.TILE_SIZE;
                    int col = x / gp.TILE_SIZE;
                    if(row < gp.MAX_SCREEN_ROW - 1) { // if not on bottom of screen
                        int nextTile = gp.getState().getLevel().getMap()[col][row + 1];
                        if(nextTile == 0) { // if tile below is not path
                            if(col != 0 && gp.getState().getLevel().getMap()[col - 1][row] == 1) { // if tile left is path
                                this.setDirection(Direction.LEFT);
                                this.setAngle(Math.toRadians(180));
                            }
                            else if(col != gp.MAX_SCREEN_COL && gp.getState().getLevel().getMap()[col + 1][row] == 1) { // if tile right is path
                                this.setDirection(Direction.RIGHT);
                                this.setAngle(Math.toRadians(0));
                            }
                        }
                    }
                }
                break;
            case RIGHT:
                if(x % gp.TILE_SIZE == 0) {
                    int row = y / gp.TILE_SIZE;
                    int col = x / gp.TILE_SIZE;
                    if(col < gp.MAX_SCREEN_COL - 1) { // if not on right of screen
                        int nextTile = gp.getState().getLevel().getMap()[col + 1][row];
                        if(nextTile == 0) { // if tile right is not path
                            if(row != 0 && gp.getState().getLevel().getMap()[col][row - 1] == 1) { // if tile up is path
                                this.setDirection(Direction.UP);
                                this.setAngle(Math.toRadians(-90));
                            }
                            else if(row != gp.MAX_SCREEN_ROW && gp.getState().getLevel().getMap()[col][row + 1] == 1) { // if tile bottom is path
                                this.setDirection(Direction.DOWN);
                                this.setAngle(Math.toRadians(90));
                            }
                        }
                    }
                }
                break;
            case LEFT:
                if(x % gp.TILE_SIZE == 0) {
                    int row = y / gp.TILE_SIZE;
                    int col = x / gp.TILE_SIZE;
                    if(col > 0) { // if not on left of screen
                        int nextTile = gp.getState().getLevel().getMap()[col - 1][row];
                        if(nextTile == 0) { // if tile left is not path
                            if(row != 0 && gp.getState().getLevel().getMap()[col][row - 1] == 1) { // if tile up is path
                                this.setDirection(Direction.UP);
                                this.setAngle(Math.toRadians(-90));
                            }
                            else if(row != gp.MAX_SCREEN_ROW && gp.getState().getLevel().getMap()[col][row + 1] == 1) { // if tile bottom is path
                                this.setDirection(Direction.DOWN);
                                this.setAngle(Math.toRadians(90));
                            }
                        }
                    }
                }
                break;
        }
    }


    public void setOriginalHealth(int health) {
        originalHealth = health;
    }


    public int getOriginalHealth() { return originalHealth; }


    protected void addDistance() {
        distTraveled += speed;
    }


    public int getSpeed() { return speed; }


    public void setSpeed(int speed) {
        this.speed = speed;
    }


    @Override
    public void update() {
        // Move this enemy to the new position
        this.move();

        // TODO Other related update operations if needed
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        if(health <= 0) {
            destroy();
        }
    }


    public Enemy clone() {
        Enemy clone = new Enemy(x, y, currentType, currentDirection);
        clone.setHealth(this.getHealth());
        clone.setStrength(this.getStrength());
        clone.setCollisionBox(this.getCollisionBox());
        clone.x = this.x;
        clone.y = this.y;
        clone.gp = this.gp;
        clone.collision = this.collision;
        clone.angle = this.angle;
        return clone;
    }


    public EnemyManager getComposite() {
        return null;
    }


    public int getDistanceTraveled() {
        return distTraveled;
    }


    @Override
    public void setHealth(int health) {
        super.setHealth(health);
    }


    @Override
    public void setStrength(int strength) {
        super.setStrength(strength);
    }


    @Override
    public int hashCode() {
        return super.hashCode() + speed;
    }


    @Override
    public boolean equals(Object obj) {
        if(super.equals((Enemy)obj) && speed == ((Enemy)obj).speed)
            return true;
        return false;
    }


    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s", super.toString()));
        output.append(String.format("Speed: %d", speed));

        return output.toString();
    }

    @Override
    public void destroy() {
        gp.getState().getEnemyManager().remove(this);
    }

    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);
        if(getHealth() < getOriginalHealth()) {
            //System.out.println("drawing health bar");
            g2.setColor(Color.red);
            g2.fillRect(x, y - (2 * gp.SCALE) - (gp.TILE_SIZE / 8), (int)(((double)getHealth() / getOriginalHealth()) * gp.TILE_SIZE), gp.TILE_SIZE / 8);
            Stroke original = g2.getStroke();
            g2.setStroke(new BasicStroke(gp.SCALE));
            g2.setColor(Color.black);
            g2.drawRect(x, y - (2 * gp.SCALE) - (gp.TILE_SIZE / 8), gp.TILE_SIZE, gp.TILE_SIZE / 8);
            g2.setStroke(original);
        }
    }
}
