package com.malik.urfan.moon;

import org.junit.Test;
import static org.junit.Assert.*;

public class TerrainTest {

    @Test
    public void testFindLandingStartingPoint_SuitableGroundFound_Success() {
        Terrain terrain = new Terrain();

        int[] terrainArray = {0, 1, 2, 0, 1, 3, 1, 2, 2, 3, 1, 2, 3, 1, 1, 1, 0, 1, 2, 3, 3, 3, 1, 2, 2, 3, 1, 0, 2, 1};
        int[] windArray = {10, 15, 20, 30, 30, 20, 40, 40, 30, 20, 10, 15, 20, 10, 30, 10, 30, 15, 15, 5, 10, 10, 10, 20, 25, 35, 40, 50, 20, 15};

        int expectedLandingStartingPoint = 19;
        int actualLandingStartingPoint = terrain.findLandingStartingPoint(terrainArray, windArray);

        assertEquals(expectedLandingStartingPoint, actualLandingStartingPoint);
    }

    @Test(expected = NoLandingPointFoundRuntimeException.class)
    public void testFindLandingStartingPoint_NoLandingPointFound_Exception() {
        Terrain terrain = new Terrain();

        int[] terrainArray = {0, 1, 2, 0, 1, 3, 1, 2, 2, 3, 1, 2, 3, 1, 1, 1, 0, 1, 2, 3, 2, 3, 1, 2, 2, 3, 1, 0, 2, 1};
        int[] windArray = {10, 15, 20, 30, 30, 20, 40, 40, 30, 20, 10, 15, 20, 10, 30, 10, 30, 15, 15, 5, 10, 10, 10, 20, 25, 35, 40, 50, 20, 15};

        terrain.findLandingStartingPoint(terrainArray, windArray);
    }

    @Test(expected = NoLandingPointFoundRuntimeException.class)
    public void testFindLandingStartingPoint_StrongWinds_Exception() {
        Terrain terrain = new Terrain();

        int[] terrainArray = {0, 0, 0, 0, 1, 3, 1, 2, 2, 3, 1, 2, 3, 1, 1, 1, 0, 1, 2, 3, 3, 3, 1, 2, 2, 3, 1, 1, 1, 1};
        int[] windArray = {10, 15, 20, 30, 30, 20, 40, 40, 30, 20, 10, 15, 20, 10, 30, 10, 30, 15, 15, 20, 10, 10, 10, 20, 25, 35, 40, 50, 20, 15};

        terrain.findLandingStartingPoint(terrainArray, windArray);
    }

    @Test
    public void testFindLandingStartingPoint_OtherSuitableGroundFound_Success() {
        Terrain terrain = new Terrain();

        int allowableWindSpeedUpperLimit = 19;

        int[] terrainArray = {0, 1, 2, 0, 1, 3, 1, 2, 2, 3, 1, 2, 3, 1, 1, 1, 0, 1, 2, 3, 3, 3, 1, 2, 2, 3, 1, 0, 2, 1};
        int[] windArray = {10, 15, 20, 30, 30, 20, 40, 40, 30, 20, 10, 15, 20, 10, allowableWindSpeedUpperLimit, 10, 30, 15, 15, 5, 10, 10, 10, 20, 25, 35, 40, 50, 20, 15};

        int expectedLandingStartingPoint = 13;
        int actualLandingStartingPoint = terrain.findLandingStartingPoint(terrainArray, windArray);

        assertEquals(expectedLandingStartingPoint, actualLandingStartingPoint);
    }

}
