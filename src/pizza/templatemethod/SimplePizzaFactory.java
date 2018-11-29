package pizza.templatemethod;

/**
 * A Simple factory class
 * @author from HeadFirstDesignPatterns
 */
public class SimplePizzaFactory {

	/* a public factory method */
	public Pizza createPizza(String type) {
		
		Pizza pizza = null;
		
		/* object creation pattern */
		// create a concrete pizza object based on the type
		switch(type){
			
			case "cheese": pizza = new CheesePizza(); break;
			case "pepperoni": pizza = new PepperoniPizza(); break;
			case "clam": pizza = new ClamPizza(); break;
			case "veggie": pizza = new VeggiePizza(); break;
		}
		
		return pizza;
	}
}
