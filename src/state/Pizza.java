package state;
/**
 * A Pizza with different states
 * @author Mohammad S. Raunak
 * @version 1.0
 * @since 12/1/2013
 */
public class Pizza {


	private PizzaState state;

	// constructor
	public Pizza() {
			state = new Prepared( this );
	}

	public PizzaState getState() {
		return state;
	}

	/* setting the state. This is what each of the different state 
	 * objects will call to change the state of the context object */
	public void setState(PizzaState state) {
		this.state = state;
	}

	public void prepare() throws Exception{
		this.state.prepare();
	}
	
	public void bake() throws Exception {
		this.state.bake();
	} 

	public void deliver() throws Exception {
		this.state.deliver();
	}

}