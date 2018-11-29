package state2;

public class Baked extends PizzaState{

	
	public Baked (Pizza pizza){
		super (pizza);
	}
	
	
	@Override
	public void bake() throws RuntimeException {
		throw new RuntimeException("\nCan't bake a pizza that is already baked!");
	}

	@Override
	public void deliver() throws RuntimeException {
		System.out.print("\nDelivering the pizza...");
		_pizza.setState( new Delivered( _pizza ) );
	}

}
