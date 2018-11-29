package adapter;

public class PegAdapter extends SquarePeg {

	private RoundPeg roundPeg;
	
	// default constructor
	public PegAdapter () {
		roundPeg = new RoundPeg();
	}
	
	public PegAdapter (RoundPeg rPeg){
		this.roundPeg = rPeg;
	}
	
	@Override
	public void insertSquare(String str){
		roundPeg.insertRound(str);
	}
	
}
