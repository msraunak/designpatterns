package observer;

import java.util.Observable;
import java.util.Observer;

/**
 * An Observer of name change
 * @author raunak
 */
public class NameObserver implements Observer {

	private String _name;
	
	public NameObserver() {
		_name = null;
		System.out.println("NameObserver created: Name is " + _name);
	}
	
	@Override
	public void update(Observable obs, Object arg) {

			if (arg instanceof String){
				_name = (String) arg;
				System.out.println("NameObserver: Name changed to " + _name);
			} else {
				System.out.println("NameObserver: There has been some change in the Subject, but it is not the name!");
			}
			
	}

}
