package observer;

import java.util.Observable;

/**
 * A concrete subject (observable) to observe. 
 * It has two fields: a name and a price that can chagne.  
 * @author raunak
 */
public class ConcreteSubject extends Observable {

	private String _name;
	private float _price;
	
	// Constructor
	public ConcreteSubject (String name, float price){
		_name = name;
		_price = price;
		System.out.println("Concrete Subject (Observable) created: " + name + " at " + price);

	}
	
	// getter method
	public String getName(){
		return _name;		
	}
	
	//getter method
	public float getPrice(){
		return _price;
	}
		
	// setter
	public void setName (String name){
		_name = name;
		setChanged(); // calling the method in the *superclass* Observable
		notifyObservers(_name); // the notifyObservers method in the *superclass* Observable
		// the notifyObservers is sent a String in this case
		// By the way, there is another overloaded notifyObservers() without any argument
	}
	
	// setter
	public void setPrice (float price){
		_price = price;
		// invokes the setChanged() in Observable super class
		setChanged();
		notifyObservers (new Float(price)); // because notify observers expects Object
	}
	
}
