package obsqura.NewAutomationCourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base 
	{
	public WebDriver driver;
	public void InitializeBrowser(){
		System.setProperty("webdriver.edge.driver","C:\\Users\\Akhila\\obsquraJava\\NewAutomationCourse\\src\\main\\java\\Resources\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get("https://www.amazon.in");
	}
	
	public static void main(String args[]){
		Base obj=new Base();
		obj.InitializeBrowser();
		
	}

	}
