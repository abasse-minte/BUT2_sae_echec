package src.Piece;
import java.util.LinkedHashMap;
import java.util.List;

public interface IPiece {

    public String getPosition();
    public void setPosition(String position);
    public List<String> getMove(
            LinkedHashMap<String, IPiece> board, IPiece piece
    );
    public String getNom();

}
