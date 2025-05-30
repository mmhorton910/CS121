import java.util.*;

public class Bishop extends Piece {
    public Bishop(Color c) { this.color = c; }
    // implement appropriate methods

    public String toString() {
        if (color() == Color.BLACK){
            return "bb";
        }
        else{
            return "wb";
        }
    }

    public List<String> moves(Board b, String loc) {
	    List<String> moves = new ArrayList<>();
        int currRow = Integer.valueOf(loc.substring(1));
        char currCol = loc.charAt(0);
        char col = currCol;
        int row = currRow;

        //up and left
        while (col != 'a' && row != 8){
            col = (char) (col - 1);
            row += 1;
            String newLoc = col + Integer.toString(row);
            moves.add(newLoc);
            if (b.getPiece(newLoc) != null){
                if (b.getPiece(newLoc).color() == color()){
                    moves.remove(newLoc);
                }
                break;
            }

        }
        col = currCol;
        row = currRow;
        //down and left
        while (col != 'a' && row != 1){
            col = (char) (col - 1);
            row -= 1;
            String newLoc = col + Integer.toString(row);
            moves.add(newLoc);
            if (b.getPiece(newLoc) != null){
                if (b.getPiece(newLoc).color() == color()){
                    moves.remove(newLoc);
                }
                break;
            }

        }
        col = currCol;
        row = currRow;
        //up and right
        while (col != 'h' && row != 8){
            col = (char) (col + 1);
            row += 1;
            String newLoc = col + Integer.toString(row);
            moves.add(newLoc);
            if (b.getPiece(newLoc) != null){
                if (b.getPiece(newLoc).color() == color()){
                    moves.remove(newLoc);
                }
                break;
            }

        }
        col = currCol;
        row = currRow;
        //down and right
        while (col != 'h' && row != 1){
            col = (char) (col + 1);
            row -= 1;
            String newLoc = col + Integer.toString(row);
            moves.add(newLoc);
            if (b.getPiece(newLoc) != null){
                if (b.getPiece(newLoc).color() == color()){
                    moves.remove(newLoc);
                }
                break;
            }

        }
        return moves;
    }

}