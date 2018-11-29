package factory1;

/**
 * An abstract super class for different types of Coins 
 * @author raunak
 */
public abstract class Coin {
	
	// By convention, enum types are all named ALLCAPS
	public enum CoinName {HALFDOLLAR, QUARTER, DIME, NICKEL}
	
	protected CoinName _coinName;
	protected int _valueInCents; 
	
	//constructor 
	Coin(CoinName name, int value){
		_coinName = name;
		_valueInCents = value;
	}
	
	
	//getter method for _coinName
	public CoinName getCoinName(){
		return _coinName;
	}

	// return 
	public String getCoinNameAsString(){
		return getCoinName().toString();
	}

	// getter method for _valueInCents
	public int getCoinValueInCents(){
		return _valueInCents;
	}
	
	// get the first letter of the Coin name, which is also its abbreviation
	public char getAbbreviation(){
		return getCoinNameAsString().charAt(0); 
	}
	
	@Override
	public String toString() {
		return "_coinName=" + _coinName + " : " + "_coinValue=" + _valueInCents;
	}

	
}
