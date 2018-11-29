package adaptertwoway;
// Test program for pegs
public class TestPegs {

	public static void main (String args[]){
		
		// create some peg
		RoundPeg roundPeg = new RoundPeg();
		SquarePeg squarePeg = new SquarePeg();
		
		// do an insert using squarePeg
		squarePeg.insertSquare("Inserting square peg..");
		
		// create a two-way adapter and do an insert with it
		ISquarePeg roundToSquare = new PegAdapter(roundPeg);
		roundToSquare.insertSquare("using insertSqure() method.. "); 
		
		
		// do an insert using round peg
		roundPeg.insertRound("Inserting a round peg." );
		
		// create another two-way adapter and do insertSquare with it
		IRoundPeg squareToRound = new PegAdapter (squarePeg);
		squareToRound.insertRound("using insertRound() method...");
		
	}
	
	
}
