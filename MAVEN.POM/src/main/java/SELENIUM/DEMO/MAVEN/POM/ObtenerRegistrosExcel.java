package SELENIUM.DEMO.MAVEN.POM;

import java.awt.print.PrinterAbortException;

//import static org.testng.Assert.assertEquals;

//import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.SkipException;

//import org.openqa.selenium.By;
//import org.testng.SkipException;

//import org.apache.commons.logging.LogConfigurationException;
//import org.apache.http.MessageConstraintException;

//import org.apache.xalan.xsltc.cmdline.getopt.GetOptsException;
//import org.openqa.selenium.By;
//import org.testng.Assert;
//import org.openqa.selenium.NotFoundException;
//import org.testng.Assert;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import org.apache.log4j.Logger;


//import com.relevantcodes.extentreports.model.ExceptionInfo;

import Automation.SingIn;


public class ObtenerRegistrosExcel extends Base{
	
	SingIn signIn;
	//SingIn confirm;
	//static Logger log = Logger.getLogger(ObtenerRegistrosExcel.class.getName());
	
	@BeforeClass //(enabled = true, description = "Inicia explorador url seleccion del menú Registro")
	public void sepUP() throws IOException{
		iniciaexppage();
		
	}
	
	public Object [][] getDatos(String ExcelName, String testcase) {
		
		Reade_Excel3 Data = new Reade_Excel3(System.getProperty("user.dir") + "//src//main//java//SELENIUM//DEMO//MAVEN//POM//"+ExcelName);
		
		
		int rowNum = Data.getRowCount(testcase);
		
		
		
		int colNum = Data.getColumnCount(testcase);
		Object sampleData[][] = new Object[rowNum - 1][colNum];
		
		for (int i = 2; i <=rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				sampleData[i - 2][j] = Data.getCellData(testcase, j, i);
			}
		}
		return sampleData;
    }
	
	
	
	@DataProvider
	public Object[][] loginData(){
		Object[][] data = getDatos("Registros.xls", "DatosRegistro");
		return data;
    }

	
	
	
	
	@Test(dataProvider = "loginData")
	public void TestLoginWithDataProvider(String Nombre, String Apellido, String Telefono, String Email, String Direccion, String Ciudad, String Estado, String CodigoPostal, String Pais, String Usuario, String Password, String Confirmarpws, String runMode ) throws InterruptedException{
        //log.info("REGISTRO DE VUELO");
		
		if(runMode.equals("N")){
			throw new SkipException("ESTE TEST NO SE EJECUTA:  " + Nombre);
		}
		
		if(runMode.equals("Y")) {
		
			System.out.println("SE EJECUTO EXITOSAMENTE:  " + Nombre);
			
		}
		
		
		signIn = new SingIn(driver);
		signIn.allregistrer(Nombre, Apellido, Telefono, Email, Direccion, Ciudad, Estado, CodigoPostal, Pais, Usuario, Password, Confirmarpws );
		
		
		//boolean RegistroExitoso = driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font")).isDisplayed();
		//boolean pwsNoMach = driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/span")).isDisplayed();
		
		//assertEquals(pwsNoMach, RegistroExitoso, "NO CONCUERDA EL PWS");
		
		Thread.sleep(5000);
		
		//signIn.logout();
			
	}
	
}
