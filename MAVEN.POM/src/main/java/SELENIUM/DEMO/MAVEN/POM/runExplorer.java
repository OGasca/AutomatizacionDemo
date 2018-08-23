package SELENIUM.DEMO.MAVEN.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class runExplorer {
	
	protected static DesiredCapabilities desiredCapabilities;
	public WebDriver driver = null;
	
	public enum MyDrivers
	{
		Chrome,
		Firefox		
	}
	
	public static WebDriver CreateMyDriver (MyDrivers myDriver)
	{
	
		desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setJavascriptEnabled(true);
	    desiredCapabilities.setCapability("takeScreenshot", false);
	
	switch (myDriver) {
		
	case Chrome:
			return new ChromeDriver();
	
	case Firefox:
		    System.setProperty("webdriver.gecko.driver","C:\\DriverExploradores\\firefox 16\\geckodriver.exe");
		    //System.setProperty("webdriver.gecko.driver","C:\\DriverExploradores\\geckodriver.exe");
	    
		    //System.setProperty("webdriver.firefox.marionette","C:\\DriverExploradores\\firefox 16\\geckodriver.exe");
		    //System.setProperty("webdriver.firefox.marionette", "C:\\DriverExploradores\\geckodriver.exe");
		    //WebDriver driver = new FirefoxDriver();    
	    	
	    	return new FirefoxDriver();
		    
		    default:
		    	throw new IllegalArgumentException("Driver provided is not implemented. Sorry ");
	
	                 }
	}
	
	@Test
	public  static void openExp(){
		
		WebDriver driver = CreateMyDriver(MyDrivers.Firefox);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String url = "http://www.facebook.com";
		driver.get(url);
		
		
		//driver.navigate().to("http://www.facebook.com");
		
		
		
	}

}
