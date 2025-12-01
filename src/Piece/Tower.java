package src.Piece;

import java.util.*;

public class Tower implements IPiece{

    public String nom;
    public String position;


    public Tower(String position){
        this.nom = "tower";
        this.position = position;
    }

    @Override
    public String getPosition(){
        return position;
    }

    @Override
    public String getNom(){
        return nom;
    }

    @Override
    public void setPosition(String position){
        this.position = position;
    }

    @Override
    public List<String> getMove(LinkedHashMap<String, IPiece> board, IPiece piece) {
        String pos = piece.getPosition();
        char lettre = pos.charAt(0);  // colonne
        char chiffre = pos.charAt(1); // ligne
        List<String> movePossible = new ArrayList<>();

        // Déplacements verticaux et horizontaux
        // Vertical haut
        for (char i = (char)(chiffre + 1); i <= '8'; i++) {
            String newPos = "" + lettre + i;
            if (board.get(newPos) == null) {
                movePossible.add(newPos);
            } else {
                movePossible.add(newPos); // On peut capturer la pièce
                break; // Stoppe si une pièce est sur le chemin
            }
        }

        // Vertical bas
        for (char i = (char)(chiffre - 1); i >= '1'; i--) {
            String newPos = "" + lettre + i;
            if (board.get(newPos) == null) {
                movePossible.add(newPos);
            } else {
                movePossible.add(newPos);
                break;
            }
        }

        // Horizontal droite
        for (char i = (char)(lettre + 1); i <= 'H'; i++) {
            String newPos = "" + i + chiffre;
            if (board.get(newPos) == null) {
                movePossible.add(newPos);
            } else {
                movePossible.add(newPos);
                break;
            }
        }

        // Horizontal gauche
        for (char i = (char)(lettre - 1); i >= 'A'; i--) {
            String newPos = "" + i + chiffre;
            if (board.get(newPos) == null) {
                movePossible.add(newPos);
            } else {
                movePossible.add(newPos);
                break;
            }
        }

        return movePossible;
    }
}
