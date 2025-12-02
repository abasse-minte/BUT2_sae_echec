package src.Piece;

import src.Board.IPiece;

import java.util.*;

public class King extends Piece {

    public King(String position, String color){
        super("king",position,color);
    }


    @Override
    public List<String> getMove(Map<String, IPiece> board) {
        String pos = this.position;   // utiliser this, pas un paramètre externe
        char lettre = pos.charAt(0);
        char chiffre = pos.charAt(1);
        List<String> movePossible = new ArrayList<>();

        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1,-1,-1,  0, 0, 1, 1, 1};

        for (int i = 0; i < dx.length; i++) {
            char newLettre = (char)(lettre + dx[i]);
            char newChiffre = (char)(chiffre + dy[i]);

            if (newLettre >= 'A' && newLettre <= 'H' &&
                    newChiffre >= '1' && newChiffre <= '8') {

                String newPos = "" + newLettre + newChiffre;
                movePossible.add(newPos);
            }
        }

        return movePossible;
    }

}
