package state;

/**
 * Represents the Baked State of the Pizza
 * Part of the State Pattern
 * @author Mohammad S. Raunak
 * @version 1.0
 * @since 12/1/2013
 */
public class Baked implements PizzaState {

	
	private Pizza _pizza;
	// constructor
	public Baked (Pizza pizza){
		_pizza = pizza;
	}
	
	@Override
	public void prepare() throws Exception {
			throw new RuntimeException("Can't prepare an already baked pizza!");
	
	}
	@Override
	public void bake() throws Exception {
		throw new RuntimeException("Can't bake a pizza that is already baked!");
	}

	@Override
	public void deliver() throws Exception {
		System.out.print("Delivering the pizza...");
		_pizza.setState( new Delivered( _pizza ) );
	}

}
