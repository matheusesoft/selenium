package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.Propriedades;

public class DriverFactory {

	private static WebDriver driver;
	
	private DriverFactory() {}
	
	public static WebDriver getDriver(){
		String Bowser = Propriedades.getInstance().getProperty("browser").trim();
		if(driver == null)
		{
			if(Bowser.equals("CHROME")){
				System.setProperty("webdriver.chrome.driver", Propriedades.getInstance().getProperty("driver.chrome"));	
				driver = new ChromeDriver(); 
			}
			else if(Bowser.equals("FIREFOX")){
				System.setProperty("webdriver.gecko.driver", Propriedades.getInstance().getProperty("driver.firefox"));	
				driver = new FirefoxDriver(); 
			}
		}
		return driver;
	}
	
	public static void killDriver(){
		WebDriver driver = getDriver();
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}