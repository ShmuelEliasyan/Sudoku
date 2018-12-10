package com.example.galel.sudoku;

public class SudokuPuzzle {
    int[][] board;
    int x04;
    int x11;
    int x28;
    int x32;
    int x43;
    int x57;
    int x66;
    int x75;
    int x80;


    public SudokuPuzzle() {
        x04 = 0;
        x11 = 0;
        x28 = 0;
        x32 = 0;
        x43 = 0;
        x57 = 0;
        x66 = 0;
        x75 = 0;
        x80 = 0;
        board = new int[9][9];

    }

    public int[][] puzzle(){
        x04 = (int) (Math.random() * 9) + 1;
        x11 = (int) (Math.random() * 9) + 1;
        x28 = (int) (Math.random() * 9) + 1;
        x32 = (int) (Math.random() * 9) + 1;
        x43 = (int) (Math.random() * 9) + 1;
        x57 = (int) (Math.random() * 9) + 1;
        x66 = (int) (Math.random() * 9) + 1;
        x75 = (int) (Math.random() * 9) + 1;
        x80 = (int) (Math.random() * 9) + 1;
        board[0][4] = x04;
        board[1][1] = x11;
        board[2][8] = x28;
        board[3][2] = x32;
        board[4][3] = x43;
        board[5][7] = x57;
        board[6][6] = x66;
        board[7][5] = x75;
        board[8][0] = x80;

        Sudoku game = new Sudoku(board);
        int[][] temp = game.solve();
        int[][] newBoard = new int[9][9];
        int count = 0;
        while(count != 25){
            int i = (int)(Math.random()*8)+1;
            int j = (int)(Math.random()*8)+1;
            if(newBoard[i][j] == 0){
                newBoard[i][j] = temp[i][j];
                count++;
            }
        }
        return newBoard;
    }
}

/*int x03;
    int x11;
    int x28;
    int x32;
    int x44;
    int x56;
    int x65;
    int x77;
    int x80;*/

/*
    public SudokuPuzzle(){
        x03 = (int)(Math.random()*9)+1;
        x11 = (int)(Math.random()*9)+1;
        x28 = (int)(Math.random()*9)+1;
        x32 = (int)(Math.random()*9)+1;
        x44 = (int)(Math.random()*9)+1;
        x56 = (int)(Math.random()*9)+1;
        x65 = (int)(Math.random()*9)+1;
        x77 = (int)(Math.random()*9)+1;
        x80 = (int)(Math.random()*9)+1;

        board = new int[9][9];

        board[0][3] = x03;
        board[2][8] = x28;
        board[3][2] = x32;
        board[4][4] = x44;
        board[5][6] = x56;
        board[6][5] = x65;
        board[7][7] = x77;
        board[8][0] = x80;

        while(true){
            int y12 = (int)(Math.random()*9)+1;
            if(y12 != x32) {
                board[1][2] = y12;
                break;
            }
        }
        while(true){
            int y24 = (int)(Math.random()*9)+1;
            if(y24 != x28 && y24 != x44 && y24 != x03) {
                board[2][4] = y24;
                break;
            }
        }
        while(true){
            int y61 = (int)(Math.random()*9)+1;
            if(y61 != x80 && y61 != x65) {
                board[6][1] = y61;
                break;
            }
        }
        while(true){
            int y73 = (int)(Math.random()*9)+1;
            if(y73 != x77 && y73 != x03 && y73 != x65) {
                board[7][3] = y73;
                break;
            }
        }
        while(true){
            int y07 = (int)(Math.random()*9)+1;
            if(y07 != x77 && y07 != x03 && y07 != x28) {
                board[0][7] = y07;
                break;
            }
        }
        while(true){
            int y35 = (int)(Math.random()*9)+1;
            if(y35 != x32 && y35 != x65 && y35 != x44) {
                board[3][5] = y35;
                break;
            }
        }
        while(true){
            int y40 = (int)(Math.random()*9)+1;
            if(y40 != x80 && y40 != x44 && y40 != x32) {
                board[4][0] = y40;
                break;
            }
        }
        while(true){
            int y88 = (int)(Math.random()*9)+1;
            if(y88 != x80 && y88 != x28 && y88 != x77) {
                board[8][8] = y88;
                break;
            }
        }
        */

