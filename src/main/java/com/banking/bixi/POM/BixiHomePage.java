package com.banking.bixi.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.banking.bixi.GenericUtils.WebDriverUtils;

public class BixiHomePage extends WebDriverUtils{
	//Declaration the element in the page
	@FindBy(linkText = "Home")
	private WebElement home_link;
	
	@FindBy(xpath="//a[text()='Staff Login']")
	private WebElement staff_login_link;
	
	@FindBy(xpath="//li[text()='Open Account']")
	private WebElement Open_account;
	
	@FindBy(xpath="//li[text()='Apply Debit Card']")
	private WebElement Apply_Debit_card;
	
	@FindBy(xpath="//a[contains(text(),'Internet Banking')]")
	private WebElement IB;
	
	@FindBy(xpath = "//li[text()='Login ']")
	private WebElement IB_login;
	
	@FindBy(xpath = "//li[text()='Register']")
	private WebElement IB_register; 
	
	@FindBy(xpath = "//li[text()='Fund Transfer']")
	private WebElement fund_transfer;
	
	//Initialize the element using constructor
	public BixiHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	
	public WebElement getStaff_login_link() {
		return staff_login_link;
	}

	public WebElement getHome_link() {
		return home_link;
	}

	public WebElement getOpen_account() {
		return Open_account;
	}

	public WebElement getApply_Debit_card() {
		return Apply_Debit_card;
	}

	public void setIB() {
		return;
	}

	public WebElement getIB_login() {
		return IB_login;
	}

	public WebElement getIB_register() {
		return IB_register;
	}

	public WebElement getFund_transfer() {
		return fund_transfer;
	}
	
	//Business Logic
	public void click_StaffLogin() {
		staff_login_link.click();
	}
	
	public void click_Open_account() {
		Open_account.click();
	}
	
//	public void IBRegister() {
//		IB_register.click();	
//	}
	
	public void homeLink() {
		home_link.click();
	}
	
	public void ApplyDebitCardLink()
	{
		Apply_Debit_card.click();
	}
	
	public void IBLogin(WebDriver driver)
	{
		mouseHover(driver, IB);
		mouseHover(driver, IB_login);
		IB_login.click();
	}
	
	public void fundTransfer() {
		fund_transfer.click();
	}
		
	public void clickOnregisterBtn(WebDriver driver)
	{
		mouseHover(driver, IB);
		mouseHover(driver, IB_register);
		IB_register.click();
		
	}
}
