package ca.google.methods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class GoogleHome {
	
	public static String searchBox_Xpath = "//input[@title=\"Search\"]";
	public static String keywordFromSuggestion_Xpath = "//span[contains(text(),\"Kira Systems\")]";
	public static String webpageLinks_Xpath = "//div[@id=\"search\"]//a";
	
	WebDriver driver;
	LoadProperties loadObj = new LoadProperties();
	CaptureScreenshot srnObj = new CaptureScreenshot();
		
	public void openBrowser()
	{

		try {
			
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			Reporter.log("Browser opened");
			
		} catch (Exception e) {
			
			Reporter.log("Browser load failed!!");
			Assert.fail("Browser load failed!!");
			
		}

	}	

	public void closeBrowser()
	{
		
		try {
			
			driver.quit();
			Reporter.log("Browser closed");
			
		} catch (Exception e) {
			
			Reporter.log("Browser quit failed!!");
			Assert.fail("Browser quit failed!!");
			
		}
	}
	
	public void launchWebsite(String url)
	{
		
		try {
			
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Reporter.log("We are currently on the following URL: " +driver.getCurrentUrl());
			
		} catch (Exception e) {
			
			Reporter.log("Website launch failed!!");
			Assert.fail("Website launch failed!!");
			
		}
		
	}
	
	public void searchKeyword(String searchKeyword) {
		
		try {
			
			Reporter.log("Search using keyword: " + searchKeyword);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchBox_Xpath)));
			WebElement searchBox = driver.findElement(By.xpath(searchBox_Xpath));
			searchBox.sendKeys(searchKeyword);
			searchBox.sendKeys(Keys.ENTER);
			
		} catch(Exception e) {
				
			Reporter.log("Keyword search failed!!");
			Assert.fail("Keyword search failed!!");
			srnObj.takeScreenShot(driver, "searchKeyword");
			driver.close();
			
		}
		

	}
	
	public void searchKeywordUsingAutoSuggestion(String searchKeyword) {
		
		try {
			
			Reporter.log("Search using keyword: " + searchKeyword);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchBox_Xpath)));
			WebElement searchBox = driver.findElement(By.xpath(searchBox_Xpath));
			searchBox.sendKeys(searchKeyword);
			WebElement suggestionLink = driver.findElement(By.xpath(keywordFromSuggestion_Xpath));
			suggestionLink.click();
			
		} catch(Exception e) {
						
			Reporter.log("Keyword search failed!!");
			Assert.fail("Keyword search failed!!");
			srnObj.takeScreenShot(driver, "searchKeywordUsingAutoSuggestion");
			driver.close();
			
		}		

	}
	
	public void verifyLink(String link) {
		
		try {
			
			Reporter.log("Verify the first link in search results to be: " + link);
			List<WebElement> links = driver.findElements(By.xpath(webpageLinks_Xpath));
			
			String firstLink = links.get(0).getAttribute("href");
			Reporter.log("Link from webpage: " + firstLink);
			if(firstLink.equals(link)) {
				Assert.assertTrue(firstLink.equals(link));
			} else {
				srnObj.takeScreenShot(driver, "verifyLink");
				Assert.fail("The first link in search page is not for Kira Systems");
			}
			
		} catch (Exception e) {
			
			Reporter.log("Link verification failed!!");
			Assert.fail("Link verification failed!!");
			srnObj.takeScreenShot(driver, "verifyLink");
			driver.close();
			
		}
		
	}

}
