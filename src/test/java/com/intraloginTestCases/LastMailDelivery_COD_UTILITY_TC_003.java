package com.intraloginTestCases;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.intraloginPageObject.LastmailDeliverypage;
import com.intraloginPageObject.UserLogin;

public class LastMailDelivery_COD_UTILITY_TC_003 extends BaseClass{
	
	@Test
	public void CodMasterUtility() throws Exception {
	        logger.info("Browser open");
			UserLogin userlogin = new UserLogin(driver);
			userlogin.setUsername(userName);
			logger.info("User name provided");
			userlogin.setUserpassword(password);
			logger.info("Password Provided");
			userlogin.clickSignin();
		    userlogin.closePopupMsg();
		    Thread.sleep(2000);
		LastmailDeliverypage lastmailDeliverypage=new LastmailDeliverypage(driver);
		lastmailDeliverypage.clickLastMailDeliveryLink();
		logger.info("clicked on last mail delivery");
		Thread.sleep(1000);
		lastmailDeliverypage.clickMasterUtilityLink();
		logger.info("clicked on master utility");
		
		Set <String> nameOfWindows=driver.getWindowHandles();
		
		for(String i:nameOfWindows) {
			
			String str=driver.switchTo().window(i).getTitle();
			System.out.println(str);
			if(str.equals("Biker Report")) {
				lastmailDeliverypage.clickBikertype();
				lastmailDeliverypage.bikerTypeSelection();
				logger.info("biker selected");
				
				lastmailDeliverypage.clickSerachButton();
				logger.info("submit button clicked");
				
				Thread.sleep(2000);
				lastmailDeliverypage.clickOnEdit();
				logger.info("edit button clicked");
				Thread.sleep(1000);
				
				lastmailDeliverypage.setShipmentCount(daywiseshipcount);
				screenShot(driver, "shipcountperday");
				logger.info("daywise shipcount entered");
				
				lastmailDeliverypage.setMinLimit(minlimit);
				screenShot(driver, "minlimit");
				logger.info("min limit entered");
				
				lastmailDeliverypage.setMaxOSPerDay(dailyallowed);
				screenShot(driver, "perdaylimit");
				logger.info("Max os entered");
				lastmailDeliverypage.setMaxNoOfDays(noofdays);
				screenShot(driver, "perdays");
				logger.info("max days entered");
				lastmailDeliverypage.clickUpdate();
				logger.info("update clicked");
				screenShot(driver, "updatescreen");
				swithchToAlert();
				logger.info("alert accepted");
				screenShot(driver, "updated");
				driver.close();
			}
			
			
		}
		
	}

}
