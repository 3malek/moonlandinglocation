package com.malik.urfan.moon;

public class Terrain {

    // 30m metres long
    final static int SIZE_OF_TERRAIN = 30;

    public int findLandingStartingPoint(int[] terrainLevels, int[] windSpeeds) {
        int landingSizeRequired = LunarModule.SIZE_OF_MODULE;
        int adjacentLeveledMetresCounter = 1;

        int i = 0;
        while (i < SIZE_OF_TERRAIN - 1) {
            if (terrainLevels[i] == terrainLevels[i + 1] &&
                    windSpeeds[i] < LunarModule.DANGEROUS_WIND_SPEED &&
                    windSpeeds[i+1] < LunarModule.DANGEROUS_WIND_SPEED) {
                adjacentLeveledMetresCounter++;
            } else {
                adjacentLeveledMetresCounter = 1;
            }
            if (adjacentLeveledMetresCounter == landingSizeRequired) {
                break;
            }
            i++;
        }
        if (adjacentLeveledMetresCounter < landingSizeRequired) {
            throw new NoLandingPointFoundRuntimeException("Error, no suitable landing ground found.");
        }
        // return starting point (not other adjacent points)
        return (i - 1);
    }

}
