package com.mindtree.uiStore;

import org.openqa.selenium.By;

public class PersonalizedGiftsUi {

	public static By personalizedButton=By.xpath("//button[contains(text(),'Personalized Gifts')]");
	public static By glassBottle = By.xpath("//div[contains(text(),'Personalized Name Glass Bottle | COD Not Available')]");
	public static By quantity = By.xpath("//input[@id='quantity']");
	public static By name=By.name("properties[Personalized Name]");
	public static By cart =By.xpath("//button[@name='add']");
	public static By formCart=By.cssSelector("form.drawer__contents.cart.ajaxcart");
	public static By close=By.cssSelector("button.drawer__close-button.js-drawer-close");
	public static By getHome=By.cssSelector("img.small--hide");

}
