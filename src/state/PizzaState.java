package state;

/**
 * A Simple Pizza state example;
 */
public interface PizzaState {

	/**
	 * Method for preparing the Pizza
	 * @throws Exception
	 */
	void prepare() throws Exception;
	
	/**
	 * Method for baking the Pizza
	 * @throws Exception
	 */
	void bake() throws Exception;

	/**
	 * Method for delivering the Pizza
	 * @throws Exception
	 */
	void deliver() throws Exception;
	
	
}


