package state2;

public class Cooked extends PizzaState {

	 public Cooked(Pizza pizza) {
		 super (pizza); 
	}

	@Override
	public void bake() throws RuntimeException {
		  System.out.print("\nBaking the pizza...");
		  _pizza.setState(new Baked(_pizza));
	}

	@Override
	public void deliver() throws RuntimeException {
		  throw new RuntimeException("\nCan't deliver a pizza not baked yet");
	}
	
		 
}
