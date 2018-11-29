package adapter;

public class TestPegs {

	public static void main (String args[]) {

			SquarePeg squarePeg = new SquarePeg();
			
			// Do an insert using squarePeg
			squarePeg.insertSquare("Inserting a Square Peg ..");

			// now let's say we would like to do an insert using the round peg. 
			// But this client only understands insertSquare() not insertRound() method. 
			// the solution is the adapter we created
			
			PegAdapter adapter = new PegAdapter ();
			adapter.insertSquare("Inserting round peg....");
	}
	
}
