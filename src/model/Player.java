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
public class Player {
    private final String name;
    private final Pawn pawn;
    
    public Player(String name,Pawn pawn){
        this.name = name;
        this.pawn = pawn;
    }

    public Pawn getPawn() {
        return pawn;
    }
    public String getPlayerName(){
        return name;
    }
    
    
    }

