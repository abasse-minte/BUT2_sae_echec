package src.entities.pieces;

import src.entities.jeu.Case;
import src.entities.jeu.IPiece;

import java.util.*;

public class Tower extends Piece {

    public Tower(Case position, String color){
        super("rook",position,color);
    }

    @Override
    public List<Case> getMove(Map<Case, IPiece> board) {

        Case pos = this.getPosition();
        char lettre = pos.getX();  // colonne A-H
        int chiffre = pos.getY(); // ligne 1-8

        List<Case> movePossible = new ArrayList<>();

        // vertical haut
        for (int i = chiffre + 1; i <= 8; i++) {

            Case case_tmp = new Case(lettre,i);

            if (!board.containsKey(case_tmp)) {  //contenir une piece? si ya rien alors case possible
                movePossible.add(case_tmp);
            } else {
                movePossible.add(case_tmp);
                break;
            }
        }

        // vertical bas
        for (int i = chiffre - 1; i >= 1; i--) {

            Case case_tmp = new Case(lettre,i);

            if (!board.containsKey(case_tmp )) {
                movePossible.add(case_tmp );
            } else {
                movePossible.add(case_tmp );
                break;
            }
        }

        // horizontal droit
        for (char i = (char)(lettre + 1); i <= 'H'; i++) {

            Case case_tmp = new Case(i,chiffre);

            if (!board.containsKey(case_tmp)) {
                movePossible.add(case_tmp);
            } else {
                movePossible.add(case_tmp);
                break;
            }
        }

        // horizontal gauche
        for (char i = (char)(lettre - 1); i >= 'A'; i--) {

            Case case_tmp = new Case(i,chiffre);

            if (!board.containsKey(case_tmp)) {
                movePossible.add(case_tmp);
            } else {
                movePossible.add(case_tmp);
                break;
            }
        }

        return movePossible;
    }
}
