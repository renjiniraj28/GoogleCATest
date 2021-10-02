package ca.google.methods;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
	
	public String loadProperties(String key) {
		String value = null;
		
		try (InputStream input = new FileInputStream("/Users/rrajagop/eclipse-workspace/GoogleAutomation/config.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return null;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and return it
            value = prop.getProperty(key);
           

        } catch (IOException ex) {
            ex.printStackTrace();
        }
		
		 return value;

	}


}
