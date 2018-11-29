package singleton;
/**
 * Example of a Singleton Class
 * @author raunak
 */
	
public class Singleton {

	private static Singleton uniqueInstance;
	
	//don't let java give you a default public constructor
	/* Making the constructor private. So, clients 
	 * can not instantiate an object of this class	 */			
	private Singleton(){
		// empty
	}
	
	public static Singleton getInstance(){
		// create a new instance if the instance does not exist yet
		if (uniqueInstance == null){
			uniqueInstance = new Singleton();
		}
		
		return uniqueInstance;
	}
	
	/*
	 * Other methods of the Singleton class 
	 */
	
}
