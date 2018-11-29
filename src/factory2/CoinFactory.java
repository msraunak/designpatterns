package factory2;

/**
 * A factory object to create different types of coins
 * @author Mohammad S. Raunak
 *
 */
public class CoinFactory {
	
	private Coin _newCoin;
	
	// a factory method to create new Coin objects
	public Coin createCoin (char coinType){
		switch (coinType){
			case 'h':
				_newCoin = new HalfDollar();
				break;
		case 'q':
				_newCoin = new Quarter();
				break;
		case 'd':
				_newCoin = new Dime();
				break;
		case 'n':
				_newCoin = new Nickel();
				break;		
		}
		
		return _newCoin;
	}
}
