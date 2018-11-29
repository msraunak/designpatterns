package factory1;

// A HalfDollar is a coin with 50 cents value
public class HalfDollar extends Coin {

	// constructor delegating to the super class
	public HalfDollar(){
		super (CoinName.HALFDOLLAR, 50);
	}
	
	
}
