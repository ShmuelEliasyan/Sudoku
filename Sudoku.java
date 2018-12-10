package com.example.shmueleliasyan.sudoku;

import java.util.Scanner;
public class Sudoku {
    private int[][] board;
    Scanner scan =new Scanner(System.in);

    public Sudoku(int[][] board){
        this.board=board.clone();
    }

    public boolean checkBoard(){
        for(int i=0;i<9;i++) {
            if(!checkRow(i)) {
                return false;
            }
        }
        for(int j=0;j<9;j++) {
            if(!checkColumn(j)) {
                return false;
            }
        }
        for(int square=0;square<9;square++) {
            if(!checkSquare(square)) {
                return false;
            }
        }
        return true;
    }

    public  boolean checkRow(int row){
        int[] count=new int[10];
        for(int i=0;i<9;i++) {
            count[board[row][i]]++;
        }
        for(int i=1;i<count.length;i++) {
            if(count[i]>1) {
                return false;
            }
        }
        return true;
    }

    public boolean checkColumn(int column){
        int[] count=new int[10];

        for(int i=0;i<9;i++) {
            count[board[i][column]]++;
        }
        for(int i=1;i<count.length;i++) {
            if(count[i]>1) {
                return false;
            }
        }
        return true;
    }

    public boolean checkSquare(int square){
        int row=(square/3)*3;
        int column=(square%3)*3;
        int[] count=new int[10];

        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                count[board[row+i][column+j]]++;
            }
        }
        for(int i=1; i<count.length; i++) {
            if(count[i]>1) {
                return false;
            }
        }
        return true;
    }

    public boolean isFull(){
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] solve(){
        board = solve(clone(board));
        return board;
    }

    private int[][] solve(int[][] board){
        Sudoku s = new Sudoku(board);
        if(s.isFull() && s.checkBoard()) {
            return board;
        }
        if(!s.checkBoard()) {
            return null;
        }
        int[][] temp;
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] == 0){
                    for(int option=1; option<=9; option++){
                        temp = clone(board);
                        temp[i][j] = option;
                        temp = solve(temp);
                        if(temp != null) {
                            return temp;
                        }
                    }
                    return null;
                }
            }
        }
        return null;
    }

    private int[][] clone(int[][] original){
        int[][] copy=original.clone();
        for(int i=0; i<original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }

}
