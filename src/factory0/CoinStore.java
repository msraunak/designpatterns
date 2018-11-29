package factory0;

import java.util.ArrayList;

/**
 * This class represents the coin repository inside
 * the vending machine
 * @author raunak
 */
public class CoinStore {
	
	private ArrayList<Coin> _coinsInserted;
	
	public CoinStore(){
		_coinsInserted = new ArrayList <Coin> ();
	}
	
	/**
	 * deposit coins into the machine. 
	 * Expects Strings of size 2 with regex "\\d[hqdn]"
	 * @param coinArg
	 */
	private void deposit(String coinArg){
		
		int numOfCoins = Integer.parseInt( coinArg.substring(0,1) );
		char coinType = coinArg.charAt(1);
		
		switch (coinType){
		//case 'h':
		//	for (int i=0; i <numOfCoins; i++)
		//		_coinsInserted.add(new HalfDollar());
		//	break;
		case 'q':
			for (int i=0; i <numOfCoins; i++)
				_coinsInserted.add(new Quarter());
			break;
		case 'd':
			for (int i=0; i <numOfCoins; i++)
				_coinsInserted.add(new Dime());
			break;
		case 'n':
			for (int i=0; i <numOfCoins; i++)
				_coinsInserted.add(new Nickel());
			break;		
		}
	}
	
	/**
	 * deposits all the coins into the machine
	 * @param allCoinArgs A string representing all the coin arguements
	 */
	public void depositAll(String [] allCoinArgs) {
		for (String coinArg: allCoinArgs){
			deposit(coinArg);
		}
		
	}
	/**
	 * Compute the total value of 
	 * @return the total value of all the coins inserted 
	 */
	public int getInsertedCoinsValue(){
		int valueInCents = 0;
		for (Coin c: _coinsInserted){
			valueInCents += c.getCoinValueInCents();
		}
		return valueInCents;
	}
}
