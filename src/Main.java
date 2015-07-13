
import Controller.GameController;
import java.util.Scanner;
import model.Field;
import model.Pawn;
import model.Player;
import view.ConsoleView;
import view.Menu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nekres
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Menu.showMenu();
        Player players[] = new Player[2];
        Field field = new Field();
        ConsoleView consoleView = new ConsoleView(field,players);
        Scanner scan = new Scanner(System.in);
        System.out.print("First player name:");
        players[0] = new Player(scan.nextLine(), new Pawn('X'));
        consoleView.showPawn(players[0]);
        System.out.print("Second player name:");
        players[1] = new Player(scan.nextLine(), new Pawn('0'));
        consoleView.showPawn(players[1]);
        GameController control = new GameController(players, field, "Tic-Tac-Toe");
        consoleView.showGameName(control);
        boolean moveDone = true;
        while(control.noWinner()){
            if (!moveDone){
                consoleView.moveComplete();
            }
            moveDone = true;
            int x = 0;
            int y = 0;
            x = consoleView.printCoordinates('x');
            y = consoleView.printCoordinates('y');
            control.makeMove(x, y, 'X');
            consoleView.showField();
            while (control.noWinner() && moveDone ){
                consoleView.moveComplete();
                x = consoleView.printCoordinates('x');
                y = consoleView.printCoordinates('y');
                control.makeMove(x, y, '0');
                consoleView.showField();
                moveDone = false;
            }
        }
        consoleView.printWinner(control);
    }}
