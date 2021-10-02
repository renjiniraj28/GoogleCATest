package ca.google.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ca.google.methods.*;

public class GoogleSearch {
	
	GoogleHome searchObj = new GoogleHome();
	LoadProperties loadObj = new LoadProperties();
	
	@BeforeMethod
	public void testSetup() {
		searchObj.openBrowser();
	}
	
	@Test
	public void searchForKiraSystemsUsingKeypressAndVerifyLink() {
		try {
						
			searchObj.launchWebsite(loadObj.loadProperties("website.url"));
			searchObj.searchKeyword(loadObj.loadProperties("search.keyword"));	
			searchObj.verifyLink(loadObj.loadProperties("verification.link"));
		
		} catch (Exception e) {
			
			searchObj.closeBrowser();
			
		}
		
	}
	
	@Test
	public void searchForKiraSystemsUsingAutoSuggestionAndVerifyLink() {
		try {
						
			searchObj.launchWebsite(loadObj.loadProperties("website.url"));
			searchObj.searchKeywordUsingAutoSuggestion(loadObj.loadProperties("search.keyword"));	
			searchObj.verifyLink(loadObj.loadProperties("verification.link"));
		
		} catch (Exception e) {
			
			searchObj.closeBrowser();
			
		}
		
	}
	
	@Test
	public void invalidSearch() {
		try {
						
			searchObj.launchWebsite(loadObj.loadProperties("website.url"));
			searchObj.searchKeyword(loadObj.loadProperties("invalid.keyword"));	
			searchObj.verifyLink(loadObj.loadProperties("verification.link"));		
		
		} catch (Exception e) {
			
			searchObj.closeBrowser();
			
		}
		
	}
	
	@AfterMethod
	public void testTeardown() {
		searchObj.closeBrowser();
	}


}
