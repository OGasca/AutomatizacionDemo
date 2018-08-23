package SELENIUM.DEMO.AUTOMATIZACION.REGISTRO;

import java.io.IOException;
//import java.sql.Driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SELENIUM.DEMO.AUTOMATIZACION.TESTBASE.TestBase;
import SELENIUM.DEMO.AUTOMATIZACION.UIACTION.HomePageCreaCuentaTienda;

public class TC_03_TiendaVerifLoginInvalidDatos extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC_03_TiendaVerifLoginInvalidDatos.class.getName());
    
	HomePageCreaCuentaTienda homepagecreacuentatienda;
	
	@BeforeTest
	public void setUP() throws IOException{
		init();				
	}
	
	
	@Test(priority = 0, enabled = false, description = "Se valida los menus")
	public void test1() throws InterruptedException{
		homepagecreacuentatienda = new HomePageCreaCuentaTienda(driver);
		
		//Seleccionar uno de los menus Women, Dresses, T-shirts
		//homepagecreacuentatienda.switchToBlock();
		homepagecreacuentatienda.clicknavegarmenu(homepagecreacuentatienda.women);
		//homepagecreacuentatienda.switchToDefaultContent();
		capturaPantalla("test1");
		homepagecreacuentatienda.clicknavegarmenu(homepagecreacuentatienda.dresses);
		capturaPantalla("test1");
		homepagecreacuentatienda.clicknavegarmenu(homepagecreacuentatienda.tshirts);
		capturaPantalla("test1");
			
	}
	
	@Test(priority = 1, enabled = false, description = "Se valida los Sub-menus")
	public void test2() throws InterruptedException{
		homepagecreacuentatienda = new HomePageCreaCuentaTienda(driver);
		
		//Seleccionar uno de los menus (Women, Dresses,) para mostrar sus submenus 
		//homepagecreacuentatienda.switchToBlock();
		
		homepagecreacuentatienda.mostrarsubmenu(homepagecreacuentatienda.women);
		//ponemos tiempo de espera hasta que el menu aparezca
		waitForElement(driver, 80, driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[1]/ul")));
		//seleccionamos un submenu
		homepagecreacuentatienda.selecciondesubmenu(homepagecreacuentatienda.tops_blouses);
		capturaPantalla("test2");
		
		homepagecreacuentatienda.mostrarsubmenu(homepagecreacuentatienda.women);
		//ponemos tiempo de espera hasta que el menu aparezca
		waitForElement(driver, 80, driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[1]/ul")));
		//seleccionamos un submenu
		homepagecreacuentatienda.selecciondesubmenu(homepagecreacuentatienda.tops_shirts);
		capturaPantalla("test2");
			
	}
	
	
	
	@Test(priority = 2, enabled = true, description = "Generación de registro")
	public void test3()throws InterruptedException{
		
		log.info("Inicia ingreso de datos correctos");
		homepagecreacuentatienda = new HomePageCreaCuentaTienda(driver);
		homepagecreacuentatienda.registrarse("prueba10@gmail.com");
		
		//titulo Mr o Mrs
		homepagecreacuentatienda.tituloMr();
		
		capturaPantalla("test3");
		homepagecreacuentatienda.crearCuenta("primernombre", "segundonombree", "12345", "3", "3", "2018", "nombreuno", "nombredos", "direccioncalle", "ciudadedomex", "31", "15810", "21", "5533324441", "juanitoo");
		capturaPantalla("test3");
		
		
	}
	
	@Test(priority = 3, enabled = false, description = "Se valida MSG Email registrado anteriormente")
	public void test4() throws InterruptedException{
		
		homepagecreacuentatienda.desconectar();
		log.info("Ingresamos email registrado previamente");	
		capturaPantalla("test4");
		homepagecreacuentatienda.registrarse("prueba2@gmail.com");
		Assert.assertEquals(homepagecreacuentatienda.emailRegistradoPreviamente() , "An account using this email address has already been registered. Please enter a valid password or request a new one.");
		capturaPantalla("test4");
		
	}
	
	
	
	
	
	
	
}
