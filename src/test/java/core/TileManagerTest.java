package core;

import org.junit.Before;
import org.junit.Test;
import view.TileManager;
import view.WorldHandler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TileManagerTest {

    private TileManager tileManager;

    @Before
    public void setUp() {
        WorldHandler gameWindow = new WorldHandler();
        tileManager = new TileManager(gameWindow);
        tileManager.loadTileImages();
    }

    @Test
    public void testParseMaze() {
        String filePath = "./src/main/resources/mazes/level1.txt";
        tileManager.parseMaze(filePath);

        int[][] mapTileNum = tileManager.getMapTileNum();
        assertNotNull(mapTileNum);

        assertEquals(0, mapTileNum[0][0]);
        assertEquals(1, mapTileNum[1][1]);
        assertEquals(2, mapTileNum[1][2]);
    }
}
