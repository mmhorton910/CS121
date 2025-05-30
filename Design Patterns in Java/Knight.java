import java.util.*;

public class Knight extends Piece {
    public Knight(Color c) { this.color = c; }
    // implement appropriate methods

    public String toString() {
        if (color() == Color.BLACK){
            return "bn";
        }
        else{
            return "wn";
        }
    }

    public List<String> moves(Board b, String loc) {
        List<String> moves = new ArrayList<>();
        char currCol = loc.charAt(0);
        int currRow = Integer.valueOf(loc.substring(1));
        int[] two = {2, -2};
        int[] one = {1, -1};

        for (int i : two){
            for (int j : one){
                char col = (char) (currCol + i);
                int row = currRow + j;
                if (col >= 'a' && col <= 'h' && row >= 1 && row <= 8){
                    String newLoc = col + Integer.toString(row);
                    if (!newLoc.equals(loc)){
                        moves.add(newLoc);
                        if (b.getPiece(newLoc) != null){
                            if (b.getPiece(newLoc).color() == color()){
                                moves.remove(newLoc);
                            }
                        }
                    }
                }
            }
        }

        for (int j : two){
            for (int i : one){
                char col = (char) (currCol + i);
                int row = currRow + j;
                if (col >= 'a' && col <= 'h' && row >= 1 && row <= 8){
                    String newLoc = col + Integer.toString(row);
                    if (!newLoc.equals(loc)){
                        moves.add(newLoc);
                        if (b.getPiece(newLoc) != null){
                            if (b.getPiece(newLoc).color() == color()){
                                moves.remove(newLoc);
                            }
                        }
                    }
                }
            }
        }

        return moves;
    }

}