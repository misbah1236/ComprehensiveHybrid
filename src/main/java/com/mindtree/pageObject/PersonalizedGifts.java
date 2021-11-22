package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.PersonalizedGiftsUi;
import com.relevantcodes.extentreports.ExtentTest;

public class PersonalizedGifts extends PersonalizedGiftsUi {

	WebDriver driver;
	Logger log;
	ExtentTest test;

	public PersonalizedGifts(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
		public void Getbottle(String quant) throws ReusableComponentException, Exception {
			
			WebDriverSupport.click(driver, personalizedButton,"Home page","Personalize Gift button", log, test);
			WebDriverSupport.click(driver, glassBottle,"Personalize Gift page","result", log, test);
			Thread.sleep(2000);
		driver.findElement(quantity).clear();
		WebDriverSupport.sendKeys(driver,quantity,"Cart Page","Quantity Field", log, test, quant);
		WebDriverSupport.sendKeys(driver,name,"Cart Page","name Field", log, test,"Misbah");
		WebDriverSupport.click(driver, cart,"Cart page", "Add to cart", log, test);
		Thread.sleep(2000);
		if(driver.findElement(formCart).isDisplayed())
		{
			WebDriverSupport.click(driver,close,"Cart Page","Close Button", log, test);
		}
		WebDriverSupport.click(driver, getHome,"home page", "home button", log, test);
		Thread.sleep(2000);
		
		
		}
}
