package simplemvcpassive;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MathController {
	
	
	private MathModel theModel;
	private MathViewGUI guiView;
	private MathViewText textView;
	 
	
	public MathController(MathModel theModel, MathViewGUI theView, MathViewText textView ) {
		
		this.guiView = theView;
		this.theModel = theModel;
		
		// Tell the View that when ever the computeGCD button
		// is clicked to execute the actionPerformed method
		// in the ComputeGCDListener inner class
		this.guiView.addCalculateListener(new ComputeGCDListener());
		this.guiView.addFirstNumberListener(new FirstNumberListener());
		this.guiView.addSecondNumberListener(new SecondNumberListener());
		
	}
	// ComputeGCDListener inner class
	class ComputeGCDListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			// Surround interactions with the view with
			// a try block in case numbers weren't properly entered
			try{
				theModel.computeGCD();
				guiView.setComputedGCDBox(theModel.getComputedResult());
				textView.resultUpdated(theModel.getNum1(), theModel.getNum2(), theModel.getComputedResult());
			}
			catch(NumberFormatException ex){
				System.out.println(ex);
				guiView.displayErrorMessage("Enter 2 Integers to compute GCD");
			}
		}
	}		

	// inner class to listen to the firstNumber textBox
	class FirstNumberListener implements ActionListener {
		
		public void actionPerformed (ActionEvent e){
			try {
				// update the model's first number
				theModel.setNum1(guiView.getFirstNumber());
				textView.num1Updated(theModel.getNum1());
			} catch (NumberFormatException ex){
				System.out.println(ex);
				guiView.displayErrorMessage("You must enter and Integer");
			}
		}
	}// end of FirstNumberLIstener
	
	// inner class to listen to second number textBox
	class SecondNumberListener implements ActionListener {
			
		public void actionPerformed (ActionEvent e){
			try {
				// update the model's first number
				theModel.setNum2(guiView.getSecondNumber());
				textView.num2Updated(theModel.getNum2());
			} catch (NumberFormatException ex){
				System.out.println(ex);
				guiView.displayErrorMessage("You must enter and Integer");
			}
				
		}
	} // end of SecondNumberLIstener

}
