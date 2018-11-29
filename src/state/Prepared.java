package state;

public class Prepared implements PizzaState {

	 private Pizza _pizza;
	 
	 public Prepared(Pizza pizza) {
		  _pizza = pizza;
	 }

	 @Override
	 public void prepare() throws Exception {
		 throw new RuntimeException ("Can't prepare an already prepared pizza");
		 
	 }
	 
	@Override
	public void bake() throws Exception {
		  System.out.print("Baking the pizza...");
		  _pizza.setState(new Baked(_pizza));
	}

	@Override
	public void deliver() throws Exception {
		  throw new RuntimeException("Can't deliver a pizza not baked yet");
	}
	
		 
}
