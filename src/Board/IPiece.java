package src.Board;
import java.util.*;

public interface IPiece {

    public String getPosition();
    public String getNom();
    public String getColor();
    public void setPosition(String position);
    public List<String> getMove(Map<String, IPiece> board);
    public boolean sameColor(String color);
}
