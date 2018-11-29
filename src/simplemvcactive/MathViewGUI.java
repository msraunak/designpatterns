package simplemvcactive;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MathViewGUI extends JFrame implements Observer {


	private JTextField firstNumber  = new JTextField(10);
	private JTextField secondNumber = new JTextField(10);
	private JButton computeGCDButton = new JButton("Compute GCD");
	
	private JTextField computedGCDBox = new JTextField(10);
	
	
	MathViewGUI(){
		
	
		// Sets up the view and adds the components
		JPanel calcPanel = new JPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 200);
		
		calcPanel.add(firstNumber);
		calcPanel.add(secondNumber);
		calcPanel.add(computeGCDButton);
		calcPanel.add(computedGCDBox);
		
		this.add(calcPanel);
		
	}
	

	public int getFirstNumber(){
			return Integer.parseInt(firstNumber.getText());
	}
	
	public int getSecondNumber(){
		return Integer.parseInt(secondNumber.getText());
	}
	
	public int getComputedGCDBox(){
		return Integer.parseInt(computedGCDBox.getText());
	}
	
	// methods in this class will be able to use it
	private void setComputedGCDBox(int solution){
		computedGCDBox.setText(Integer.toString(solution));
	}
	
	// If the calculateButton is clicked execute a method inside a 
	// specific inner class in the Controller named actionPerformed
	void addCalculateListener(ActionListener listenForCalcButton){
		computeGCDButton.addActionListener(listenForCalcButton);
	}
	
	// If the calculateButton is clicked execute a method inside 
	// a specific inner class in the Controller named actionPerformed
	void addFirstNumberListener(ActionListener listenForFirstNumber ){
		firstNumber.addActionListener (listenForFirstNumber);
	}
	
	void addSecondNumberListener(ActionListener listenForFirstNumber ){
		secondNumber.addActionListener (listenForFirstNumber);
	}
	
	
	// Open a popup that contains the error message passed
	void displayErrorMessage(String errorMessage){
		JOptionPane.showMessageDialog(this, errorMessage);
	}	

	// This method will be invoked by the model when there 
	// is an update in the gcd value in the model
	@Override
	public void update(Observable obs, Object additionalData) {
		
		MathModel model;
		// only update when the additionalData is null
		if (obs instanceof MathModel && additionalData == null) {
			model = (MathModel)obs; 
			setComputedGCDBox( model.getComputedResult() );
		}
		
	}

	
	

}
