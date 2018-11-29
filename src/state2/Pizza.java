package state2;
/**
 * A Pizza with different states
 * @author raunak
 */
public class Pizza {


	//State initialization
	private PizzaState state;

	public Pizza() {
			state = new Cooked( this );
	}

	public PizzaState getState() {
		return state;
	}

	/* setting the state. This is what each of the different state 
	 * objects will call to change the state of the context object */
	public void setState(PizzaState state) {
		this.state = state;
	}

	public void bake() throws Exception {
		this.state.bake();
	} 

	public void deliver() throws Exception {
		this.state.deliver();
	}

}