package AutomationFramework;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import AutomationFramework.HomePageObjects;
import AutomationFramework.ProductCategoryPageObjects;
import AutomationFramework.ProductDetailsPageObjects;
import AutomationFramework.CheckoutPageObjects;
import AutomationFramework.ShippingAndBillingDetailsPageObjects;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class TestCases extends Util {
	
	
	  @BeforeTest
	  public void beforeTest() throws InterruptedException 
	  {
		//Open Browsers
			OpenBrowser();	
			Thread.sleep(8000);
			//App URL
			String URL = "http://store.demoqa.com/";
			// Open App URL
			Navigate(URL);
			Thread.sleep(5000);	
			// Verify if the user navigated to the correct URL
			String actualUrl = driver.getCurrentUrl(); 		
			 if (actualUrl.equals(URL))
			 {
				System.out.println("You are on the correct URL");
			 }
			 else
			{
				System.out.println("Incorrect URL opened");
			}
			 Thread.sleep(5000);
	  }
	  
	  @Test(priority=1)
	  public void TestOnlyOneMagicMouseIsAdded() throws InterruptedException
	  {	  
			  HomePageObjects Home = PageFactory.initElements(driver, HomePageObjects.class);
				ProductCategoryPageObjects ProductCategory = PageFactory.initElements(driver, ProductCategoryPageObjects.class);
				ProductDetailsPageObjects ProductDetails = PageFactory.initElements(driver, ProductDetailsPageObjects.class);
				CheckoutPageObjects Checkout = PageFactory.initElements(driver, CheckoutPageObjects.class);
				//ShippingAndBillingDetailsPageObjects ShippingAndBilling = PageFactory.initElements(driver, ShippingAndBillingDetailsPageObjects.class);
				
				WaitFor(Home.ProductCategory);
			  // Click Product Category
				Home.ProductCategory.click();
				
				WaitFor(ProductCategory.MagicMouseButton);
			    // Click Magic Mouse
				 ProductCategory.MagicMouseButton.click();
		
				 Thread.sleep(3000);
			// Click Add to Cart Button		 
				ProductDetails.AddToCartButton.click();
				 Thread.sleep(4000);
				 ProductDetails.AddToCartButton.click();
				 Thread.sleep(4000);
						 
		     	// Click the Cart Icon
				Home.CartIcon.click();
				WaitFor(ProductCategory.MagicMouseButton);
						 
			// Verifying if the Magic Mouse Button is Added
			 if(ProductCategory.MagicMouseButton != null )
			 {
			System.out.println("Magic Mouse has been added to the cart");
			 }
			 else
			 {
			 System.out.println("Magic Mouse has not been added");
			 }		 
			 Thread.sleep(2000);
			// Verifying if only 1 Magic Mouse is added
			String Quantity = Checkout.QuantityField.getAttribute("value");
			AssertJUnit.assertNotSame(Quantity,"1");
			System.out.println("More than 1 Magic Mouse have been added to the cart"); 				     		 		  
		  
	  }
	  
	  
		  	  
	  
	  @Test(priority=0)
  public void TestFullTransactionProcess() throws InterruptedException {	
		
		  HomePageObjects Home = PageFactory.initElements(driver, HomePageObjects.class);
			ProductCategoryPageObjects ProductCategory = PageFactory.initElements(driver, ProductCategoryPageObjects.class);
			ProductDetailsPageObjects ProductDetails = PageFactory.initElements(driver, ProductDetailsPageObjects.class);
			CheckoutPageObjects Checkout = PageFactory.initElements(driver, CheckoutPageObjects.class);
			ShippingAndBillingDetailsPageObjects ShippingAndBilling = PageFactory.initElements(driver, ShippingAndBillingDetailsPageObjects.class);
		
	     	WaitFor(Home.ProductCategory);
		    // Click Product Category
			Home.ProductCategory.click();
		
            WaitFor(ProductCategory.MagicMouseButton);
		    // Click Magic Mouse
		    ProductCategory.MagicMouseButton.click();
			 
			 WaitFor(ProductDetails.AddToCartButton);
		     // Click Add to Cart Button		 
			 ProductDetails.AddToCartButton.click();
			 
	    	 WaitFor(Home.CartIcon);
		    // Click the Cart Icon
		   	Home.CartIcon.click();
			
	    	 WaitFor(ProductCategory.MagicMouseButton);
	     	// Verifying if the Magic Mouse Button is Added
		    if(ProductCategory.MagicMouseButton != null )
				 {
					System.out.println("Magic Mouse has been added to the cart");
				 }
					 else
					 {
						 System.out.println("Magic Mouse has not been added");
					 }		 
			 Thread.sleep(2000);
		   // Verifying if only 1 Magic Mouse is added
			String Quantity = Checkout.QuantityField.getAttribute("value");
			AssertJUnit.assertEquals(Quantity,"1");
			System.out.println("Just 1 Magic Mouse has been added to the cart"); 
			     
			     Thread.sleep(3000);
	         // Click Continue
			 Checkout.ContinueButton.click();
	         Thread.sleep(3000);
			     
	         ShippingAndBilling.Email.sendKeys("sid@test.com");
		     ShippingAndBilling.BillingFirstName.sendKeys("Sid");
		     ShippingAndBilling.BillingLastName.sendKeys("Walia");
		     ShippingAndBilling.BillingAddress.sendKeys("1 Kingsbury Avenue");
		     ShippingAndBilling.BillingCity.sendKeys("Toronto");
		     ShippingAndBilling.BillingProvince.sendKeys("ON");
		     
		     Select dropdown = new Select(ShippingAndBilling.BillingCountry);
		     dropdown.selectByValue("CA");

		     
		     ShippingAndBilling.BillingPostalCode.sendKeys("L8A4F7");
		     ShippingAndBilling.BillingPhoneNumber.sendKeys("6477008080");
	
			     Thread.sleep(3000);
			//    ShippingAndBilling.SameAsBillingAddressCheckbox.click();
			     

			     ShippingAndBilling.ShippingFirstName.sendKeys("Sid");
			     ShippingAndBilling.ShippingLastName.sendKeys("Walia");
			     ShippingAndBilling.ShippingAddress.sendKeys("1 Kingsbury Avenue");
			     ShippingAndBilling.ShippingCity.sendKeys("Toronto");
			     ShippingAndBilling.ShippingProvince.sendKeys("ON");
			     
			     Select dropdown1 = new Select(ShippingAndBilling.ShippingCountry);
			     dropdown1.selectByValue("CA");
	
			     
			     ShippingAndBilling.ShippingPostalCode.sendKeys("L8A4F7");
			  
			     Thread.sleep(2000);
			     
			     ShippingAndBilling.ShippingAndBillingContinueButton.click();
			     Thread.sleep(5000);
			     
			     boolean FinalPage = driver.getPageSource().contains("Thank you for purchasing with ONLINE STORE, any items to be shipped will be processed as soon as possible, any items that can be downloaded can be downloaded using the links on this page. All prices include tax and postage and packaging where applicable.");
			     if (FinalPage == true)
			     {
			      System.out.print("You are now on the Final Page");
			     }
			     else
			     {
			      System.out.print("You are not on the Final Page");
			     }
			  	  
  }
  
	  
	  @Test(priority=2)
	  public void TestTransactionWithSameBillingAndShippingAddress() throws InterruptedException
	  {
		  Thread.sleep(5000);
		  HomePageObjects Home = PageFactory.initElements(driver, HomePageObjects.class);
			ProductCategoryPageObjects ProductCategory = PageFactory.initElements(driver, ProductCategoryPageObjects.class);
			ProductDetailsPageObjects ProductDetails = PageFactory.initElements(driver, ProductDetailsPageObjects.class);
			CheckoutPageObjects Checkout = PageFactory.initElements(driver, CheckoutPageObjects.class);
			ShippingAndBillingDetailsPageObjects ShippingAndBilling = PageFactory.initElements(driver, ShippingAndBillingDetailsPageObjects.class);
			
		  // Click Product Category
			Home.ProductCategory.click();
			Thread.sleep(4000);
		// Click Magic Mouse
			 ProductCategory.MagicMouseButton.click();
	
			 Thread.sleep(3000);
		// Click Add to Cart Button		 
			ProductDetails.AddToCartButton.click();
			 Thread.sleep(4000);
					 
		// Click the Cart Icon
			Home.CartIcon.click();
			Thread.sleep(4000);
					 
		// Verifying if the Magic Mouse Button is Added
					 if(ProductCategory.MagicMouseButton != null )
				 {
					System.out.println("Magic Mouse has been added to the cart");
						 }
					 else
					 {
						 System.out.println("Magic Mouse has not been added");
						 }		 
			 Thread.sleep(2000);
		// Verifying if only 1 Magic Mouse is added
			String Quantity = Checkout.QuantityField.getAttribute("value");
			AssertJUnit.assertEquals(Quantity,"1");
			System.out.println("Just 1 Magic Mouse has been added to the cart"); 
			     
			     Thread.sleep(3000);
	   // Click Continue
			 Checkout.ContinueButton.click();
	         Thread.sleep(5000);
			     
	         ShippingAndBilling.Email.sendKeys("sid@test.com");
		     ShippingAndBilling.BillingFirstName.sendKeys("Sid");
		     ShippingAndBilling.BillingLastName.sendKeys("Walia");
		     ShippingAndBilling.BillingAddress.sendKeys("1 Kingsbury Avenue");
		     ShippingAndBilling.BillingCity.sendKeys("Toronto");
		
	
			 JavascriptExecutor js = (JavascriptExecutor) driver;
		     js.executeScript("arguments[0].scrollIntoView();",ShippingAndBilling.BillingProvince);
		  new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(ShippingAndBilling.BillingProvince)).isDisplayed();
		
		     ShippingAndBilling.BillingProvince.sendKeys("ON");
	 
	 new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(ShippingAndBilling.BillingProvinceDropdown)).isDisplayed();
     js.executeScript("arguments[0].scrollIntoView();",ShippingAndBilling.BillingProvinceDropdown);

		     Select dropdownProvince = new Select(ShippingAndBilling.BillingProvinceDropdown);
		     dropdownProvince.selectByValue("Ontario");

	 		     
		     Select dropdown = new Select(ShippingAndBilling.BillingCountry);
		     dropdown.selectByValue("CA");

		     
		     ShippingAndBilling.BillingPostalCode.sendKeys("L8A4F7");
		     ShippingAndBilling.BillingPhoneNumber.sendKeys("6477008080");
	
			     Thread.sleep(3000);
		    ShippingAndBilling.SameAsBillingAddressCheckbox.click();
			     

			     Thread.sleep(2000);
			     
			     ShippingAndBilling.ShippingAndBillingContinueButton.click();
			     Thread.sleep(5000);
			     
			     boolean FinalPage = driver.getPageSource().contains("Thank you for purchasing with ONLINE STORE, any items to be shipped will be processed as soon as possible, any items that can be downloaded can be downloaded using the links on this page. All prices include tax and postage and packaging where applicable.");
			     if (FinalPage == true)
			     {
			      System.out.print("You are now on the Final Page");
			     }
			     else
			     {
			      System.out.print("You are not on the Final Page");
			     }
			    
	  }
	  
	  @Test(enabled=false) 
	  public void TestHomeButtonFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
	  }
	  
	  @Test
	  public void TestProductCategoryButtonFunctionality()
	  {
		  
		  System.out.println("This is a sample Test Case");
	  }
	  
	  
	  @Test
	  public void TestAllProductButtonFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }
	  
	  
	  @Test
	  public void TestMyAccountButtonFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }
	  
	  
	  @Test
	  public void TestSearchTextboxButtonFunctionality()
	  {
		  
		  System.out.println("This is a sample Test Case");
	  }
	  
	  
	  @Test
	  public void TestFacebookLikeButtonFunctionality()
	  {
		  
		  System.out.println("This is a sample Test Case");
	  }
	  
	  
	  @Test
	  public void TestLoginFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }
	  
	  @Test
	  public void TestRegisterFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }

	  
	  @Test
	  public void TestProdcutCategoryAccessoriesFunctionality()
	  {
		  
		  System.out.println("This is a sample Test Case"); 
	  }
	  
	  
	  @Test
	  public void TestProdcutCategoryiMacFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }
	  
	  
	  @Test
	  public void TestProdcutCategoryiPadFunctionality()
	  {
		  
		  System.out.println("This is a sample Test Case");
	  }
	  

	  @Test
	  public void TestProdcutCategoryiPodFunctionality()
	  {
		  System.out.println("This is a sample Test Case"); 
		  
	  }
	  

	  @Test
	  public void TestProdcutCategoryiPhonesFunctionality()
	  {
		  System.out.println("This is a sample Test Case"); 
		  
	  }
	  

	  @Test
	  public void TestProdcutCategoryMacbooksFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }
	  
	  @Test
	  public void TestNavigateToPreviousScreenFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }
	  
	  @Test
	  public void TestProductCategoryGridViewFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }
	  
	  @Test
	  public void TestProductCategoryListViewFunctionality()
	  {
		  System.out.println("This is a sample Test Case"); 
		  
	  }
	  
	  @Test
	  public void TestAllProductsGridViewFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }
	  
	  @Test
	  public void TestAllProductsListViewFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }
	  
	  @Test
	  public void TestRatingStarsFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }
	  
	  
	  @Test
	  public void TestUpdateRatingStarsFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }
	  
	  @Test
	  public void TestCheckOutRemoveProductFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }
	  
	  @Test
	  public void TestProductMoreDetailsButtonFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }
	  
	  @Test
	  public void TestFooterPintrestButtonFunctionality()
	  {
		  System.out.println("This is a sample Test Case"); 
		  
	  }
	  
	  @Test
	  public void TestFooterGoogleButtonFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }
	  
	  @Test
	  public void TestFooterFeedsButtonFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }
	  
	  @Test
	  public void TestHomeBuyNowButtonFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }
	  
	  @Test
	  public void TestCheckoutRemoveFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }
	  
	  @Test
	  public void TestShippingPriceCalculateFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }
	  
	  @Test
	  public void TestGoBackButtonFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }
	  
	  @Test
	  public void TestFooterSPpageFunctionality()
	  {
		  System.out.println("This is a sample Test Case");
		  
	  }
	  
	  @Test
	  public void TestFooterSamplePageFunctionality()
	  {
		  
		  System.out.println("This is a sample Test Case"); 
	  }
	  
	  @Test
	  public void TestFooterYourAccountFunctionality()
	  {
		  
		  System.out.println("This is a sample Test Case"); 
	  }
  @AfterTest
  public void afterTest() {

	  // Close the driver
 
      driver.quit();
  }

}
