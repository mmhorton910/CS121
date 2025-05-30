import java.util.*;
import java.io.*;

public class Chess {
    public static void main(String[] args) {
	if (args.length != 2) {
	    System.out.println("Usage: java Chess layout moves");
	}
	Piece.registerPiece(new KingFactory());
	Piece.registerPiece(new QueenFactory());
	Piece.registerPiece(new KnightFactory());
	Piece.registerPiece(new BishopFactory());
	Piece.registerPiece(new RookFactory());
	Piece.registerPiece(new PawnFactory());
	Board.theBoard().registerListener(new Logger());
	// args[0] is the layout file name
	// args[1] is the moves file name
	// Put your code to read the layout file and moves files
	// here.

	Board b = Board.theBoard();

	File layout = new File(args[0]);
	File moves = new File(args[1]);

	try{
		Scanner layoutScanner = new Scanner(layout);
		while (layoutScanner.hasNextLine()){
			String line = layoutScanner.nextLine();
			if (line.startsWith("#")){
				continue;
			}
			String[] splitLine = line.split("=");

			Piece p = Piece.createPiece(splitLine[1]);
			b.addPiece(p, splitLine[0]);
			
		}
		layoutScanner.close();

		Scanner movesScanner = new Scanner(moves);
		while(movesScanner.hasNextLine()){
			String line = movesScanner.nextLine();
			if (line.startsWith("#")){
				continue;
			}
			String[] splitLine = line.split("-");

			b.movePiece(splitLine[0], splitLine[1]);
		}
		movesScanner.close();

	}catch (FileNotFoundException e){
		e.printStackTrace();
	}

	// Leave the following code at the end of the simulation:
	System.out.println("Final board:");
	Board.theBoard().iterate(new BoardPrinter());
    }
}