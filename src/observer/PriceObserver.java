package observer;

import java.util.Observable;
import java.util.Observer;
/**
 * An observer of the price changes
 * @author raunak
 */
public class PriceObserver implements Observer {

	private float _price;
	
	public PriceObserver(){
		_price = 0;
		System.out.println("PriceObserver created: Price is " + _price);
	}
	
	@Override
	public void update(Observable obs, Object arg) {
		if (arg instanceof Float){
			_price = ((Float)arg).floatValue();
			System.out.println("PriceObserver: Price changed to " + _price);
		} else {
			System.out.println("PriceObserver: There has been some changes to" +
					" the Subject (Observable), but it is not the price");
		
		}

	}

}
