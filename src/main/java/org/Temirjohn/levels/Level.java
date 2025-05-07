package org.Temirjohn.levels;

import org.Temirjohn.main.GamePanel;
import java.awt.Graphics2D;
import org.Temirjohn.entity.Direction;

/**
 * <p>
 * This class is responsible for loading and drawing the background tile map of the level.
 * Levels are designed by creating a space delimited text file containing the index of the
 * tile set to be drawn on each square of the map. The text file should have the same dimensions as
 * the screen, unless a world map and camera movement are being implemented.
 * <p>
 */
public abstract class Level implements iLevel {
    // The panel to draw the level in
    protected GamePanel gp;

    /* This array contains references to each of the distinct tiles that can be drawn in the level.
     * Think of this as your "artist's palette" when drawing a level. */
    protected MapTile[] tileSet;

    /* This 2D array contains the index of the tile in tileSet that is to be drawn on each tile of the screen.
     * This is the actual layout of the level. */
    protected int levelMap[][];

    // length of the path in pixels
    protected int pathLength;

    // Coordinates for the start point of the path. Default is (0,0)
    int startX = 0;
    int startY = 0;

    // Starting direction. Default is RIGHT
    Direction startDir = Direction.RIGHT;


    public Level() {
        gp = GamePanel.getInstance();
        tileSet = new MapTile[10];
        levelMap = new int[gp.MAX_SCREEN_COL][gp.MAX_SCREEN_ROW];
    }


    protected abstract void loadTileSet();


    protected abstract void loadMap();


    public void draw(Graphics2D g2) {
        int x = 0, y = 0;

        for(int row = 0; row < gp.MAX_SCREEN_ROW; row++) {
            for(int col = 0; col < gp.MAX_SCREEN_COL; col++) {
                int tileNum = levelMap[col][row];

                g2.drawImage(tileSet[tileNum].sprite, x, y, gp.TILE_SIZE, gp.TILE_SIZE, null);
                x += gp.TILE_SIZE;
            }

            x = 0;
            y += gp.TILE_SIZE;
        }
    }


    public int[][] getMap() { return levelMap; }


    public MapTile[] getTileSet() { return tileSet; }


    public int getPathLength() { return pathLength; }


    public int getStartX() { return startX; }


    public int getStartY() { return startY; }


    public Direction getStartDir() { return startDir; }
}
