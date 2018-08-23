package SELENIUM.DEMO.MAVEN.POM;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Automation.llenadoFormulario;

public class RegresionTest3_Respaldo {
	
	
	

	@Test
	public void prueba1() {
	Base b = new Base();
	WebDriver driver = b.getDriver();
	
	/** generamos la variable llenado y traemos lo de llenadoFormulario y controlador para firefox */
	llenadoFormulario llenado = PageFactory.initElements(driver, llenadoFormulario.class );
    String url = "http://demo.guru99.com/test/newtours/index.php";//home
    
    /**el controlador para firefox y mandamos la variable con la url  */    
    driver.get(url);
    //driver.manage().window().maximize();
    llenado.menu();
    llenado.formFillUp("Pedro","Juarez","5566778877", "angel@gmail.com", "direccion", "ciudad", "provincia", "15810", "username", "angel@gmail.com", "12345","12345","");
    llenado.coutry();
    llenado.submit();
    //assertEquals(driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font")).getText(), "Thank you for registering. You may now sign-in using the user name and password you've just entered.");
                                      
    
	}
}
