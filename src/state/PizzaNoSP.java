package state;

/**
 * An example of a Pizza class that does not have any state
 * 
 * @author Mohammad S. Raunak
 *
 */
public class PizzaNoSP {

	/* If we hadn't used the enumerated type, 
	 * the following is what our code would have needed
	 *  public final static int PREPARED = 0;
	 *  public final static int BAKED = 1;
	 *  public final static int DELIVERED = 2;
	 */
	
	private enum PizzaStateEnum {PREPARED, BAKED, DELIVERED};
	
	private String name;

	PizzaStateEnum state = PizzaStateEnum.PREPARED;

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PizzaStateEnum getState() {
		return state;
	}

	public void setState(PizzaStateEnum state) {
		this.state = state;
	}
	
	/**
	 * Bake the pizza
	 * @throws Exception
	 */
	public void bake() throws Exception {

		if(state == PizzaStateEnum.PREPARED) {
			System.out.println("Baking the pizza...");
			state = PizzaStateEnum.BAKED;
		}
		else if(state == PizzaStateEnum.BAKED) {
			throw new RuntimeException("Can't bake a pizza already baked");
		}
		else if(state == PizzaStateEnum.DELIVERED) {
			throw new RuntimeException("Can't bake a pizza already delivered");
		}
	} 

	public void deliver() throws Exception {

		if(state == PizzaStateEnum.PREPARED) {
			throw new RuntimeException("Can't deliver a pizza not baked yet");
		}
		else if(state == PizzaStateEnum.BAKED) {
			System.out.println("Delivering the pizza...");
			state = PizzaStateEnum.DELIVERED;
		}
		else if(state == PizzaStateEnum.DELIVERED) {
			throw new RuntimeException("Can't deliver a pizza already delivered");
		}
	}

}
