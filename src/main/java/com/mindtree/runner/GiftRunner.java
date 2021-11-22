package com.mindtree.runner;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.mindtree.pageObject.*;
import com.mindtree.exceptions.*;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.GetProperties;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class GiftRunner extends Base  {
	static Logger log;
	static ExtentTest test;
	static ExtentReports report;

	public GiftRunner() throws UtilityException, Exception {
		super();
	}

	@BeforeTest()
	public void initializeDriver() throws ApplicationException
	{
		try {
			report = new ExtentReports(System.getProperty("user.dir") + "\\reports\\" + "ExtentReportResults-"
					+ System.currentTimeMillis() + "-.html");
			log = Logger.getLogger(GiftRunner.class.getName());
			driver=initialize();
			test = report.startTest("Home Page");
			driver.get(GetProperties.get.getProperty("url"));
			driver.manage().window().maximize();
			ExtentLogUtilities.pass(driver, test, "URL Opened", log);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@Test(priority=1,dataProvider="getTitle")
	public void validateTitle(String title) throws ApplicationException{
		test = report.startTest("Validate Title");
		try {
			new ValidPage(driver,log, test).validate(title);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@DataProvider
	public Object[] getTitle()
	{
		Object data[]=new Object[1];
		data[0]=get.getProperty("title");
		return data;
	}
	@Test(priority=2,dataProvider="getData")
	public void LogIn(String uid,String pw) throws ApplicationException{
		test = report.startTest("Log in");
		try {
			new HomePageLogIn(driver, log, test).login(uid, pw);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@DataProvider
	public Object[] getData()
	{
		Object data[][]=new Object[1][2];
		data[0][0]=excelData.get("id");
		data[0][1]=excelData.get("pw");
		return data;
	}
	//personalized gift//
	@Test(priority=3,dataProvider="getPerData")
	public void PersonalizeGift(String qnt) throws ApplicationException{
		test = report.startTest("personalized gift");
		try {
			new PersonalizedGifts(driver, log, test).Getbottle(qnt);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@DataProvider
	public Object[] getPerData()
	{
		Object[] val = new Object[1];
		val[0] = "1";
		return val;
	}
	              
	
	            // secret santa ////
	
	@Test(priority=6)
	public void Secretsanta() throws ApplicationException {
		test = report.startTest("secret santa");
		try {
			new SecretSanta(driver, log, test).Secretsanta();
			report.endTest(test);
			report.flush();
		}
		catch(Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
		
	}
	   //corporate gifts //
	@Test(priority=7,dataProvider="getCorpData")
	public void corpDetailSubmit(String name,String gmail,String phn) throws ApplicationException{
		test = report.startTest("Corporate Gifts");
		try {
			new CorporateGifts(driver, log, test).fillDetails(name, gmail, phn);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@DataProvider
	public Object[][] getCorpData()
	{
		Object[][] val = new Object[1][3];
		val[0][0] =excelData.get("corporate Name");
		val[0][1] =excelData.get("corporate Email");
		val[0][2] =excelData.get("corporate phn");
		return val;
	}
	
	// Gifts drop down //
	@Test(priority=8,dataProvider="getGiftData")
	public void Gifts(String type,String qnt,String item) throws ApplicationException{
		test = report.startTest("Gifts");
		try {
			new Gifts(driver, log, test).orderGift(type, qnt, item);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@DataProvider
	public Object[][] getGiftData()
	{
		Object[][] val = new Object[1][3];
		val[0][0] =excelData.get("gifts type");
		val[0][1] =excelData.get("gifts quantity");
		val[0][2] =excelData.get("gifts items");
		return val;
	}
	
	                 //whats new //
	
	
	@Test(priority=9,dataProvider="getWhtData")
	public void WhtsNewGift(String qnt,String item) throws ApplicationException{
		test = report.startTest("What's New Gift");
		try {
			new WhatsNew(driver, log, test).addCart(qnt, item);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@DataProvider
	public Object[][] getWhtData()
	{
		Object[][] val = new Object[1][2];
		val[0][0] =excelData.get("what's new gift quantity");
		val[0][1] =excelData.get("what's new gift name");
		return val;
	}
	

	
	 // diwali gifts //
	
	@Test(priority=10,dataProvider="getdiwaliData")
	public void Diwaligift(String qnt,String item) throws ApplicationException {
		test=report.startTest("diwali gifts");
		try {
			new DiwaliGift(driver, log, test).addCart(qnt, item);
			report.endTest(test);
			report.flush();
			}
		catch(Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	
	@DataProvider
	public Object[][] getdiwaliData()
	{
		Object[][] val = new Object[1][2];
		val[0][0] =excelData.get("diwali gift quantity");
		val[0][1] =excelData.get("diwali gift name");
		return val;
	}
	
	//new year gifts//
	@Test(priority=11,dataProvider="getnewyearData")
	public void NewYear(String qnt,String item) throws ApplicationException {
		test=report.startTest("newyear gifts");
		try {
			new NewYear(driver, log, test).addCart(qnt, item);
			report.endTest(test);
			report.flush();
			}
		catch(Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	
	@DataProvider
	public Object[][] getnewyearData()
	{
		Object[][] val = new Object[1][2];
		val[0][0] =excelData.get("newyear gift quantity");
		val[0][1] =excelData.get("newyear gift name");
		return val;
	}
	  // rakhi gifts//
	@Test(priority=12,dataProvider="getrakhiData")
	public void Rakhi(String qnt,String item) throws ApplicationException {
		test=report.startTest("rakhi gifts");
		try {
			new Rakhi(driver, log, test).addCart(qnt, item);
			report.endTest(test);
			report.flush();
			}
		catch(Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	
	@DataProvider
	public Object[][] getrakhiData()
	{
		Object[][] val = new Object[1][2];
		val[0][0] =excelData.get("rakhi gift quantity");
		val[0][1] =excelData.get("rakhi gift name");
		return val;
	}
	
	// homestyle gifts//
	
	@Test(priority=13,dataProvider="getHomelifestyleData")
	public void homestyle(String type,String qnt,String item) throws ApplicationException{
		test = report.startTest("Homelifestyle");
		try {
			new HomeLifestyle(driver, log, test).orderGift(type, qnt, item);
			report.endTest(test);
			report.flush();
		} catch (Exception e) {
			report.endTest(test);
			report.flush();
			throw new ApplicationException(e.getMessage());
		}
	}
	@DataProvider
	public Object[][] getHomelifestyleData()
	{
		Object[][] val = new Object[1][3];
		val[0][0] =excelData.get("homestyle type");
		val[0][1] =excelData.get("homestyle quantity");
		val[0][2] =excelData.get("homestyle item");
		return val;
	}
	@AfterTest
	public void close() {
		driver.close();
	}
	
}
