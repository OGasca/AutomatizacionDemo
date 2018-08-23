package Automation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
//import org.testng.SkipException;

import SELENIUM.DEMO.MAVEN.POM.Base;

/**
 * @author Othon
 *
 */
public class SingIn extends Base{
	
	public WebDriver driver;
	
	
	
	
	/**
     * Posición de cada elemento, su xpath
     */
	By menu = By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a");
    By fName = By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input");
    By lName = By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/input");
    By phone = By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/input");
    By email = By.xpath(".//*[@id='userName']");
    By address = By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input");
    By city = By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td[2]/input");
    By state = By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/input");
    By codpost = By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/input");
    By country = By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/select");
    By userName = By.xpath(".//*[@id='email']");
    By pws = By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td[2]/input");
    By confirPws = By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input");
    By submit = By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[17]/td/input");
    By singoff = By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a");
    By errorAlconfirmarpws = By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/span");
    By registroExitoso = By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font");
    /**;
     * Validaciones si se escribe correctamente la confirmación 
     * @param driver
     */
    
    
    
    
    public SingIn(WebDriver driver) {
		this.driver = driver;				
	}
    
    public void clickonSignIn() {
    	driver.findElement(menu).click();
    }
    
    /**
     * Generamos metodo para ingresar la variable en cada campo.
     */
    public void ingresarNombre(String nombres) {
    	driver.findElement(fName).sendKeys(nombres);
    }
    
    public void ingresarApellido(String apellidos) {
    	driver.findElement(lName).sendKeys(apellidos);
    }
    
    public void ingresarTel(String tels) {
    	driver.findElement(phone).sendKeys(tels);
    }
    
    public void ingresarEmail(String correos) {
    	driver.findElement(email).sendKeys(correos);
    }
    
    public void ingresarDireccion(String direcciones) {
    	driver.findElement(address).sendKeys(direcciones);
    }
    
    public void ingresarCiudad(String ciudades) {
    	driver.findElement(city).sendKeys(ciudades);
    }
    
    public void ingresarEstado(String estados) {
    	driver.findElement(state).sendKeys(estados);
    }
    
    public void ingresarCp(String codpostales) {
    	driver.findElement(codpost).sendKeys(codpostales);
    }
    
    public void ingresarPais(String paises) {
    	driver.findElement(country).sendKeys(paises);
    }
    
    public void ingresarUsuario(String usurarios) {
    	driver.findElement(userName).sendKeys(usurarios);
    }
    
    public void ingresarPws(String passwords) {
    	driver.findElement(pws).sendKeys(passwords);
    }
    
    public void ingresarConfirPws(String confirpasswords) {
    	driver.findElement(confirPws).sendKeys(confirpasswords);
    }
    
    public void botonsubmit() {
    	driver.findElement(submit).click();
    }
    
    public void singOff() {
    	driver.findElement(singoff).getText();
    }
    
    
    
    
    
    
    /**
     * Generamos solo un metodo con todos los campos del registro.
     */
    
    
    public void allregistrer(String Nombre, String Apellido, String Telefono, String Email, String Direccion, String Ciudad, String Estado, String CodigoPostal, String Pais, String Usuario, String Password, String Confirmarpws ){
    	
    	//driver.findElement(menu).click();
    	clickonSignIn();
    	
    	ingresarNombre(Nombre);
    	ingresarApellido(Apellido);
    	ingresarTel(Telefono);
    	ingresarEmail(Email);
    	ingresarDireccion(Direccion);
    	ingresarCiudad(Ciudad);
    	ingresarEstado(Estado);
    	ingresarCp(CodigoPostal);
    	ingresarPais(Pais);
    	ingresarUsuario(Usuario);
    	ingresarPws(Password);
    	ingresarConfirPws(Confirmarpws);
    	
    	botonsubmit();
    	    	
    	
    	
    	
    	
    }
    
    
    public boolean verificarMsgerrorconfirmacion() {
    	String msg = driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/span")).getText();
    if (msg.contains("PAssword and con.password does not match")) {
    	return true;
    }
    else {
    	return false;
    }
    
    
    
    }
    
    
    public void logout() {
    	try {
    		boolean isdisplayed = driver.findElement(singoff).isDisplayed();
    		if(isdisplayed) {
    			driver.findElement(singoff).click();
    		}
    	}
    	catch (Exception e) {
    		Assert.assertTrue(false, "El boton Sing Off no es mostrado");
    	}
    	
    }
    
    
    
    
    

}
