import java.util.*;

public class King extends Piece {
    public King(Color c) { this.color = c; }
    // implement appropriate methods

    public String toString() {
        if (color() == Color.BLACK){
            return "bk";
        }
        else{
            return "wk";
        }
    }

    public List<String> moves(Board b, String loc) {
        List<String> moves = new ArrayList<>();
        int currRow = Integer.valueOf(loc.substring(1));
        char currCol = loc.charAt(0);
        
        for (char i = (char)(currCol - 1) ; i <= (char)(currCol + 1); i++){
            for (int j = currRow - 1 ; j <= currRow + 1 ; j++){
                if (i < 'a' || i > 'h' || j < 1 || j > 8){
                    continue;
                }
                String newLoc = i + Integer.toString(j);
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

        return moves;
    }

}