package singleton;

/**
 * Example of a Singleton Class
 * @author raunak
 */
	
public class ThreadSafeSingleton {

	private static ThreadSafeSingleton uniqueInstance;
	
	/* Making the constructor private. So, clients 
	 * can not instantiate an object of this class	 */			
	private ThreadSafeSingleton(){
		// empty
	}
	
	// make this synchronized so that it is thread-safe
	public static synchronized ThreadSafeSingleton getInstance(){
		// create a new instance if the instance does not exist yet
		if (uniqueInstance == null){
			uniqueInstance = new ThreadSafeSingleton();
		}
		
		return uniqueInstance;
	}
	
	/*
	 * Other methods of the Singleton class 
	 */
	
}
