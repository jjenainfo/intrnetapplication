package com.intraloginTestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.intraloginPageObject.UserLogin;

public class LoginToIntranet_TC_001 extends BaseClass{
	
	@Test
	public void loginTointranet() throws IOException {
	
	    logger.info("Browser open");
		UserLogin userlogin = new UserLogin(driver);
		userlogin.setUsername(userName);
		logger.info("User name provided");
		userlogin.setUserpassword(password);
		logger.info("Password Provided");
		userlogin.clickSignin();
		String str=driver.getTitle();
		System.out.println(str);
		
		if(str.equalsIgnoreCase("DTDC - Intranet")) {
			Assert.assertTrue(true);
			logger.info("Test case passed");
		}
		else {
			screenShot(driver, "loginTointranet");
			Assert.assertTrue(false);
			logger.info("Test case Failed");
		}
		
	}

}
