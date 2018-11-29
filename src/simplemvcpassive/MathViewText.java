package simplemvcpassive;

public class MathViewText{

	// constructor
	public MathViewText (){
		// empty constructor
	}

	public void resultUpdated (int num1, int num2, int gcd){
		System.out.println("The GCD of " + num1 + " and " + num2 + " is: " + gcd);
	}
	
	public void num1Updated( int num1){
		System.out.println("num1 has been updated to: " + num1);
	}
	
	public void num2Updated (int num2){
		System.out.println("num2 has been updated to: " + num2);
	}
}
