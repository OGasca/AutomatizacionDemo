package SELENIUM.DEMO.AUTOMATIZACION.TESTBASE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import SELENIUM.DEMO.MAVEN.POM.runExplorer.MyDrivers;

public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public static Properties Repository = new Properties();
	public File f;
	public FileInputStream FI;
	public static WebDriver driver;
	public String startTime;
	public static int indexSI = 1;
	public static ExtentReports extent;
	public static ExtentTest test;
	//protected static DesiredCapabilities desiredCapabilities;
	
	
	public void init() throws IOException {
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
		//traemos la ruta del archivo config.exploradorUrl
		loadPropertiesFile();
		//Del archivo config.exploradorURL traemos el valor de la variable "browser"
		selectBrowser(Repository.getProperty("browser"));
		//Del archivo config.exploradorURL traemos el valor de la variable "url"
		driver.get(Repository.getProperty("url"));
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	public void loadPropertiesFile() throws IOException {
		f = new File(System.getProperty("user.dir") + "//config.exploradorUrl");
		FI = new FileInputStream(f);
		Repository.load(FI);

	}
	
	    
	
	public void selectBrowser(String browser){
			
		
		if(System.getProperty("os.name").contains("Window")){
			if(browser.equalsIgnoreCase("firefox")){
				
				System.out.println(System.getProperty("user.dir"));
				
				//damos la ruta del driver del explorador asi como el driver
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
				
				//creando el objeto de browser osea del browser firefox
				driver = new FirefoxDriver();
				
			}
			else if(browser.equalsIgnoreCase("chrome")){
				//https://chromedriver.storage.googleapis.com/index.html
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
		}
		//else if(System.getProperty("os.name").contains("Mac")){
		//	System.out.println(System.getProperty("os.name"));
		//	if(browser.equalsIgnoreCase("firefox")){
		//		System.out.println(System.getProperty("user.dir"));
		//		System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"/drivers/geckodriver");
		//		driver = new FirefoxDriver();
		//	}
		//	else if(browser.equalsIgnoreCase("chrome")){
		//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
		//		driver = new ChromeDriver();
		//	}
		//}
	}
	
	
	public void log(String data) { 
		log.info(data);
		Reporter.log(data);
		test.log(LogStatus.INFO, data);
	}
	
	
	public void capturaPantalla(String name) {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {                                                                                       
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/SELENIUM/DEMO/AUTOMATIZACION/SCREENSHOT/";
			File destFile = new File((String) reportDirectory + name + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			// This will help us to link the screen shot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
			
	public void cerrarexplorador(){
	     driver.quit();
	     log.info("Explorador cerrado");
	}
	
	
	public void waitForElement(WebDriver driver, int timeOutInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

		
			


}
