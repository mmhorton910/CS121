import java.util.*;

abstract public class Piece {
    public static HashMap<Character, PieceFactory> pfmap = new HashMap<>();
    public Color color;

    public static void registerPiece(PieceFactory pf) {
        char symbol = pf.symbol();
        pfmap.put(symbol, pf);
    }

    public static Piece createPiece(String name) {
	    char namecolor = name.charAt(0);
        char symbol = name.charAt(1);
        
        Color pcolor;

        if (namecolor == 'b'){
            pcolor = Color.BLACK;
        }
        else if (namecolor == 'w'){
            pcolor = Color.WHITE;
        }
        else{
            throw new UnsupportedOperationException();
        }

        PieceFactory pf = pfmap.get(symbol);

        return pf.create(pcolor);
    }

    public Color color() {
	// You should write code here and just inherit it in
	// subclasses. For this to work, you should know
	// that subclasses can access superclass fields.
	    return this.color;
    }

    abstract public String toString();

    abstract public List<String> moves(Board b, String loc);
}