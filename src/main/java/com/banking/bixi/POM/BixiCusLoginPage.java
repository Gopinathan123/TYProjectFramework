package com.banking.bixi.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BixiCusLoginPage {
	@FindBy(name="customer_id")
	private WebElement cusid_txtbx;
	@FindBy(name="")
	private WebElement pwd_txtbx;
	@FindBy()
	private WebElement login_btn;
	@FindBy()
	private WebElement forgetpwd_link;
	
	public BixiCusLoginPage(WebDriver  driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCusid_txtbx() {
		return cusid_txtbx;
	}

	public WebElement getPwd_txtbx() {
		return pwd_txtbx;
	}

	public WebElement getLogin_btn() {
		return login_btn;
	}

	public WebElement getForgetpwd_link() {
		return forgetpwd_link;
	}
	
	//Business Login
	
	public void CustomerLogin(String custID, String cusPwd)
	{
		cusid_txtbx.sendKeys(custID);
		pwd_txtbx.sendKeys(cusPwd);
		login_btn.click();
	}
	
	public void forgetPassword() {
		forgetpwd_link.click();
	}
	
}
