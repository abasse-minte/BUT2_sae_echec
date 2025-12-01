package src.Board;

import src.Piece.IPiece;

import java.util.*;

public class Board {
    public static final int taille = 8;
    public static final String[] index = {"A","B","C","D","E","F","G","H"};
    public Map<String, IPiece> board = new LinkedHashMap<>();


    public Board() {
        for (int i = 0; i < taille; i++) {
            String tmp = index[i];
            for (int j = 1; j <= taille; j++) {
                String indice = tmp + String.valueOf(j);
                board.put(indice,null);
            }
        }
    }

    public void setPiece(String position, IPiece piece){
        board.put(position, piece);
    }

}
