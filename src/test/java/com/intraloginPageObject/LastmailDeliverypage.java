package com.intraloginPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LastmailDeliverypage {
	
	WebDriver ldriver;
	public LastmailDeliverypage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//ul/li/span/font[contains(text(),\"Last Mail Delivery\" )]")
	WebElement lastmaildelivery;
	
	@FindBy(xpath="//a[@id='codbiker']")
	
	WebElement codbikerlink;
	
	@FindBy(id="bikerType")
	WebElement selectBikerType;
	
	@FindBy(id="btnsearch")
	WebElement buttonSerach;
	
	@FindBy(xpath="//tr[@class='odd'][2]/td[7]//img")
    WebElement clickAddDetail;	
	
	@FindBy(id="updateunsettled_ship_count_limit")
	WebElement noOfShipment;
	@FindBy(id="updateMin_wallet_balance")
	WebElement minLimit;
	@FindBy(id="updateday_CODcash_allowed")
	WebElement dailyLimit;
	@FindBy(id="updateTime_limit")
	WebElement daylimit;
	@FindBy(xpath="(//button[contains(text(),'Update')])[2]")
	WebElement update;
	public void clickLastMailDeliveryLink() {
		lastmaildelivery.click();
	}
	public void clickMasterUtilityLink() {
		codbikerlink.click();
	}
	
	public void clickBikertype() {
		selectBikerType.click();
	}
	
	public void bikerTypeSelection() {
		
		Select select = new Select(selectBikerType);
		select.selectByVisibleText("Branch");
		
	}
	public void clickSerachButton() {
		buttonSerach.click();
	}
	
	public void clickOnEdit() {
		clickAddDetail.click();
		
	}
	public void setShipmentCount(String shipcount) {
		noOfShipment.sendKeys(String.valueOf(shipcount));
		
	}
	public void setMinLimit(String minlimit) {
		minLimit.sendKeys(String.valueOf(minlimit));
		
	}
	public void setMaxOSPerDay(String maxOs) {
		dailyLimit.sendKeys(String.valueOf(maxOs));
		
	}
	public void setMaxNoOfDays(String maxDays) {
		daylimit.sendKeys(String.valueOf(maxDays));
		}
	public void clickUpdate() {
		update.click();
		
	}
	
	

}
