package com.mindtree.uiStore;

import org.openqa.selenium.By;

public class HomeLifestyleUi {
	public static By HomeAndLifestyleButton=By.xpath("//a[@data-dropdown-rel='home-lifestyle']");
	public static By dropDown=By.xpath("(//ul[@class='site-nav__dropdown text-left'])[5] //a");
	public static By result = By.cssSelector("div.grid-product__title");
	public static By quantity = By.xpath("//input[@id='quantity']");
	public static By cart = By.xpath("//button[@name='add']");
	public static By formCart=By.cssSelector("form.drawer__contents.cart.ajaxcart");
	public static By close=By.cssSelector("button.drawer__close-button.js-drawer-close");
	public static By getHome=By.cssSelector("img.small--hide");

}
