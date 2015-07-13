/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.GameController;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Nekres
 */
public class Menu {
    private static final int START = 1;
    private static final int EXIT = 2;
    private static int x;
    
    
    public static void showMenu() {
        System.out.println(START + " - Start");
        System.out.println(EXIT + " - Exit");
        System.out.print(">:");
        Scanner scan = new Scanner(System.in);
        try{
        GameController gm = new GameController(null, null);
        x = scan.nextInt();
        switch(x){
            case START:
                break;
            case EXIT:
                System.out.println("Interrupted.");
                System.exit(0);
            default:
                System.out.println("Game started.");
        }
            
        }
        catch (InputMismatchException ime){
            System.out.println("Really?");
                }  
        }
    }
    

