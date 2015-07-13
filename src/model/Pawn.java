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
public class Pawn {
    private final char pawn;
    
    public Pawn(char pawn){
        this.pawn = pawn;
    }
    public char getPlayerPawn(){
        return pawn;
    }
}
