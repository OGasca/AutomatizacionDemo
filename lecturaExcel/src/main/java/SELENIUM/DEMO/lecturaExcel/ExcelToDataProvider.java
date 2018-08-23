package SELENIUM.DEMO.lecturaExcel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class ExcelToDataProvider {
	   
	  Reade_Excel3 eat = null;
	  
	  String path = "C://Users//Xia//eclipse-workspace//lecturaExcel//src//test//java//SELENIUM//DEMO//lecturaExcel//Registros.xls";
	  String sheetName = "DatosRegistro";
	  WebDriver driver = null;
	  
	  @BeforeClass
	  public void init() 
	  {
		  System.setProperty("webdriver.gecko.driver" , "C://DriverExploradores//firefox 16//geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.get("http://demo.guru99.com/test/newtours/");
	  }
	  
	  
	  
	@Test(dataProvider = "userData")
	public void fillUserForm(String Nombre, String Apellido, String Telefono, String Email, String Direccion, String Ciudad, String Estado, String CodPostal, String Pais, String Usuario, String Password, String Confirmarpws, String runMode ) throws InterruptedException
	{
		
		if(runMode.equals("N")){
			throw new SkipException("ESTE TEST NO SE EJECUTA");
		}
		
		driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")).click();
		driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input")).sendKeys(Nombre);
		driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/input")).sendKeys(Apellido);
		driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/input")).sendKeys(Telefono);
		driver.findElement(By.xpath(".//*[@id='userName']")).sendKeys(Email);
		driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input")).sendKeys(Direccion);		                  
		driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td[2]/input")).sendKeys(Ciudad);
		driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/input")).sendKeys(Estado);
		driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/input")).sendKeys(CodPostal);				
		driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/select")).sendKeys(Pais);		
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(Usuario);			                              
		driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td[2]/input")).sendKeys(Password);
		driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input")).sendKeys(Confirmarpws);		
		//driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")).click();			
		                             
	
	
		boolean activo = driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[17]/td/input")).isEnabled();
		
		boolean mostrado = driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[17]/td/input")).isDisplayed();
		
		if(activo) {
			System.out.println("Esta activo");
		}else {
			System.out.println("No esta activo");
		}
		
		if(mostrado) {
			System.out.println("Esta mostrado");
		}else {
			System.out.println("No esta mostrado");
		}
	
	
	
	
	
	}
	
	@DataProvider(name = "userData")
	public Object[][] userFormData() throws Exception 
	{
	   Object[][] data = testData(path, sheetName);
	   return data;
	}
	
	
	
	public Object[][] testData(String path, String sheetName)throws Exception
	{
		Object [][] excelData = null; 
		
		eat = new Reade_Excel3(path);
		int rows = eat.getRowCount(sheetName);
		int colums = eat.getColumnCount(sheetName);
		
		
		excelData = new Object[rows -1 ][colums];
		
		//El 2 indica que inicia desde la segunda fila para ejecutar
		for (int i = 2; i <= rows; i++)
		{
			
			for (int j= 0; j<colums; j++)
			{
				excelData [i-2][j] = eat.getCellData(sheetName, j, i);
			}
		}
		
		return excelData;
	}
	
		
	
	
	
	

}