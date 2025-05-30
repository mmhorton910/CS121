import java.util.*;

public class Rook extends Piece {
    public Rook(Color c) { this.color = c; }
    // implement appropriate methods

    public String toString() {
        if (color() == Color.BLACK){
            return "br";
        }
        else{
            return "wr";
        }
    }

    public List<String> moves(Board b, String loc) {
	    List<String> moves = new ArrayList<>();
        int currRow = Integer.valueOf(loc.substring(1));
        char currCol = loc.charAt(0);

        //vertical up
        for (int i = currRow + 1 ; i < 9 ; i++){
            String newLoc = currCol + Integer.toString(i);
            if (!newLoc.equals(loc)){
                moves.add(newLoc);
                if (b.getPiece(newLoc) != null){
                    if (b.getPiece(newLoc).color() == color()){
                        moves.remove(newLoc);
                    }
                    break;
                }
            }
        }
        //vertical down
        for (int i = currRow - 1 ; i > 0 ; i--){
            String newLoc = currCol + Integer.toString(i);
            if (!newLoc.equals(loc)){
                moves.add(newLoc);
                if (b.getPiece(newLoc) != null){
                    if (b.getPiece(newLoc).color() == color()){
                        moves.remove(newLoc);
                    }
                    break;
                }
            }
        }
        //horizontal left
        for (char i = (char)(currCol - 1) ; i >= 'a' ; i--){
            String newLoc = i + Integer.toString(currRow);
            if (!newLoc.equals(loc)){
                moves.add(newLoc);
                if (b.getPiece(newLoc) != null){
                    if (b.getPiece(newLoc).color() == color()){
                        moves.remove(newLoc);
                    }
                    break;
                }
            }

        }
        //horizontal right
        for (char i = (char)(currCol + 1) ; i <= 'h' ; i++){
            String newLoc = i + Integer.toString(currRow);
            if (!newLoc.equals(loc)){
                moves.add(newLoc);
                if (b.getPiece(newLoc) != null){
                    if (b.getPiece(newLoc).color() == color()){
                        moves.remove(newLoc);
                    }
                    break;
                }
            }

        }
        return moves;
    }

}