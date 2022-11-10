
package obsqura.NewAutomationCourse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class GroceryStoreBase {
	public WebDriver driver;

	public void initializeBrowser() {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\Akhila\\obsquraJava\\NewAutomationCourse\\src\\main\\java\\Resources\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("http://www.opesmount.in/grocerystore1/");
	}
	
	public void browserQuit() {
		driver.quit();
	}
	

}
/*Launch the browser and up the url
(http://www.opesmount.in/grocerystore1/)
 Get the title of the page 
Verify the title and url of the application
 Close the browser*/

/*Then navigate to the url 
(https://www.toolsqa.com/automation-practice-form/) 
 Then navigate back to grocerystore 
Then navigate to automation 
practice form Then refresh the page*/