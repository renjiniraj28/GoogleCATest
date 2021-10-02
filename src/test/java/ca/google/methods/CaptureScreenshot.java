package ca.google.methods;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {
	
	public void takeScreenShot(WebDriver driver, String name) {
	   	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   	 Date date = new Date();
	           try {
	        	   	File destFile = new File("/Users/rrajagop/eclipse-workspace/GoogleAutomation/src/test/java/results/"+name+"_"+date.getTime()+".png");
					FileUtils.copyFile(scrFile, destFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
	   }

}
