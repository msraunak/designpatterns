package simplemvcpassive;

import java.util.Observable;

public class MathModel {

	private int num1;
	private int num2;
	
	private int computedResult;
	
	
	public MathModel(){
		// Java does the default initialization; 
		// but making it explicit nevertheless
		num1 = 0;
		
	}
	/**
	 * Recursively compute the greatest common divisor of two numbers
	 * @param x the first integer
	 * @param y the second integer
	 * @return the greatest common divisor of x and y
	 * Algorithm: if (y==0) return x else return gcd(y,x%y)
	 */
	
	private int recursiveGCD(int x, int y){
		if (y==0)
			return x;
		else
			return recursiveGCD(y, x%y);
	}
	
	/* Compute the GCD Based on the two values 
	 * and notify the observers; */
	public void computeGCD(){
		computedResult = recursiveGCD(num1, num2);
	}
	
	/* Getters and Setters */
	public int getNum1() {
		return num1;
	}
	
	/* set the Value of the FirstaNumber */
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	
	public int getNum2() {
		return num2;
	}
	
	/* set the value of the Second Number */
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	/* getter method for computedResult */
	public int getComputedResult() {
		return computedResult;
	}

	
}
