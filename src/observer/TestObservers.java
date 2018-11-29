package observer;

import java.util.Observer;

/**
 * A class to run the Observer Pattern Example
 * @author raunak
 *
 */
public class TestObservers {

	public static void main(String [] args) {
		// create the Subject (Observable) and the Observers
		ConcreteSubject subject = new ConcreteSubject("Corn Pops", 1.29f);
		Observer nameObs = new NameObserver();
		Observer priceObs = new PriceObserver();
		
		// add the observers to the Observable/Subject
		subject.addObserver(nameObs);
		subject.addObserver(priceObs);
		
		// make changes to the state of the Observable/Subject
		subject.setName("Frosted Flakes");
		subject.setPrice(4.57f);
		
		subject.setPrice(9.22f);
		subject.setName("Sugar Crispies");
		
	}
}
