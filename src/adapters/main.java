package src.adapters;

import src.entities.Board.Board;

public class main {  // utilise uci et le board seulement je crois ou faire une interface board pour ensuite lutiliser
    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board.getBoard());
    }
}
