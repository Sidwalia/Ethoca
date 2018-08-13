package AutomationFramework;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.support.FindBy;
 
import org.openqa.selenium.support.How;
public class ShippingAndBillingDetailsPageObjects {

	WebDriver driver;
	 
	@FindBy(how = How.ID, using = "wpsc_checkout_form_9")
 
	public WebElement Email ;
	
	@FindBy(how = How.ID, using = "wpsc_checkout_form_2")
	 
	public WebElement BillingFirstName ;
	
	@FindBy(how = How.ID, using = "wpsc_checkout_form_3")
	 
	public WebElement BillingLastName ;
	
	@FindBy(how = How.ID, using = "wpsc_checkout_form_4")
	 
	public WebElement BillingAddress ;
	
	@FindBy(how = How.ID, using = "wpsc_checkout_form_5")
	 
	public WebElement BillingCity ;
	
	@FindBy(how = How.ID, using = "wpsc_checkout_form_6")
	 
	public WebElement BillingProvince ;
	
	@FindBy(how = How.ID, using = "uniform-wpsc_checkout_form_7_region")
	 
	public WebElement BillingProvinceDropdown ;
	
	
	@FindBy(how = How.ID, using = "wpsc_checkout_form_7")
	 
	public WebElement BillingCountry ;
	
	@FindBy(how = How.ID, using = "wpsc_checkout_form_8")
	 
	public WebElement BillingPostalCode ;
	
	@FindBy(how = How.ID, using = "wpsc_checkout_form_18")
	 
	public WebElement BillingPhoneNumber ;
	
	@FindBy(how = How.ID, using = "shippingSameBilling")
	 
	public WebElement SameAsBillingAddressCheckbox ;
	
	
	@FindBy(how = How.ID, using = "wpsc_checkout_form_11")
	 
	public WebElement ShippingFirstName ;
	
	@FindBy(how = How.ID, using = "wpsc_checkout_form_12")
	 
	public WebElement ShippingLastName ;
	
	@FindBy(how = How.ID, using = "wpsc_checkout_form_13")
	 
	public WebElement ShippingAddress ;
	
	@FindBy(how = How.ID, using = "wpsc_checkout_form_14")
	 
	public WebElement ShippingCity ;
	
	@FindBy(how = How.ID, using = "wpsc_checkout_form_15")
	 
	public WebElement ShippingProvince ;
	
	@FindBy(how = How.ID, using = "wpsc_checkout_form_16")
	 
	public WebElement ShippingCountry ;
	
	@FindBy(how = How.ID, using = "wpsc_checkout_form_17")
	 
	public WebElement ShippingPostalCode ;
	
	@FindBy(how = How.CLASS_NAME, using = "input-button-buy")
	 
	public WebElement ShippingAndBillingContinueButton ;
	
	
	
}
