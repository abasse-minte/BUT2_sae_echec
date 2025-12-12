package src.entities.pieces;

import src.entities.jeu.Case;
import src.entities.jeu.IPiece;

import java.util.*;

public class King extends Piece {

    public King(Case position, String color){
        super("king",position,color);
    }


    @Override
    public List<Case> getMove(Map<Case, IPiece> board) {

        Case pos = this.getPosition();   // utiliser this, pas un paramètre externe
        char lettre = pos.getX();
        int chiffre = pos.getY();
        List<Case> movePossible = new ArrayList<>();

        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1,-1,-1,  0, 0, 1, 1, 1};

        for (int i = 0; i < dx.length; i++) {
            char newLettre = (char)(lettre + dx[i]);
            int newChiffre = chiffre + dy[i];

            if (newLettre >= 'A' && newLettre <= 'H' &&
                    newChiffre >= 1 && newChiffre <= 8) {

                movePossible.add(new Case(newLettre,newChiffre));
            }
        }

        return movePossible;
    }

}
