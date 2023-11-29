package com.banking.bixi.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BixiStaffLoginPage {
	//Initializing Staff login elements
	@FindBy(name="staff_id")
	private WebElement staffid_txtbx;
	
	@FindBy(name="password")
	private WebElement password_txtbx;
	
	@FindBy(name="staff_login-btn")
	private WebElement stafflogin_btn;
	
	@FindBy(xpath="//label[text()='Staff']")
	private WebElement staff_txt;
	
	
	
	//declaring the webElement
	public BixiStaffLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilizing the webElement
	
	public WebElement getStaffid_txtbx() {
		return staffid_txtbx;
	}

	public WebElement getPassword_txtbx() {
		return password_txtbx;
	}

	public WebElement getStaff_txt() {
		return staff_txt;
	}

	public WebElement getStafflogin_btn() {
		return stafflogin_btn;
	}
	
	
	//Business Logic
	public void stafftextverify(String txt)
	{
		//To validate the text present in the staff login page
		String act = staff_txt.getText();
		Assert.assertEquals(txt, act, "Match Found");
	}
	public void Loginfunction(String stfid, String stfpw)
	{
		staffid_txtbx.sendKeys(stfid);
		password_txtbx.sendKeys(stfpw);
		stafflogin_btn.click();
	}
}
