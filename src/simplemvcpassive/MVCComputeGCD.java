package simplemvcpassive;


public class MVCComputeGCD {

	  public static void main(String[] args) {
	         
	      MathModel theModel = new MathModel();  
		  MathViewGUI guiView = new MathViewGUI();
		  MathViewText textView = new MathViewText();
		  
	      MathController theController = new MathController(theModel, guiView, textView);
	         
	      guiView.setVisible(true);
	         
	   }
	
}
