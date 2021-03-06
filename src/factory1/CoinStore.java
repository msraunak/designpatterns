package factory1;

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
	 * Deposit coins into the machine. 
	 * Expects Strings of size 2 with regex "\\d[hqdn]"
	 * @param coinArg
	 */
	private void deposit(String coinArg){
		
		int numOfCoins = Integer.parseInt( coinArg.substring(0,1) );
		CoinFactory coinFactory = new CoinFactory();
		char coinType = coinArg.charAt(1);
		Coin coin = coinFactory.createCoin(coinType);

		// add the number of coins added
		for (int i=0; i <numOfCoins; i++)
				_coinsInserted.add(coin);

	}
	
	/**
	 * deposits all the coins into the machine
	 * @param allCoinArgs A string representing all the coin arguments
	 */
	public void depositAll(String [] allCoinArgs) {
		for (String coinArg: allCoinArgs){
			deposit(coinArg);
		}
		
	}
	/**
	 * Compute and returns the total value of coins  
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
