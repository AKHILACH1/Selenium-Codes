package obsqura.NewAutomationCourse;
import org.junit.Assert;



public class GroceryStoreCommands extends GroceryStoreBase{
	
	public void groceryCommands() {
		String expectedTitle = "Grocerystore";
		String title = driver.getTitle();
		Assert.assertEquals(expectedTitle, title);
	}
	public void navigation() {
		driver.navigate().to("https://www.toolsqa.com/automation-practice-form/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
	}

	public static void main(String[] args) {
		
		 GroceryStoreCommands obj = new  GroceryStoreCommands();
		obj.initializeBrowser();
		obj.groceryCommands();
		obj.navigation();
		obj.browserQuit();

	}

}

/*Then navigate to the url 
(https://www.toolsqa.com/automation-practice-form/) 
 Then navigate back to grocerystore 
Then navigate to automation 
practice form Then refresh the page*/