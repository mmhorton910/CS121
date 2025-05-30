import java.util.*;

public class Queen extends Piece {
    public Queen(Color c) { this.color = c; }
    // implement appropriate methods

    public String toString() {
	    if (color() == Color.BLACK){
            return "bq";
        }
        else{
            return "wq";
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