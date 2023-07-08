package hackathonProject.zigwheels.Action;

import hackathonProject.zigwheels.elements.HomePageElements;
import hackathonProject.zigwheels.util.pause;

public class loginErr {
	
	public static void userNF() {
		String errorText = HomePageElements.errormsg.getText();
		System.out.println("Error Text: " + errorText);
		pause.hold(3);
		System.out.println("***********************************END OF PROGRAM***************************************");
	}

}
