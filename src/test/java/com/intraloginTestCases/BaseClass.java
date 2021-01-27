package com.intraloginTestCases;




import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.utils.FileUtil;
import com.intraloginUtilities.Readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	Readconfig readconfig = new Readconfig();
	String url=readconfig.getURL();
	String userName=readconfig.getUserName();
	String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	@BeforeClass
	@Parameters("browser")
	 public void open_browser(String br) {
	   
		logger= Logger.getLogger(BaseClass.class.getName());
	    PropertyConfigurator.configure("log4j.properties");
	    if(br.equals("chrome")) {
	    WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	    }
	    else if (br.equals("Firefox")) {
	    WebDriverManager.firefoxdriver().setup();
	    driver=new FirefoxDriver();
		}
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }
	
	@AfterClass
	public void tearDown() {
	driver.quit();
		
	}
	
	public void screenShot(WebDriver driver,String tname) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir")+"/screenshot/"+tname+".PNG");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Captured");
		
	}

}
