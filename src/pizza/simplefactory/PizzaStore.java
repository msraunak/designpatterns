package pizza.simplefactory;

/**
 * The PizzaStore class that needs to prepare the Pizzas
 * @author Mohammad S. Raunak
 *
 */
public class PizzaStore {
	
	SimplePizzaFactory factory;
 
	public PizzaStore(SimplePizzaFactory factory) { 
		this.factory = factory;
	}
 
	public Pizza orderPizza(String type) {
		Pizza pizza;
 
		pizza = factory.createPizza(type);
 
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}

}
