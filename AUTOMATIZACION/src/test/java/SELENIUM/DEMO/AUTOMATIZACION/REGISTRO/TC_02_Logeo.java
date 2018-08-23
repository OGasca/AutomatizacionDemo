package SELENIUM.DEMO.AUTOMATIZACION.REGISTRO;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SELENIUM.DEMO.AUTOMATIZACION.TESTBASE.TestBase;
import SELENIUM.DEMO.AUTOMATIZACION.UIACTION.HomePage;

public class TC_02_Logeo extends TestBase{
	
	
	    
		public static final Logger log = Logger.getLogger(TC_02_Logeo.class.getName());
		
		HomePage homepage;
		
		@BeforeTest
		public void setUP() throws IOException{
			init();				
		}
		
		@Test
		public void validaElLogeo() throws InterruptedException {
			homepage = new HomePage(driver);	
			homepage.logeoUsuario("123", "123");
			
		}
		
		

}
