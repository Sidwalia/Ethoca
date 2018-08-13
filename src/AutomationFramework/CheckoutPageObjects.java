package AutomationFramework;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.support.FindBy;
 
import org.openqa.selenium.support.How;
public class CheckoutPageObjects {
	
	WebDriver driver;
	 
	@FindBy(how = How.NAME, using = "quantity")
 
	public WebElement QuantityField ;	
	
	@FindBy(how = How.CLASS_NAME, using = "step2")
	 
	public WebElement ContinueButton;	
	
	@FindBy(how = How.CSS, using = "value='Update'")
	 
	public WebElement UpdateButton;	
	
	
	


}
