package SELENIUM.DEMO.MAVEN.POM;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

//import Automation.llenadoFormulario;

/**
 * Se genera el WebDriver controlador de FireFox
 *
 */
public class Base {
	
	Reade_Excel3 excel;
	
	@FindBy(xpath = "html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b/text()")
	WebElement hechoregistro;           
	              
	                 
	                 
	public WebDriver driver = null;
	
	public WebDriver getDriver() {
		driver = new FirefoxDriver();
		return driver;
	}
	
	
	public String[][] getData(String excelName, String sheetName) {
		                                             
		String path = System.getProperty("user.dir")+"//src//main//java//SELENIUM//DEMO//MAVEN//POM//"+excelName ;
		excel = new Reade_Excel3(path);
		String [] [] data = excel.getDataFromSheet(sheetName, excelName);
		return data;
	}
	
	
	public boolean verificarregistro() {
		try {
			hechoregistro.isDisplayed();
			
			return true;
		} catch (Exception e) {
			return false;
			
		}
	}
	
	
	
	
	//public void iniciaexppage() {
	//	Base b = new Base();
	//	WebDriver driver = b.getDriver();
		
	//	/** generamos la variable llenado y traemos lo de llenadoFormulario y controlador para firefox */
	//	llenadoFormulario llenado = PageFactory.initElements(driver, llenadoFormulario.class );
	//    String url = "http://demo.guru99.com/test/newtours/index.php";//home
	    
	//    /**el controlador para firefox y mandamos la variable con la url  */    
	//    driver.get(url);
	//    //driver.manage().window().maximize();
	    
	//    //Seleccionar el menu REGISTRO
	//    llenado.menu();
		
	//}
	
	
	public void iniciaexppage() 
	  {
		  System.setProperty("webdriver.gecko.driver" , "C://DriverExploradores//firefox 16//geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.get("http://demo.guru99.com/test/newtours/");
		  
	  }
	
	
	
	
	

}
