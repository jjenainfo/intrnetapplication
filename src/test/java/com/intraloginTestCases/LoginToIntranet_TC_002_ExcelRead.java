package com.intraloginTestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.intraloginPageObject.UserLogin;
import com.intraloginUtilities.XLSXUtilities;
import com.intraloginUtilities.XLUtilities;

public class LoginToIntranet_TC_002_ExcelRead extends BaseClass {
	
	@Test(dataProvider="LoginFromExcel")
	public void readDataFromExcel(String uname,String pswd) throws InterruptedException, IOException {
		
		UserLogin ul = new UserLogin(driver);
		ul.setUsername(uname);
		System.out.println("user name given");
		ul.setUserpassword(pswd);
		System.out.println("pwd name given");
		ul.clickSignin();
		System.out.println("clicked");
		
		String str1=driver.getTitle();
		System.out.println(str1);
		
		//String str1=driver.getCurrentUrl();
		//System.out.println(str1);
		
	    String str2 =driver.findElement(By.xpath("//tr/td[@class='worldcup_msg_title']")).getText();
	    System.out.println(str2);
		
		if(str2.equalsIgnoreCase("Public Notice")){
			ul.closePopupMsg();
			System.out.println("clicked on pop up");
			
			screenShot(driver, "readDataFromExcel2");
			ul.logout();
			Thread.sleep(1000);
			logger.info("logged in process completed sucessfully");
			Assert.assertTrue(true);
			
			
			}
		else {
			String str =driver.findElement(By.xpath("//div[@class='text-center p-t-12'][1]")).getText();
		    System.out.println(str);
		    screenShot(driver, "readDataFromExcel1");
			logger.info("logged in failed");
			Assert.assertTrue(false);
			
			}
	
		
		
		}
		
		
	
	@DataProvider(name ="LoginFromExcel")
	
	public String [][] getData() throws Exception {
		
		String path="./src/test/java/com/intraloginTestData/New XLSX Worksheet.xlsx";
		
		int rowcount= XLSXUtilities.getRowCount(path, "Sheet1");
		int colcount= XLSXUtilities.getCellCount(path, "Sheet1", 1);
		
		String loginData[][]=new String[rowcount][colcount];
		
		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				
				loginData[i-1][j]=XLSXUtilities.getCellData(path, "Sheet1", i, j);
				
			}
		}
		return loginData;
	}

}
