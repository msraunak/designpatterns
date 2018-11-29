package adaptertwoway;

public class PegAdapter implements ISquarePeg, IRoundPeg {

	private RoundPeg roundPeg;
	private SquarePeg squarePeg;
	
	//constructor with the RoundPeg
	public PegAdapter(RoundPeg peg) {
		this.roundPeg = peg;
	}
	
	// constructor with Square Peg
	public PegAdapter(SquarePeg peg){
		this.squarePeg = peg;
	}
	
	@Override
	public void insertRound(String msg) {
		// what should go in here?
		squarePeg.insertSquare(msg);
	}

	@Override
	public void insertSquare(String msg) {
		
		// what should go in here?
		roundPeg.insertRound(msg);
	}
	

}
