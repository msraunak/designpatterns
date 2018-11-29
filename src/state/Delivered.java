
package state;

/**
 * Represents the Delivered State of the Pizza
 * Example for illustrating the State Pattern
 * @author Mohammad S. Raunak
 * @version 1.0
 * @since 12/1/2013
 */

public class Delivered implements PizzaState {

	private Pizza _pizza;
	
	// constructor
	public Delivered(Pizza pizza) {
		_pizza = pizza;
	}

	@Override
	public void prepare() throws Exception{
		System.out.println("Can't preapre an already delivered Pizza!");
	}
	
	@Override
	public void bake() throws Exception {
		throw new RuntimeException("Can't bake a pizza that is already delivered!");

	}

	@Override
	public void deliver() throws Exception {
		throw new RuntimeException("Can't deliver a pizza that is already delivered.");
	}

	
}
