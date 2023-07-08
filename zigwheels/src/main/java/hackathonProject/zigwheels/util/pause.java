package hackathonProject.zigwheels.util;

import java.util.concurrent.TimeUnit;

public class pause {
	
	public static void hold(int n) {
		
//        Thread.sleep(3000);
		TimeUnit tu = TimeUnit.SECONDS;
		try {
			tu.sleep(n);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
