import java.util.*;
public class Test {

    // Run "java -ea Test" to run with assertions enabled (If you run
    // with assertions disabled, the default, then assert statements
    // will not execute!)

    public static void test1() {
	    Board b = Board.theBoard();
        Piece.registerPiece(new PawnFactory());
        Piece p = Piece.createPiece("bp");
        b.addPiece(p, "a3");
        assert b.getPiece("a3") == p;
        b.clear();
    }

    public static void test2(){
        Board b = Board.theBoard();
        Piece.registerPiece(new QueenFactory());
        Piece.registerPiece(new RookFactory());
        Piece.registerPiece(new PawnFactory());
        Piece q = Piece.createPiece("bq");
        Piece p = Piece.createPiece("bp");
        Piece r = Piece.createPiece("br");
        b.addPiece(r, "h8");
        b.addPiece(p, "a7");
        b.addPiece(q, "d4");

        assert b.getPiece("a7") == p;
        assert b.getPiece("h8") == r;
        assert b.getPiece("d4") == q;


        List<String> queenMoves = q.moves(b, "d4");
        List<String> rookMoves = r.moves(b, "h8");
        List<String> pawnMoves = p.moves(b, "a7");

        assert queenMoves.contains("b6");
        assert !queenMoves.contains("g5");

        assert rookMoves.contains("h1");
        assert rookMoves.contains("a8");
        assert !rookMoves.contains("g6");

        assert pawnMoves.contains("a6");
        assert pawnMoves.contains("a5");
        assert !pawnMoves.contains("b8");
        b.clear();

    }

    public static void pawnMovesTest(){
        Board b = Board.theBoard();
        Piece.registerPiece(new PawnFactory());
        
        Piece bp1 = Piece.createPiece("bp");
        Piece bp2 = Piece.createPiece("bp");
        Piece bp3 = Piece.createPiece("bp");

        Piece wp1 = Piece.createPiece("wp");
        Piece wp2 = Piece.createPiece("wp");
        Piece wp3 = Piece.createPiece("wp");

        b.addPiece(bp1, "g7");
        b.addPiece(bp2, "c1");
        b.addPiece(bp3, "h5");

        b.addPiece(wp1, "b2");
        b.addPiece(wp2, "d8");
        b.addPiece(wp3, "e4");

        List<String> bp1Moves = bp1.moves(b, "g7");
        List<String> bp2Moves = bp2.moves(b, "c1");
        List<String> bp3Moves = bp3.moves(b, "h5");

        List<String> wp1Moves = wp1.moves(b, "b2");
        List<String> wp2Moves = wp2.moves(b, "d8");
        List<String> wp3Moves = wp3.moves(b, "e4");

        assert bp1Moves.size() == 2;
        assert bp1Moves.contains("g6") && bp1Moves.contains("g5");
        assert bp2Moves.isEmpty();
        assert bp3Moves.size() == 1;
        assert bp3Moves.contains("h4");

        System.out.println(wp1Moves.size());
        for (String s : wp1Moves){
            System.out.println(s);
        }

        assert wp1Moves.contains("b3") && wp1Moves.contains("b4");
        assert wp2Moves.isEmpty();
        assert wp3Moves.size() == 1;
        assert wp3Moves.contains("e5");

        b.clear();

    }
    
    public static void queenMovesTest(){
        Board b = Board.theBoard();
        Piece.registerPiece(new QueenFactory());
        Piece q = Piece.createPiece("bq");
        b.addPiece(q, "d4");

        List<String> queenMoves = q.moves(b, "d4");

        System.out.println(queenMoves.toString());

        b.clear();

    }

    public static void movesTest(){
        Board b = Board.theBoard();
        Piece.registerPiece(new RookFactory());
        Piece.registerPiece(new KingFactory());
        Piece.registerPiece(new BishopFactory());
        Piece br = Piece.createPiece("br");
        Piece wr = Piece.createPiece("wr");
        Piece wk = Piece.createPiece("wk");
        Piece wb = Piece.createPiece("wb");
        b.addPiece(br, "a8");
        b.addPiece(wr, "e1");
        b.addPiece(wk, "g1");
        b.addPiece(wb, "c1");


        List<String> brookMoves = br.moves(b, "a8");
        List<String> wrookMoves = wr.moves(b, "e1");

        System.out.println(brookMoves.toString());
        System.out.println(wrookMoves.toString());

        b.clear();

    }

    public static void main(String[] args) {
	    test1();
        test2();
        pawnMovesTest();
        queenMovesTest();
        movesTest();
    }

}