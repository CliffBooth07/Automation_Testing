package provider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class proppro {
	public static Properties prop = new Properties();
	public static void cont() {
		
		FileReader reader=null;
		try {
			reader = new FileReader("C:\\Users\\pawan\\eclipse-workspace\\INTQEA23QE005_8_Timesheet\\Check\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
