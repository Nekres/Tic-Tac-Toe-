/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.GameController;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Field;
import model.Player;

/**
 *
 * @author Nekres
 */
public class ConsoleView {
    private final int fieldSize;
    private static final int DEFAULT_FIELD_SIZE = 3;
    private final Field field ;
    private final Player players[];
    public ConsoleView(Field field, Player players[]){
        this.fieldSize = field.getFieldSize();
        this.field = field;
        this.players = players;
    }
    public ConsoleView(){
        this.fieldSize = DEFAULT_FIELD_SIZE;
        this.field = new Field();
        this.players = null;
    }
    
    public void showField(){
        for (int i = 0; i < fieldSize; i++){
            showLine(i);
        }
    }
    private void showLine(int line){
        for (int i = 0; i < fieldSize; i++){
            System.out.print(field.getFieldCell(i, line)+ "  ");
        }
        System.out.println();
    }
    public void showPawn(Player player){
        System.out.println("Your pawn is " +(player.getPawn().getPlayerPawn()));
        
    }
    public void moveComplete(){
        System.out.println("Move done. Next!");
    }
    public int printCoordinates(char coordinate){
        int x;
        try{
        Scanner scan = new Scanner(System.in);
        System.out.print(coordinate + ":");
        x = scan.nextInt();
        return x;
        }
        catch (InputMismatchException ime){
        return -1;
        }
    }
    public void showGameName(GameController gm){
        System.out.println(gm.getGameName()+ " begins!");
    }
    public void printWinner(GameController gm){
        if (gm.getWinner() == Field.getDEFAULT_CHAR()){
            System.out.println("Ничья");
        }
        if (gm.getWinner() == 'X'){
            System.out.println(players[0].getPlayerName() + " wins!");
        }
        if (gm.getWinner() == '0'){
            System.out.println(players[1].getPlayerName() + " wins!"); 
        }
    }
    
}
