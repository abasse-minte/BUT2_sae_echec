package src.Board;

import java.util.*;

public class Board {
    public static final int taille = 8;
    public static final String[] index = {"A","B","C","D","E","F","G","H"};
    private Map<String, IPiece> board = new LinkedHashMap<>();


    public Board() {
        for (int i = 0; i < taille; i++) {
            String tmp = index[i];
            for (int j = 1; j <= taille; j++) {
                String indice = tmp + String.valueOf(j);
                board.put(indice,null);
            }
        }
    }

    public Map<String, IPiece> getBoard() {
        return board;
    }


    public void setPiece(String position, IPiece piece){
        board.put(position, piece);
    }

    //à changer en cas ou le mode de jeu demande le nbr de piece capturee compte
    public void removePiece(String position){ setPiece(position, null); }

    public List<String> mouvPossible(IPiece piece){

        List<String> moves = piece.getMove(board);

        for (Map.Entry<String, IPiece> entry : board.entrySet()){
            if (moves.contains(entry.getKey())){ // si dans ma liste de position, j'ai la clé
                if (entry.getValue() != null && entry.getValue().sameColor(piece.getColor())){ // si ma case n'est pas null et que la piece est de meme couleur
                    moves.remove(entry.getKey()); // ce mouvement n'est donc pas possible
                }
            }
        }

        return moves;
    }



}
