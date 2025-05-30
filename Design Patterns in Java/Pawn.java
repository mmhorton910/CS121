import java.util.*;

public class Pawn extends Piece {
    public Pawn(Color c) { this.color = c; }
    // implement appropriate methods

    public String toString() {
        if (color() == Color.BLACK){
            return "bp";
        }
        else{
            return "wp";
        }
    }

    public List<String> moves(Board b, String loc) {
	    List<String> moves = new ArrayList<>();
        int currRow = Integer.valueOf(loc.substring(1));
        if (color() == Color.BLACK){
            if (!(currRow == 1)){
                int row = currRow - 1;
                String newLoc = loc.charAt(0) + Integer.toString(row);
                if (b.getPiece(newLoc) == null){
                    moves.add(newLoc);
                }
                if (currRow == 7){
                    int row2 = row - 1;
                    newLoc = loc.charAt(0) + Integer.toString(row2);
                    if (b.getPiece(newLoc) == null){
                        moves.add(newLoc);
                    }
                }
                char col = loc.charAt(0);
                if (col != 'a'){
                    char colLeft = (char)(col - 1);
                    Piece p1 = b.getPiece(colLeft + Integer.toString(row));
                    if (p1 != null && p1.color() == Color.WHITE){
                        newLoc = colLeft + Integer.toString(row);
                        moves.add(newLoc);
                    }
                }
                if (col != 'h'){
                    char colRight = (char) (col + 1);
                    Piece p1 = b.getPiece(colRight + Integer.toString(row));
                    if (p1 != null && p1.color() == Color.WHITE){
                        newLoc = colRight + Integer.toString(row);
                        moves.add(newLoc);
                    }
                }
            }
        }
        else {
            if (!(currRow == 8)){
                int row = currRow + 1;
                String newLoc = loc.charAt(0) + Integer.toString(row);
                if (b.getPiece(newLoc) == null){
                    moves.add(newLoc);
                }
                if (currRow == 2){
                    int row2 = row + 1;
                    newLoc = loc.charAt(0) + Integer.toString(row2);
                    if (b.getPiece(newLoc) == null){
                        moves.add(newLoc);
                    }
                }
                char col = loc.charAt(0);
                if (col != 'a'){
                    char colLeft = (char)(col - 1);
                    Piece p1 = b.getPiece(colLeft + Integer.toString(row));
                    if (p1 != null && p1.color() == Color.BLACK){
                        newLoc = colLeft + Integer.toString(row);
                        moves.add(newLoc);
                    }
                }
                if (col != 'h'){
                    char colRight = (char) (col + 1);
                    Piece p1 = b.getPiece(colRight + Integer.toString(row));
                    if (p1 != null && p1.color() == Color.BLACK){
                        newLoc = colRight + Integer.toString(row);
                        moves.add(newLoc);
                    }
                }
            }
        }
        return moves;
    }

}