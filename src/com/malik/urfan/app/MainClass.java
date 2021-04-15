package com.malik.urfan.app;

import com.malik.urfan.moon.Terrain;

import java.util.Scanner;

public class MainClass {

    public static void main(String args[]) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter terrain levels, i.e. 1,2,3...or hit enter twice to see an example: ");
        String terrainLevels = myObj.nextLine();

        int[] terrainArray = null;
        int[] windArray = null;
        String[] stringArray;

        String windSpeeds = "";
        if (terrainLevels != null && terrainLevels.length() > 0) {
            stringArray = terrainLevels.split(",");
            terrainArray = stringArrayToIntArray(stringArray);
        } else {
            terrainArray = new int[]{0, 1, 2, 0, 1, 3, 1, 2, 2, 3, 1, 2, 3, 1, 1, 1, 0, 1, 2, 3, 3, 3, 1, 2, 2, 3, 1, 0, 2, 1};
        }

        System.out.println("Enter wind speeds, i.e. 10,20,30...or hit enter once to see an example: ");
        windSpeeds = myObj.nextLine();
        if (windSpeeds.length() > 0) {
            stringArray = windSpeeds.split(",");
            windArray = stringArrayToIntArray(stringArray);
        } else {
            windArray = new int[]{10, 15, 20, 30, 30, 20, 40, 40, 30, 20, 10, 15, 20, 10, 30, 10, 30, 15, 15, 5, 10, 10, 10, 20, 25, 35, 40, 50, 20, 15};
        }

        Terrain terrain = new Terrain();

        int lengthOfArrays = terrainArray.length;

        System.out.print("Terrain levels array = { ");
        for (int t = 0; t < lengthOfArrays; t++) {
            System.out.print(terrainArray[t] + " ");
        }
        System.out.println("}\n");

        System.out.print("Wind speeds array = { ");
        for (int w = 0; w < lengthOfArrays; w++) {
            System.out.print(windArray[w] + " ");
        }
        System.out.println("}\n");

        int actualLandingStartingPoint = terrain.findLandingStartingPoint(terrainArray, windArray);

        System.out.println("Output: " + actualLandingStartingPoint);

    }


    private static int[] stringArrayToIntArray(String[] stringArr) {
        int lengthOfArrays = stringArr.length;

        int[] intArr = new int[lengthOfArrays];

        for (int i = 0; i < lengthOfArrays; i++) {
            intArr[i] = Integer.parseInt(stringArr[i]);
        }
        return intArr;
    }

}
