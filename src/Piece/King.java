package src.Piece;

import java.util.*;

public class King implements IPiece{

    public String nom;
    public String position;


    public King(String position){
        this.nom = "king";
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

        // Les directions possibles pour le roi
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1}; // mouvements horizontaux
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};  // mouvements verticaux

        for (int i = 0; i < dx.length; i++) {
            char newLettre = (char) (lettre + dx[i]);
            char newChiffre = (char) (chiffre + dy[i]);

            // Vérifier si la position est dans les limites de l'échiquier
            if (newLettre >= 'A' && newLettre <= 'H' && newChiffre >= '1' && newChiffre <= '8') {
                String newPos = "" + newLettre + newChiffre;
                movePossible.add(newPos);
            }
        }

        return movePossible;
    }

}
