import java.util.ArrayList;

public class Board {

    private Piece[][] pieces = new Piece[8][8];

    private static Board board = null;

    private ArrayList<BoardListener> listeners = new ArrayList<>();

    private Board() { }
    
    public static Board theBoard() {
	    if (board == null){
            board = new Board();
        }
        return board;
    }

    // Returns piece at given loc or null if no such piece
    // exists
    public Piece getPiece(String loc) {
        int xCoor = loc.charAt(0) - 97;
        int yCoor = Integer.valueOf(loc.substring(1)) - 1;
        if (xCoor < 0 || xCoor > 8 || yCoor < 0 || yCoor > 8){
            throw new UnsupportedOperationException();
        }
	    return pieces[xCoor][yCoor];
    }

    public void addPiece(Piece p, String loc) {
        if (getPiece(loc) != null){
            throw new UnsupportedOperationException();
        }
	    int xCoor = loc.charAt(0) - 97;
        int yCoor = Integer.valueOf(loc.substring(1)) - 1;
        if (xCoor < 0 || xCoor > 8 || yCoor < 0 || yCoor > 8){
            throw new UnsupportedOperationException();
        }
        pieces[xCoor][yCoor] = p;
    }

    public void movePiece(String from, String to) {
        char fromCol = from.charAt(0);
        int fromRow = Integer.valueOf(from.substring(1));
        char toCol = to.charAt(0);
        int toRow = Integer.valueOf(to.substring(1));

        if (fromCol < 'a' || fromCol > 'h' || toCol < 'a' || toCol > 'h'){
            throw new UnsupportedOperationException();
        }
        if (fromRow < 1 || fromRow > 8 || toRow < 1 || toRow > 8){
            throw new UnsupportedOperationException();
        }

        Piece p = getPiece(from);

        if (p == null){
            throw new UnsupportedOperationException();
        }

        ArrayList<String> possibleMoves = new ArrayList<>();
        possibleMoves.addAll(p.moves(board, from));

        if (!possibleMoves.contains(to)){
            System.out.println("Moving " + p.toString() + " from " + from + " to " + to + " is not a valid move");
            throw new UnsupportedOperationException();
        }

        for (BoardListener l : listeners){
            l.onMove(from, to, p);
            if (getPiece(to) != null){
                l.onCapture(p, getPiece(to));
            }
        }
        int fromX = fromCol - 97;
        int fromY = fromRow - 1;
        int toX = toCol - 97;
        int toY = toRow - 1;

        pieces[fromX][fromY] = null;
        pieces[toX][toY] = p;
    }

    public void clear() {
	    for (int i = 0; i < 8 ; i++){
            for (int j = 0 ; j < 8 ; j++){
                pieces[i][j] = null;
            }
        }
    }

    public void registerListener(BoardListener bl) {
        listeners.add(bl);
    }

    public void removeListener(BoardListener bl) {
	    listeners.remove(bl);
    }

    public void removeAllListeners() {
	    listeners.clear();
    }

    public void iterate(BoardInternalIterator bi) {
	    for (int i = 0 ; i < pieces.length ; i++){
            for (int j = 0 ; j < pieces[i].length ; j++){
                char col = (char) (i + 97);
                String row = Integer.toString(j + 1);
                String loc = col + row;
                bi.visit(loc, getPiece(loc));
            }
        }
    }
}