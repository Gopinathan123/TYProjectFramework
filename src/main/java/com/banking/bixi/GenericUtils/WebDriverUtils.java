package com.banking.bixi.GenericUtils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	/**
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * 
	 * @param driver
	 * @param sec
	 */
	public void implecitWait(WebDriver driver, int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 * @param sec
	 */
	public void waitUntilElementToBeClickable(WebDriver driver, WebElement element, int sec)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 * @param sec
	 */
	public void waitUntilElementToBeVisible(WebDriver driver, WebElement element,int sec)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * 
	 * @param driver
	 * @param sec
	 */
	public void waitUntilPageLoad(WebDriver driver, int sec)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	/**
	 * 
	 * @param element
	 * @param index
	 */
	
	public void dropDownSelectByIndex(WebElement element, int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * 
	 * @param element
	 * @param value
	 */
	public void dropDownSelectByValue(WebElement element, String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
		
	}
	/**
	 * 
	 * @param element
	 * @param vtext
	 */
	public void dropDownSelectByVisbleText(WebElement element, String vtext)
	{
		Select sel=new Select(element);
		sel.selectByValue(vtext);
	}
	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void dropDownDeselectByIndex(WebElement element, int index)
	{
		Select sel=new Select(element);
		sel.deselectByIndex(index);
	}
	/**
	 * 
	 * @param element
	 * @param value
	 */
	public void dropDownDeselectByValue(WebElement element, String value)
	{
		Select sel=new Select(element);
		sel.deselectByValue(value);
		
	}
	/**
	 * 
	 * @param element
	 * @param vtext
	 */
	public void dropDownDeselectByVisbleText(WebElement element, String vtext)
	{
		Select sel=new Select(element);
		sel.deselectByVisibleText(vtext);
	}
	public void dropDownDeselectByAll(WebElement element)
	{
		Select sel= new Select(element);
		sel.deselectAll();
	}
	/**
	 * 
	 * @param driver
	 * @param src
	 * @param dest
	 */
	
	public void dragAndDrap(WebDriver driver, WebElement src, WebElement dest)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(src, dest).perform();
		
	}
	/**
	 * 
	 * @param driver
	 * @param target
	 */
	public void mouseHover(WebDriver driver, WebElement target)
	{
		Actions a=new Actions(driver);
		a.moveToElement(target).perform();
	}
	/**
	 * 
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.doubleClick().click().perform();
	}
	/**
	 * 
	 * @param driver
	 * @param target
	 */
	public void doubleClickAction(WebDriver driver, WebElement target)
	{
		Actions a=new Actions(driver);
		a.doubleClick(target);
	}
	/**
	 * 
	 * @param driver
	 */
	public void contextClickAction(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}
	
	/**
	 * 
	 * @param driver
	 * @param target
	 */
	public void contextClickAction(WebDriver driver, WebElement target)
	{
		Actions a=new Actions(driver);
		a.contextClick(target).perform();
	}
	/**
	 * 
	 * @param driver
	 */
	public void enterKeyAction(WebDriver driver)
	{
		Actions a= new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * 
	 * @throws Throwable
	 */
	public void keyPressEnter() throws Throwable {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);		
	}
	/**
	 * 
	 * 
	 */
	public void keyReleaseEnter() throws Throwable
	{
		Robot r= new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * 
	 * @param driver
	 * @param nameOrID
	 */
	public void switchToFrame(WebDriver driver, String nameOrID )
	{
		driver.switchTo().frame(nameOrID);
	}
	/**
	 * 
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	/**
	 * 
	 * @param driver
	 * @param partialWindTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindTitle)
	{
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			String winid = it.next();
			String currentWinTitle = driver.switchTo().window(winid).getTitle();
			if(currentWinTitle.contains(partialWindTitle))
			{
				break;
			}
		}
	}
	/**
	 * 
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.ScrollBy(0,500)", "");
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
//		int y=element.getLocation().getY();
//		js.executeScript("window.ScrollBy(0,"+y+")", element);	
		
		js.executeScript("argument[0].scrollIntoView()",element);
	}
	/**
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * 
	 * @param driver
	 */
	
	public void alertPopupWithText(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	/**
	 * 
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws Throwable
	 */
	public static String getScreenShot(WebDriver driver, String screenShotName) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\screenshot\\"+screenShotName+".png";
		File dst = new File(path);
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	/**
	 * 
	 * @param driver
	 */
	public void closebrowser(WebDriver driver)
	{
		driver.quit();
	}

}
