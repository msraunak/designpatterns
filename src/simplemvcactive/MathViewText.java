package simplemvcactive;

import java.util.Observable;
import java.util.Observer;

public class MathViewText implements Observer {

	// constructor
	public MathViewText (){
		// empty constructor
	}

	@Override
	public void update(Observable mathModel, Object additionalData) {
		
		MathModel model;
		if (mathModel instanceof MathModel){
			model = (MathModel) mathModel;
			if (additionalData == null ) {
				System.out.println("The GCD of "+ model.getNum1() + " and " + model.getNum2() + " is: " + model.getComputedResult());
			} else if (additionalData instanceof Integer && ((Integer)additionalData).intValue() == 1 ) {
				System.out.println("The first number has been updated to: " + model.getNum1());
			} else if (additionalData instanceof Integer && ((Integer)additionalData).intValue() == 2 ) {
				System.out.println("The second number has been updated to: " + model.getNum2());
			}
		}
	}
}
