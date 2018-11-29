package state2;

/*
 * To run the Pizza patter example
 */
public class PizzaTest {

	public static void main(String[] args) {
			
		Pizza pizza = new Pizza();
		try {
			
			pizza.bake();
			pizza.deliver();
			pizza.bake();
		} catch (Exception re){
			System.out.println(re);
		}
	}
}
