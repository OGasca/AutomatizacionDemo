package SELENIUM.DEMO.AUTOMATIZACION.UIACTION;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import SELENIUM.DEMO.AUTOMATIZACION.TESTBASE.TestBase;

public class HomePageCreaCuentaTienda extends TestBase{
	
    WebDriver driver;
    
    //variables para los menus
    public final String women = "Women";
    public final String dresses = "Dresses"; 
    public final String tshirts = "T-shirts";
    
	//variables para los submenus    
    public final String tops_blouses = "Blouses"; 
    public final String tops_shirts = "T-shirts";
    
   
    
                     
	@FindBy(xpath = ".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement homepageMenuRegistro;
	
	@FindBy(xpath = ".//*[@id='email_create']")
	WebElement homepageCreaEmail;
	
	@FindBy(xpath = ".//*[@id='SubmitCreate']")
	WebElement homepageBtoCreaEmail;
	
	
	@FindBy(xpath = ".//*[@id='id_gender1']")	
	WebElement informacionPersonalMr;
	
	@FindBy(xpath = ".//*[@id='id_gender2']")
	WebElement informacionPersonalMrs;
	
	@FindBy(xpath = ".//*[@id='customer_firstname']")
	WebElement informacionPersonalPrimerNombre;
	
	@FindBy(xpath = ".//*[@id='customer_lastname']")
	WebElement informacionPersonalSegundoNombre;
			
	@FindBy(xpath = ".//*[@id='passwd']")
	WebElement informacionPersonalPassword;
	
	@FindBy(id = "days")
	WebElement informacionPersonalDias;
	
	@FindBy(id = "months")
	WebElement informacionPersonalMeses;
	
	@FindBy(id = "years")
	WebElement informacionPersonalAños;
	
	@FindBy(xpath = ".//*[@id='firstname']")
	WebElement informacionPersonalNombre1;
	
	@FindBy(xpath = ".//*[@id='lastname']")
	WebElement informacionPersonalNombre2;
	
	@FindBy(xpath = ".//*[@id='address1']")
	WebElement informacionPersonalDireccion;
	
	@FindBy(xpath = ".//*[@id='city']")
	WebElement informacionPersonalCiudad;
	
	@FindBy(xpath = ".//*[@id='id_state']")
	WebElement informacionPersonalEstado;
	
	@FindBy(xpath = ".//*[@id='postcode']")
	WebElement informacionPersonalCP;
	
	@FindBy(xpath = ".//*[@id='id_country']")
	WebElement informacionPersonalCountry;
	
	@FindBy(xpath = ".//*[@id='phone_mobile']")
	WebElement informacionPersonalCel;
	
	@FindBy(xpath = ".//*[@id='alias']")
	WebElement informacionPersonalAlias;
	
	@FindBy(xpath = ".//*[@id='submitAccount']")
	WebElement infoPersonalbtoRegistrar;
	
	//Mensajes de error	
	@FindBy(xpath = ".//*[@id='SubmitCreate']")
	WebElement homepageErrorInvalidoEmail;

	//MSG Email registrado previamente.
	@FindBy(xpath = ".//*[@id='create_account_error']/ol/li")
	WebElement homepageprevioregistroemail;
	
	//Desconectar
	@FindBy(xpath = ".//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement homepageDesconectar;
	
	//localizar lista de menus
	@FindBy(xpath = ".//*[@id='block_top_menu']/ul/li/a")
	List<WebElement> menus;
	
	//bloc menu
	@FindBy(id="block_top_menu")
	WebElement blockmenu;
	
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}
	
	//se desloguea el usuario desconecta
	public void desconectar() {
		homepageDesconectar.click();
	}
	
	//titulo Mr
	public void tituloMr() {
		informacionPersonalMr.click();
	}
	
	//titulo Mrs
	public void tituloMrs() {
		informacionPersonalMrs.click();
	}
	
	//Se ingresa como String ya que se optiene el texto
	public String obtenerTexErrorAutenticacionFallida() {
		return homepageErrorInvalidoEmail.getText();
	}
	
	public String emailRegistradoPreviamente() {
		return homepageprevioregistroemail.getText();
	}
	
	
	
	//Se crea el constructor para poder utilizar todos los elementos en la test
	public HomePageCreaCuentaTienda(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void registrarse(String creaemail1) {
		homepageMenuRegistro.click();
		homepageCreaEmail.sendKeys(creaemail1);
		homepageBtoCreaEmail.click();		
	}
	
	public void crearCuenta (String primernomb, String segundonomb, String password, String dia, String mes, String año, String nomb1, String nomb2, String direccion, String ciudad, String estado, String cp, String contri, String cel, String alias) {
				
		
		//informacionPersonalMr.isEnabled();
		//informacionPersonalMrs.isSelected();
		informacionPersonalMr.click();
				
		
		informacionPersonalPrimerNombre.sendKeys(primernomb);
		informacionPersonalSegundoNombre.sendKeys(segundonomb);
		//informacionEmailPersonal.sendKeys(personalemail2);
		informacionPersonalPassword.sendKeys(password);
		
		//Se selecciona el dia
		Select selectdia = new Select(informacionPersonalDias);
		selectdia.selectByValue(dia);
		
		//Se selecciona el mes
		Select selectmes = new Select(informacionPersonalMeses);
		selectmes.selectByValue(mes);
		
		//Se selecciona el año
		Select selectaño = new Select(informacionPersonalAños);
		selectaño.selectByValue(año);
				
		informacionPersonalNombre1.sendKeys(nomb1);
		informacionPersonalNombre2.sendKeys(nomb2);
		informacionPersonalDireccion.sendKeys(direccion);
		informacionPersonalCiudad.sendKeys(ciudad);
		
		//Se selecciona el estado
		Select selectestado = new Select(informacionPersonalEstado);
		selectestado.selectByValue(estado);
					
		informacionPersonalCP.sendKeys(cp);
		
		Select selectcontri = new Select(informacionPersonalCountry);
		selectcontri.selectByValue(contri);
		
		informacionPersonalCel.sendKeys(cel);
		informacionPersonalAlias.sendKeys(alias);
		infoPersonalbtoRegistrar.click();
		
	}
	
	//metodo generico de objetos lista para los diferentes menus
	public void clicknavegarmenu(String menu) {
		//ponemos tiempo de espera hasta que el menu aparezca
		//waitForElement(driver, 80, driver.findElement(By.xpath(".//a[contains(text(),'"+menu+"')]")));
		driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li/a[@title='"+menu+"']")).click();
		                            
	}
	
	/*
	//metodo generico de objetos lista para los diferentes menus 
	//Seleccionar uno de los menus Women, Dresses, T-shirts
	public List<WebElement> clicknavegarmenu() {
		//Seleccion menus
		List<WebElement> element = menus;
		return element;
	}
	*/
		
	//Seleccion uno de los menus para mostrar los submenus. 
	public void mostrarsubmenu(String subnombremenu) {
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li/a[@title='"+subnombremenu+"']"))).perform();		
		
	}
	
	public void selecciondesubmenu(String selecsubmenu) {
		driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li/a[@title='"+selecsubmenu+"']")).click();
	}
	
	
	public void switchToBlock(){
		driver.switchTo().frame(blockmenu);
		
	}
	
	public void switchToDefaultContent(){
		
		driver.switchTo().defaultContent();
	}
	
	
}


