package com.banking.bixi.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BixiStaffHomePage {
	
	//Initializing the elements in Staff home Page
	@FindBy(name="home")
	private WebElement home_btn;
	
	@FindBy(name="logout_btn")
	private WebElement logout_btn;
	
	@FindBy(name="viewdet")
	private WebElement viewActiveCusElement_btn;
	
	@FindBy(name="apprvac")
	private WebElement approvependingAc_btn;
	
	@FindBy(name="view_cust_by_ac")
	private WebElement view_cust_by_ac_btn;
	
	@FindBy(name="del_cust")
	private WebElement del_cust_btn;
	
	@FindBy(name="credit_cust_ac")
	private WebElement credit_cust_ac_btn;
	
	//declaration
	public BixiStaffHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getHome_btn() {
		return home_btn;
	}

	public WebElement getLogout_btn() {
		return logout_btn;
	}

	public WebElement getViewActiveCusElement_btn() {
		return viewActiveCusElement_btn;
	}

	public WebElement getApprovependingAc_btn() {
		return approvependingAc_btn;
	}

	public WebElement getView_cust_by_ac_btn() {
		return view_cust_by_ac_btn;
	}

	public WebElement getDel_cust_btn() {
		return del_cust_btn;
	}

	public WebElement getCredit_cust_ac_btn() {
		return credit_cust_ac_btn;
	}
	
	//Business logic
	
	public void homeClick() {
		home_btn.click();
	}
	public void logoutclick()
	{
		logout_btn.click();
	}
	public void viewActiveCustClick() {
		viewActiveCusElement_btn.click();
	}
	public void approvePendingCustClick(){
		approvependingAc_btn.click();
	}
	public void deleteCustClick() {
		del_cust_btn.click();
	}
	public void viewCustByACNoClick() {
		viewActiveCusElement_btn.click();
	}
	public void creidtCustClick()
	{
		credit_cust_ac_btn.click();
	}
	

}
