package com.banking.bixi.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PendingCustomerPage {
	//initialization
	@FindBy(name="application_no")
	private WebElement appno_txtbx;
	
	@FindBy(name="search_application")
	private WebElement App_search_btn;
	
	@FindBy(name="approve_cust")
	private WebElement approve_btn;
	
	//Declaration
	public PendingCustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization

	public WebElement getAppno_txtbx() {
		return appno_txtbx;
	}

	public WebElement getApp_search_btn() {
		return App_search_btn;
	}

	public WebElement getApprove_btn() {
		return approve_btn;
	}
	
	//Business Logic
	
	public void SearchAppno(String App_no) {
		appno_txtbx.sendKeys(App_no);
		App_search_btn.click();
	}
	public void clickApprove() {
		approve_btn.click();
	}
	
	
	
	
	
}
