package com.mindtree.pageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.reusableComponent.WebDriverSupport;
import com.mindtree.uiStore.DiwaliGiftUi;
import com.relevantcodes.extentreports.ExtentTest;

public class DiwaliGift extends DiwaliGiftUi {
	WebDriver driver;
	Logger log;
	ExtentTest test;

	public DiwaliGift(WebDriver driver, Logger log, ExtentTest test) throws Exception {
		this.driver = driver;
		this.test = test;
		this.log = log;
	}
	public void addCart(String qnt,String item) throws ReusableComponentException, Exception
	{
		WebDriverSupport.click(driver, diwaliButton,"Home page","diwali Gift button", log, test);
		List<WebElement>listRec=driver.findElements(result);
		for(WebElement temp:listRec)
		{
			if(temp.getText().equalsIgnoreCase(item))
			{
				WebDriverSupport.clickByWebElement(driver, temp,"result page",item, log, test);
				break;
			}
		}
		Thread.sleep(2000);
	driver.findElement(quantity).clear();
	WebDriverSupport.sendKeys(driver,quantity,"Cart Page","Quantity Field", log, test, qnt);
	WebDriverSupport.click(driver, cart,"Cart page", "Add to cart", log, test);
	Thread.sleep(3000);
	if(driver.findElement(formCart).isDisplayed())
	{
		WebDriverSupport.click(driver,close,"Cart Page","Close Button", log, test);
	}
	WebDriverSupport.click(driver,getHome,"cart","Bigsmall pic", log, test);
	}
	
}
	


