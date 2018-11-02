package com.example.questions;

import java.util.Arrays;
import java.util.List;

public class Rover_movement_Find_final_rover_position {


    public static final String LEFT = "left";
    public static final String RIGHT = "right";
    public static final String UP = "up";
    public static final String DOWN = "down";

    public static void main(String[] args) {


        List<String> commands = Arrays.asList(RIGHT, DOWN, LEFT, LEFT, DOWN);
        List<String> commands1 = Arrays.asList(RIGHT,RIGHT, DOWN);
        System.out.println(roverMove(4, commands1));

    }


    public static int roverMove(int matrixSize, List<String> cmds) {


        int[][] roverLand = createMatrix(matrixSize);
        int[][] roverPosition = new int[1][2];
        roverPosition[0][0] = 0;
        roverPosition[0][1] = 0;

        for (String cmd : cmds) {

            roverPosition = commandRover(roverLand, cmd, roverPosition);
        }
        int label = roverLand[roverPosition[0][0]][roverPosition[0][1]];
        return label;
    }


    public static int[][] createMatrix(int matrixSize) {
        int[][] roverLand = new int[matrixSize][matrixSize];

        int label = 0;

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {

                roverLand[i][j] = label;
                label++;

            }
        }

        return roverLand;
    }

    public static int[][] commandRover(int[][] roverLand, String cmd, int[][] roverPosition) {

        int size = roverLand.length;

        int yIndex = roverPosition[0][0];
        int xIndex = roverPosition[0][1];


        switch (cmd) {
            case UP:

                if (yIndex > 0) roverPosition[0][0]--;


                break;

            case DOWN:

                if (yIndex < size - 1) roverPosition[0][0]++;


                break;

            case LEFT:

                if (xIndex > 0) roverPosition[0][1]--;


                break;

            case RIGHT:

                if (xIndex < size - 1) roverPosition[0][1]++;

                break;
        }


        return roverPosition;

    }


}
