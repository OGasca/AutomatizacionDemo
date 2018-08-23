package SELENIUM.DEMO.AUTOMATIZACION.UIACTION;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.log4testng.Logger;

import SELENIUM.DEMO.AUTOMATIZACION.TESTBASE.TestBase;

public class HomePage extends TestBase{
	
	//public static final Logger log = Logger.getLogger(HomePage.class.getName());
	
	WebDriver driver;
		
	
	@FindBy(xpath = "html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input")
	WebElement loginUserName;
	
	@FindBy(xpath = "html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input")
	WebElement loginPassword;
	
	@FindBy(xpath = "html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[4]/td[2]/div/input")
	WebElement loginbtnSingIn;
	
	@FindBy(xpath = "html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]/font/a")
	WebElement home;
	
	@FindBy(xpath="html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")
    WebElement menuRegistro;
	
	@FindBy(xpath="html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input")
    WebElement registroNombre;
	
	@FindBy(xpath="html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/input")
    WebElement registroApellidoPaterno;
	
	@FindBy(xpath="html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/input")
    WebElement registroNumeroTelefono;
	
	@FindBy(xpath=".//*[@id='userName']")
    WebElement registroEmail;
	
	@FindBy(xpath="html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input")
    WebElement registroDireccion;
	
	@FindBy(xpath="html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td[2]/input")
    WebElement registroCiudad;
	
	@FindBy(xpath="html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/input")
    WebElement registroEstado;
	
	@FindBy(xpath="html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/input")
    WebElement registroCodigoPostal;
	
	//@FindBy(xpath="html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/select/option[154]")
	//@FindBy(xpath="html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/select")
    //WebElement loginPais;
	By loginPais = By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/select");
	
	
	@FindBy(xpath=".//*[@id='email']" )
	WebElement RegistroUserName;
	
	@FindBy(xpath="html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td[2]/input" )
	WebElement registroPassword;
	
	@FindBy(xpath="html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input" )
	WebElement registroConfirmaPassword;
	
	@FindBy(xpath="html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[17]/td/input" )
	WebElement registroBotonRegistrar;
	
	@FindBy(xpath="html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/span")
	WebElement registroErrorAlconfirmarpws;
	
	@FindBy(xpath="html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font")
	WebElement registroExitoso;
	
	//Se crea el constructor para poder utilizar todos los elementos en la test
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void registroUsuario(String nombre, String apellidoPaterno, String numeroTelefono, String email, String direccion, String ciudad, String estado, String codigoPostal,  String userName, String password, String confirmaPassword ) throws InterruptedException {
		log.info("Damos click en el menu Registro: " + menuRegistro.toString() );
		menuRegistro.click();
		
		log.info("Seleccionamos el campo nombre: " + registroNombre.toString() );
		registroNombre.sendKeys(nombre);
		
		log.info("Seleccionamos el campo nombre: " + registroApellidoPaterno.toString() );
		registroApellidoPaterno.sendKeys(apellidoPaterno);
		
		registroNumeroTelefono.sendKeys(numeroTelefono);
		registroEmail.sendKeys(email);
		registroDireccion.sendKeys(direccion);
		registroCiudad.sendKeys(ciudad);
		registroEstado.sendKeys(estado);
		registroCodigoPostal.sendKeys(codigoPostal);
    	//seleccionPais(pais);
		RegistroUserName.sendKeys(userName);
		registroPassword.sendKeys(password);
		registroConfirmaPassword.sendKeys(confirmaPassword);
		registroBotonRegistrar.click();
			
		
	}
	
	//Se genera el constructor para seleccion de la lista pais
	public void seleccionPais(String pais) throws InterruptedException{
		driver.findElement(loginPais).click();
		List<WebElement> paisDato = driver.findElements(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/select/option"));
		for(WebElement city : paisDato) {
			if (city.getText().trim().toLowerCase().equals(pais.toLowerCase())) {
				city.click();
			}
		}
		
	}
	
	
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}
	
	
	//Se ingresa como String ya que se optiene el texto
	public String obtenertexregistoexitoso () {
		return registroExitoso.getText();
		
	}
	
	//Se ingresa como String ya que se optiene el texto
	public String obtenerTexErrorConfirmaPassw() {
		return registroErrorAlconfirmarpws.getText();
	}
	
	public void logeoUsuario(String userN, String pwsD)throws InterruptedException {
		home.click();
		loginUserName.sendKeys(userN);
		loginPassword.sendKeys(pwsD);	
		
		//menuRegistro.click();
		//home.click();
		
		loginbtnSingIn.click();
	}
	
	
	

	
    	
}
