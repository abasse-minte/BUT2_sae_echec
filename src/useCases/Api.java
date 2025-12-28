package src.useCases;

import src.entities.jeu.Board;
import src.entities.jeu.Case;
import src.entities.jeu.IPiece;

import java.util.Map;

/**
 * API métier du jeu d'échecs
 * Appelée par l'UCIEngine
 */
public class Api {

    private Board board;

    public Api() {
        newGame();
    }

    /**
     * Nouvelle partie
     */
    public void newGame() {
        board = new Board();
        // TODO : placer les pièces initiales si ce n'est pas déjà fait ailleurs
    }

    /**
     * Joue un coup au format UCI (ex: e2e4)
     *
     * @return true si le coup est valide, false sinon
     */
    public boolean playMove(String uciMove) {

        if (uciMove == null || uciMove.length() != 4) {
            return false;
        }

        Case from = new Case(
                uciMove.charAt(0),
                Character.getNumericValue(uciMove.charAt(1))
        );

        Case to = new Case(
                uciMove.charAt(2),
                Character.getNumericValue(uciMove.charAt(3))
        );

        Map<Case, IPiece> map = board.getBoard();
        IPiece piece = map.get(from);

        if (piece == null) {
            return false;
        }

        // Vérification des coups possibles
        if (!board.mouvPossible(piece).contains(to)) {
            return false;
        }

        // Jouer le coup
        board.removePiece(from);
        board.setPiece(to, piece);
        board.swapJoueur();

        return true;
    }

    /**
     * FEN courant (utilisé par UCI)
     */
    public String getFen() {
        return board.fen();
    }

    /**
     * Accès au board (debug / tests)
     */
    public Board getBoard() {
        return board;
    }
}
