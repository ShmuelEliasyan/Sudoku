package com.example.galel.sudoku;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText[][] box;
    Button Start, Solve, Reset, Hint, checkWin;
    Sudoku gameLauncher, solution;
    SudokuPuzzle gamePuzzle;
    int countHowManyHint;
    int[][] board, sol;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countHowManyHint = 0;
        box = new EditText[9][9];
        box[0][0]=(EditText)findViewById(R.id.box00); box[0][1]=(EditText)findViewById(R.id.box01); box[0][2]=(EditText)findViewById(R.id.box02);
        box[0][3]=(EditText)findViewById(R.id.box03); box[0][4]=(EditText)findViewById(R.id.box04); box[0][5]=(EditText)findViewById(R.id.box05);
        box[0][6]=(EditText)findViewById(R.id.box06); box[0][7]=(EditText)findViewById(R.id.box07); box[0][8]=(EditText)findViewById(R.id.box08);

        box[1][0]=(EditText)findViewById(R.id.box10); box[1][1]=(EditText)findViewById(R.id.box11); box[1][2]=(EditText)findViewById(R.id.box12);
        box[1][3]=(EditText)findViewById(R.id.box13); box[1][4]=(EditText)findViewById(R.id.box14); box[1][5]=(EditText)findViewById(R.id.box15);
        box[1][6]=(EditText)findViewById(R.id.box16); box[1][7]=(EditText)findViewById(R.id.box17); box[1][8]=(EditText)findViewById(R.id.box18);

        box[2][0]=(EditText)findViewById(R.id.box20); box[2][1]=(EditText)findViewById(R.id.box21); box[2][2]=(EditText)findViewById(R.id.box22);
        box[2][3]=(EditText)findViewById(R.id.box23); box[2][4]=(EditText)findViewById(R.id.box24); box[2][5]=(EditText)findViewById(R.id.box25);
        box[2][6]=(EditText)findViewById(R.id.box26); box[2][7]=(EditText)findViewById(R.id.box27); box[2][8]=(EditText)findViewById(R.id.box28);

        box[3][0]=(EditText)findViewById(R.id.box30); box[3][1]=(EditText)findViewById(R.id.box31); box[3][2]=(EditText)findViewById(R.id.box32);
        box[3][3]=(EditText)findViewById(R.id.box33); box[3][4]=(EditText)findViewById(R.id.box34); box[3][5]=(EditText)findViewById(R.id.box35);
        box[3][6]=(EditText)findViewById(R.id.box36); box[3][7]=(EditText)findViewById(R.id.box37); box[3][8]=(EditText)findViewById(R.id.box38);

        box[4][0]=(EditText)findViewById(R.id.box40); box[4][1]=(EditText)findViewById(R.id.box41); box[4][2]=(EditText)findViewById(R.id.box42);
        box[4][3]=(EditText)findViewById(R.id.box43); box[4][4]=(EditText)findViewById(R.id.box44); box[4][5]=(EditText)findViewById(R.id.box45);
        box[4][6]=(EditText)findViewById(R.id.box46); box[4][7]=(EditText)findViewById(R.id.box47); box[4][8]=(EditText)findViewById(R.id.box48);

        box[5][0]=(EditText)findViewById(R.id.box50); box[5][1]=(EditText)findViewById(R.id.box51); box[5][2]=(EditText)findViewById(R.id.box52);
        box[5][3]=(EditText)findViewById(R.id.box53); box[5][4]=(EditText)findViewById(R.id.box54); box[5][5]=(EditText)findViewById(R.id.box55);
        box[5][6]=(EditText)findViewById(R.id.box56); box[5][7]=(EditText)findViewById(R.id.box57); box[5][8]=(EditText)findViewById(R.id.box58);

        box[6][0]=(EditText)findViewById(R.id.box60); box[6][1]=(EditText)findViewById(R.id.box61); box[6][2]=(EditText)findViewById(R.id.box62);
        box[6][3]=(EditText)findViewById(R.id.box63); box[6][4]=(EditText)findViewById(R.id.box64); box[6][5]=(EditText)findViewById(R.id.box65);
        box[6][6]=(EditText)findViewById(R.id.box66); box[6][7]=(EditText)findViewById(R.id.box67); box[6][8]=(EditText)findViewById(R.id.box68);

        box[7][0]=(EditText)findViewById(R.id.box70);box [7][1]=(EditText)findViewById(R.id.box71); box[7][2]=(EditText)findViewById(R.id.box72);
        box[7][3]=(EditText)findViewById(R.id.box73);box [7][4]=(EditText)findViewById(R.id.box74); box[7][5]=(EditText)findViewById(R.id.box75);
        box[7][6]=(EditText)findViewById(R.id.box76);box [7][7]=(EditText)findViewById(R.id.box77); box[7][8]=(EditText)findViewById(R.id.box78);

        box[8][0]=(EditText)findViewById(R.id.box80);box [8][1]=(EditText)findViewById(R.id.box81);box [8][2]=(EditText)findViewById(R.id.box82);
        box[8][3]=(EditText)findViewById(R.id.box83);box [8][4]=(EditText)findViewById(R.id.box84);box [8][5]=(EditText)findViewById(R.id.box85);
        box[8][6]=(EditText)findViewById(R.id.box86);box [8][7]=(EditText)findViewById(R.id.box87);box [8][8]=(EditText)findViewById(R.id.box88);

        Start = (Button)findViewById(R.id.Start);
        Solve = (Button)findViewById(R.id.Solve);
        Reset = (Button)findViewById(R.id.Reset);
        Hint = (Button)findViewById(R.id.Hint);
        checkWin = (Button)findViewById(R.id.checkWin);
        disable(false);

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disable(true);
                gamePuzzle = new SudokuPuzzle();
                board = gamePuzzle.puzzle();
                gameLauncher = new Sudoku(board);
                sol = gameLauncher.solve();
                for (int i = 0; i <board.length; i++) {
                    for (int j = 0; j < board.length; j++) {
                        if(board[i][j] != 0) {
                            box[i][j].setText(board[i][j] + "");
                        }else{
                            box[i][j].setText("");
                        }
                    }
                }
            }
        });

        Solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i <sol.length; i++) {
                    for (int j = 0; j < sol.length; j++) {
                        box[i][j].setText(sol[i][j] + "");
                    }
                }
            }
        });

        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disable(false);
                countHowManyHint = 0;
                for (int i = 0; i <sol.length; i++) {
                    for (int j = 0; j < sol.length; j++) {
                        box[i][j].setText("");
                    }
                }
            }
        });

        Hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean found = false;
                if(countHowManyHint < 5) {
                    while (found == false) {
                        int i = (int) (Math.random() * 9);
                        int j = (int) (Math.random() * 9);
                        if (box[i][j].getText().toString().equals("")) {
                            box[i][j].setText(sol[i][j]+"");
                            found = true;
                            countHowManyHint++;
                        }
                    }
                    Toast.makeText(MainActivity.this, "Yoh use " + countHowManyHint + " / 5 hint left", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Yoh used all of your hint!", Toast.LENGTH_LONG).show();
                }
            }
        });

        checkWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean iswin = true;
                for (int i = 0; i < box.length; i++) {
                    for (int j = 0; j < box.length; j++) {
                        String s = sol[i][j] + "";
                        if(!box[i][j].getText().toString().equals(sol[i][j]+"")){
                            iswin = false;
                        }
                    }
                }
                if(iswin == true){
                    Toast.makeText(MainActivity.this, "Yoh solve this game! good work!", Toast.LENGTH_LONG).show();

                }else{
                    checkGame(box,sol);
                }
            }
        });
    }

    public void disable(boolean turnOff){
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box.length; j++) {
                box[i][j].setEnabled(turnOff);
            }
        }
        Solve.setEnabled(turnOff);
        Reset.setEnabled(turnOff);
        Hint.setEnabled(turnOff);
        checkWin.setEnabled(turnOff);
    }

    public void checkGame(EditText[][] box, int[][] solution){
        int check = 0;
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box.length; j++) {
                if(box[i][j].getText().toString().equals("")){

                }
                else if(!box[i][j].getText().toString().equals(sol[i][j]+"")){
                    box[i][j].setTypeface(null, Typeface.BOLD);
                    box[i][j].setTextColor(Color.parseColor("#ff0000"));
                    check = 1;
                }else{
                    box[i][j].setTypeface(null, Typeface.NORMAL);
                    box[i][j].setTextColor(Color.parseColor("#000000"));
                }
            }
        }
        if(check == 1) {
            Toast.makeText(MainActivity.this, "Oh! You have a mistake! please try again", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this, "Nice! You don't have mistakes! but your board isn't full!", Toast.LENGTH_LONG).show();
        }
    }
}
