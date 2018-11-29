
package state2;

/**
 * @author raunak
 */
public class Delivered extends PizzaState {

	// constructor
	public Delivered(Pizza pizza) {
		super (pizza);
	}

	@Override
	public void bake() throws RuntimeException {
		throw new RuntimeException("\nCan't bake a pizza that is already delivered!");

	}

	@Override
	public void deliver() throws RuntimeException {
		throw new RuntimeException("\nCan't deliver a pizza that is already delivered.");
	}

}
