/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nekres
 */
public class Field {
    private static final int DEFAULT_FIELD_SIZE = 3;
    private static final char DEFAULT_CHAR = '_';
    private final char crossPawn = 'X';
    private final char zeroPawn = '0';
    private final int fieldSize;
    private final char FIELD[][];
    
    
    public Field(final int newFieldSize){
        this.fieldSize = newFieldSize;
        this.FIELD = new char[fieldSize][fieldSize];
        makeEmptyField();
    }
    public Field(){
        this.fieldSize = DEFAULT_FIELD_SIZE;
        this.FIELD = new char[DEFAULT_FIELD_SIZE][DEFAULT_FIELD_SIZE];
        makeEmptyField();
    }

    public int getFieldSize() {
        return fieldSize;
    }
    public void setField(final int x, final int y, final char pawn){
        FIELD[x][y] = pawn;
    }
    public char getFieldCell(int y, int x){
        return FIELD[y][x];
    }

    public char getCrossPawn() {
        return crossPawn;
    }

    public char getZeroPawn() {
        return zeroPawn;
    }
    
    private void makeEmptyField(){
        for (int i = 0; i < fieldSize; i++){
            makeEmptyLine(i);
        }
    }
    private void makeEmptyLine(int line){
        for (int i = 0; i < fieldSize; i++){
            FIELD[line][i] = DEFAULT_CHAR;
        }
    }

    public static char getDEFAULT_CHAR() {
        return DEFAULT_CHAR;
    }
    
    
    
}
