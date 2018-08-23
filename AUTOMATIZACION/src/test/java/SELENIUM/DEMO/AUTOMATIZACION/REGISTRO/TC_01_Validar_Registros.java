package SELENIUM.DEMO.AUTOMATIZACION.REGISTRO;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SELENIUM.DEMO.AUTOMATIZACION.TESTBASE.TestBase;
import SELENIUM.DEMO.AUTOMATIZACION.UIACTION.HomePage;

public class TC_01_Validar_Registros extends TestBase{
	//este Log es para poner descripcion en el log 
	public static final Logger log = Logger.getLogger(TC_01_Validar_Registros.class.getName());
	
	HomePage homepage;
	
	@BeforeTest
	public void setUP() throws IOException{
		init();				
	}
	
	
	@Test(priority = 0, enabled = true, description = "Registro datos correctos")
	public void verificarRegistroDatosCorrectos() throws InterruptedException {
		//ponemos descripcion en el log para identificar donde inicia la ejecucion de nuestro codigo y donde termina
		log.info("Inicia verificacion de datos correctos");
		
		homepage = new HomePage(driver);		
		homepage.registroUsuario("pedro", "lopez", "55557654", "lopez@email.com", "sur 83", "mexico", "Distrito fede", "15810", "plopez", "123", "123");		
		Assert.assertEquals(homepage.obtenertexregistoexitoso(), "Thank you for registering. You may now sign-in using the user name and password you've just entered.");
		capturaPantalla("verificarRegistroDatosCorrectos");
		//ponemos descripcion en el log para identificar donde inicia la ejecucion de nuestro codigo y donde termina
		log.info("Finaliza verificacion de datos correctos");
	}
	
	
	@Test(priority = 1, enabled = true, description = "Registro error en confirmacion pws")
	public void vefificarRegistroConfirmaPassword() throws InterruptedException {
		//ponemos descripcion en el log para identificar donde inicia la ejecuion de nuestro codigo y donde termina
		log.info("Inicia verificacion de confirmacion pws");	
		
		homepage.registroUsuario("pedro2", "lopez2", "55557654", "lopez2@email.com", "sur 83", "mexico", "Distrito fede", "15810", "plopez", "123", "124");				
		Assert.assertEquals(homepage.obtenerTexErrorConfirmaPassw(), "PAssword and con.password does not match");
		capturaPantalla("vefificarRegistroConfirmaPassword");
		
		//ponemos descripcion en el log para identificar donde inicia la ejecuion de nuestro codigo y donde termina
		log.info("Finaliza verificacion de confirmacion pws");
	}
	
	
	@Test(priority = 2, enabled = true, description = "Registro user, pws")
	public void logueo() throws InterruptedException {
		//ponemos descripcion en el log para identificar donde inicia la ejecuion de nuestro codigo y donde termina
		log.info("Inicia log");	
		
		//homepage.logeoUsuario("123", "123");				
				
		//ponemos descripcion en el log para identificar donde inicia la ejecuion de nuestro codigo y donde termina
		log.info("Finaliza log");
	}
	
	

}
