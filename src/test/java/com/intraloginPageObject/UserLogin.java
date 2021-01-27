package com.intraloginPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLogin {
	
	WebDriver rdriver;
	
	public UserLogin(WebDriver driver) {
		rdriver=driver;
		PageFactory.initElements(driver, this);
	    }
	@FindBy(id="logid")
	WebElement userid; 
	
	@FindBy(id="pass")
	WebElement userpassword; 
	
	@FindBy(name="button")
	WebElement clickSubmit; 
	
	@FindBy(id="Logoff")
	WebElement logout;
	
	@FindBy (id="btnClose")
	WebElement closepopup;
	
	public void setUsername(String username) {
		
		userid.sendKeys(username);
		
	}
	
	public void setUserpassword(String password) {
		
		userpassword.sendKeys(password);
		
	}
	
	public void clickSignin() {
		
		clickSubmit.click();;
		
	}
	
	public void logout() {
		logout.click();
	}
	
	public void closePopupMsg() {
		closepopup.click();
	}
	
	
}
