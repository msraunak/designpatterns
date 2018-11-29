package state2;

/**
 * A Simple Pizza state example using abstract class;
 * 
 */
public abstract class PizzaState {

	// this will be inherited by the subclasses
	protected Pizza _pizza;
	
	public PizzaState (Pizza pizza) {
		_pizza = pizza;
	}
	
	public abstract void bake() throws RuntimeException;

	public abstract void deliver() throws RuntimeException;
	
}


