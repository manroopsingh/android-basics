package com.example.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Running_commands_on_a_board {

    /*
    There is a board (matrix). Every cell of the board contains one integer, which is 0 initially.

The following operations can be applied to the Query Board:
SetRow i x: change all values in the cells on row "i" to value "x".
SetCol j x: change all values in the cells on column "j" to value "x".
QueryRow i: output the sum of values on row "i".
QueryCol j: output the sum of values on column "j".

The board's dimensions are 256x256.
"i" and "j" are integers from 0 to 255.
"x" is an integer from 0 to 31.
Input:
Your program should read lines from standard input. Each line contains one of the above operations.
Output:
For each query, output the result of the query.

    */

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;

        int[][] board = new int[256][256];

        while ((line = in.readLine()) != null) {
            //System.out.println(line);
            command(line, board);
        }
    }


    public static void command(String cmd, int[][] board){

        String[] commands = cmd.split(" ");
        String method = commands[0];
        int index = 0;
        int value = 0;

        int query =0;

        if(method.equals("SetCol")|| method.equals("SetRow")){
            index = Integer.parseInt(commands[1]);
            value = Integer.parseInt(commands[2]);
        }else{
            index = Integer.parseInt(commands[1]);
        }

        switch(method){

            case "SetCol":

                for(int i = 0;i<=255;i++){
                    board[i][index] = value;
                }

                break;

            case "SetRow":

                for(int i = 0;i<=255;i++){
                    board[index][i] = value;
                }
                break;

            case "QueryCol":

                for(int i = 0;i<=255;i++){
                    query += board[i][index];
                }
                System.out.println(query);
                break;

            case "QueryRow":


                for(int i = 0;i<=255;i++){
                    query += board[index][i];
                }
                System.out.println(query);

                break;
        }



    }


}
