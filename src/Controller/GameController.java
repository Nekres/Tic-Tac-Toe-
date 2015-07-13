/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.InputMismatchException;
import model.Field;
import model.Player;
import view.ConsoleView;
/**
 *
 * @author Nekres
 */
public class GameController {
    private static final String DEFAULT_GAME_NAME = "XO";
    private final Player[] players;
    private final Field field;
    private final String gameName;
    
    public GameController(Player[] players, Field field, String gameName){
        this.players = players;
        this.field = field;
        this.gameName = gameName;
    }
    public GameController(Player[] players, Field field){
        this.players = players;
        this.field = field;
        this.gameName = DEFAULT_GAME_NAME;
    }
    public void makeMove(int x, int y, char pawn)throws Exception{
        boolean notCorrect = true;
        ConsoleView cv = new ConsoleView();
            while(notCorrect){
        try {
        if (field.getFieldCell(x-1, y-1) == '_') {
            field.setField(x-1, y-1, pawn);
            notCorrect = false;
        }
        else {
            System.out.println("Error - Cell is not empty. Make move again.");
            x = cv.printCoordinates('x');
            y = cv.printCoordinates('y');
        }
        }
        catch (ArrayIndexOutOfBoundsException | InputMismatchException ex){
            System.out.println("Illegal coordinate. Make move again");
            x = cv.printCoordinates('x');
            y = cv.printCoordinates('y');
        }
    }
    }
    public boolean noWinner(){
        // TODO checks by diag, rows and lines
        if (checkField() && (checkLines()  == Field.getDEFAULT_CHAR() ) && (checkRows() == Field.getDEFAULT_CHAR())
                && (checkAllDiags() == Field.getDEFAULT_CHAR())){
            return true;
        }
       return false; 
    }
    public char getWinner(){
        char winner = Field.getDEFAULT_CHAR();
        if (checkLines() != Field.getDEFAULT_CHAR()) {
            winner = checkLines();
        }
        if (checkRows() != Field.getDEFAULT_CHAR()){
            winner = checkRows();
        }
        if (checkAllDiags() != Field.getDEFAULT_CHAR()){
            winner = checkAllDiags();
        }
        return winner;
    }
    public String getGameName() {
        return gameName;
    }
    private char checkLines(){
        char win = Field.getDEFAULT_CHAR();
        for (int i = 0; i < field.getFieldSize(); i++){
            if (checkLine(i) != Field.getDEFAULT_CHAR()){
                win = checkLine(i);
            }
        }
        
        return win;
    }
    private char checkRows(){
        char win = Field.getDEFAULT_CHAR();
        for (int i = 0; i < field.getFieldSize(); i++){
            if (checkRow(i) != Field.getDEFAULT_CHAR()){
                win = checkRow(i);
            }
        }
        return win;
    }
    private char checkLine(int cell){
        char win = Field.getDEFAULT_CHAR();
        int crossCount = 0;
        int zeroCount = 0;
        for (int i = 0; i < field.getFieldSize(); i++){
            if (field.getFieldCell(i, cell) == field.getCrossPawn()) {
                crossCount++;
            }
            if (field.getFieldCell(i, cell) == field.getZeroPawn()) {
                zeroCount++;
            } 
           win = getCounters(crossCount, zeroCount);
                }
        return win;
    }
    private char checkRow(int cell){
       char win = Field.getDEFAULT_CHAR();
        int crossCount = 0;
        int zeroCount = 0;
        
        for (int i = 0; i < field.getFieldSize(); i++){
            if (field.getFieldCell(cell, i) == field.getCrossPawn()) {
                crossCount++;
            }
            if (field.getFieldCell(cell, i) == field.getZeroPawn()) {
                zeroCount++;
            } 
            win = getCounters(crossCount, zeroCount);
        }
        return win;
    }
    private char getCounters(int crossCount, int zeroCount){ 
     char win = Field.getDEFAULT_CHAR();
     if (crossCount == field.getFieldSize()){
                win = field.getCrossPawn();
            }
            if (zeroCount == field.getFieldSize()) {
                win = field.getZeroPawn();
            }
            return win;
 }
    private boolean checkField(){
        for (int i = 0; i < field.getFieldSize(); i++) {
            if (checkEachLine(i) >= 1){
                return true;
            }
        }
        return false;
    }
    private int checkEachLine(int line){
        int freeCellCounter = 0;
        for (int i = 0; i < field.getFieldSize(); i++){
            if (field.getFieldCell(i, line) == Field.getDEFAULT_CHAR()){
                freeCellCounter++;
            }
        }
        return freeCellCounter;
    }
    private char checkAllDiags(){
        char win = Field.getDEFAULT_CHAR();
        if (checkMainDiag() != Field.getDEFAULT_CHAR()){
            return checkMainDiag();
        }
        if (checkSecondDiag() != Field.getDEFAULT_CHAR()) {
            return checkSecondDiag();
        }
        return win;
    }
    private char checkMainDiag(){
    char win = Field.getDEFAULT_CHAR();
    int crossCount = 0;
    int zeroCount = 0;
        for (int i = 0;i < field.getFieldSize(); i++){
            if (field.getFieldCell(i, i) == field.getCrossPawn()) {
                crossCount++;
            }
            if (field.getFieldCell(i, i) == field.getZeroPawn()) {
                zeroCount++;
            }
            win = getCounters(crossCount, zeroCount);
    }
    
    return win;
}
    private char checkSecondDiag(){
        char win = Field.getDEFAULT_CHAR();
        int crossCount = 0;
        int zeroCount = 0;
        
        for (int i = 0, j = field.getFieldSize()-1;i < field.getFieldSize(); i++,j--){
            if (field.getFieldCell(i, j) == field.getCrossPawn()) {
                crossCount++;
            }
            if (field.getFieldCell(i, j) == field.getZeroPawn()) {
                zeroCount++;
            }
            win = getCounters(crossCount, zeroCount);
    }
    return win;
    }
}
