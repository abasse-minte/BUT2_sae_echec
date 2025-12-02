package src.Piece;

import src.Board.IPiece;

public abstract class Piece implements IPiece {

    public String nom;
    public String position;
    public String color;

    public Piece(String nom, String position, String color) {
        this.nom = nom;
        this.position = position;
        this.color = color;
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
    public String getColor(){
        return color;
    }

    @Override
    public void setPosition(String position){
        this.position = position;
    }

    @Override
    public boolean sameColor(String color){
        return this.color.equals(color);
    }


}
