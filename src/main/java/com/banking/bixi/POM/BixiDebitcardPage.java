package com.banking.bixi.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BixiDebitcardPage {
	//Declaration
	
		@FindBy(xpath = "//input[@name='holder_name']")
		private WebElement txt_name;
		
		@FindBy(xpath = "//input[@name='dob']")
		private WebElement txt_dob;
		
		@FindBy(xpath = "//input[@name='pan']")
		private WebElement txt_pan;
		
		@FindBy(xpath = "//input[@name='mob']")
		private WebElement txt_mob;
		
		@FindBy(xpath = "//input[@name='acc_no']")
		private WebElement txt_account;
		
		@FindBy(xpath = "//input[@name='dbt_crd_submit']")
		private WebElement btn_debitcard;
		
		//Initialization
		
		public BixiDebitcardPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		
		//Utilization
		public WebElement getTxt_name() {
			return txt_name;
		}
		
		public WebElement getTxt_dob() {
			return txt_dob;
		}

		public WebElement getTxt_pan() {
			return txt_pan;
		}

		public WebElement getTxt_mob() {
			return txt_mob;
		}

		public WebElement getTxt_account() {
			return txt_account;
		}

		public WebElement getBtn_debitcard() {
			return btn_debitcard;
		}
		
		//Business Logic
		public void send_Detail(String NAME, String PAN, String MOB, String ACCOUNTNO) 
		{
			txt_name.sendKeys(NAME);
			txt_pan.sendKeys(PAN);
			txt_mob.sendKeys(MOB);
			txt_account.sendKeys(ACCOUNTNO);
		}
		public void enter_Date(String DOB) 
		{
			txt_dob.sendKeys(DOB);
		}
		public void click_submit()
		{
			btn_debitcard.click();
		}
		
		
}
