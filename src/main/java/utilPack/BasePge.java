package utilPack;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import com.sun.tools.javac.util.List;
import org.openqa.selenium.*;
import jdk.internal.vm.annotation.Hidden;

public class BasePge {
	protected WebDriver driver;
	WebElement webElement;
	List<WebElement> webElements;
	Assert asrt;
	JavascriptExecutor js;
	Select select;
	String data;
	int exitVal;
	public BasePge(WebDriver driver) {
		this.driver=driver;	
	}


	/// <summary>
	/// To click an element with given timeout         
	/// </summary>

	public void buttonClick(By locator) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		webElement =driver.findElement(locator);
		highLighterMethod(driver, webElement); 
		webElement.click();
	}

	/// <summary>
	/// To enter value to an element with given timeout
	/// </summary>
	public void setData(By locator, String text) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement =driver.findElement(locator);
		highLighterMethod(driver, webElement); 
		webElement.clear();
		webElement.sendKeys(text);

	}
	/// <summary>
	/// To get innertext
	/// </summary>
	public String GetText(By locator) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement =driver.findElement(locator);
		data = webElement.getText(); 
		return data;
	}
	
	/// <summary>
	/// To Switch Window Frame	        
	/// </summary>
	public void switchToFrame(By locator) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		webElement =driver.findElement(locator);
		driver.switchTo().frame(webElement);

	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}



	/// <summary>
	/// Validate Text	        
	/// </summary>

	public void validateText(By locator,String expectedText) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = driver.findElement(locator);
		String actualText = webElement.getText();
		asrt.assertEquals(actualText, expectedText);


	}

	/// <summary>
	/// Validate Text (Return by boolean)	        
	/// </summary>
	public boolean validateText(By locator) {
		WebDriverWait wait = getWait();	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = driver.findElement(locator);
		boolean status = webElement.isDisplayed();
		asrt.assertTrue(status);
		return status;		
	}

	/// <summary>
	/// Fluent wait
	/// </summary>
	public WebDriverWait getWait() {   //explicit wait

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.pollingEvery(250,TimeUnit.MILLISECONDS);                //WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.ignoring(NoSuchElementException.class);                 // wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return wait;

	}

	/// <summary>
	/// Fluent wait	        
	/// </summary>
	public void excuteJsClick(By locator) {

		js = (JavascriptExecutor)driver;
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		webElement =driver.findElement(locator);
		highLighterMethod(driver, webElement); 
		js.executeScript("arguments[0].click();", webElement);
	}

	/// <summary>
	/// Select values in the dropdown
	/// </summary>

	public void selectorByVisibleText(By locator,String text) {     //drpdown
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = driver.findElement(locator);
		highLighterMethod(driver, webElement); 
		select = new Select(webElement);
		select.selectByVisibleText(text);

	}

	/// <summary>
	/// autoSuggestiveDropDown
	/// </summary>
	public void autoSuggestiveDropDown(By locator,String text) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		ArrayList<WebElement> elementList = new ArrayList<WebElement>(driver.findElements(locator)) ;
		for(int i=0;i<elementList.size();i++) {

			if(elementList.get(i).getText().equalsIgnoreCase(text)) {
				elementList.get(i).click();
				break;
			}
		}

	}
	/// <summary>
	/// fillFormFields
	/// </summary>
	public void fillFormFields(Object... elementsAndValues) {
	    if (elementsAndValues.length % 2 != 0) {
	        throw new IllegalArgumentException("You must provide pairs of locator and value.");
	    }
	 
	    for (int i = 0; i < elementsAndValues.length; i += 2) {
	        By locator = (By) elementsAndValues[i];
	        String value = (String) elementsAndValues[i + 1];
	 
	        try {
	            WebElement element = driver.findElement(locator);
	            element.clear();
	            element.sendKeys(value);
	        } catch (Exception e) {	            
	            throw e;
	        }
	    }
	}

	/// <summary>
	/// isExists Validation
	/// </summary>
	public boolean isExists(By locator) {
		boolean status= false;
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		try {
			webElement = driver.findElement(locator);
			if(webElement.isDisplayed())
				status=true;
			return status;
		}
		catch(Exception e) {
			e.printStackTrace();
			return status;
		}

	}
	/// <summary>
	/// isExists Negative Validation		        
	/// </summary>
	public boolean isExistsNegative(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 3); // Short timeout
			wait.until(ExpectedConditions.presenceOfElementLocated(locator)); // Check if element is present

			WebElement webElement = driver.findElement(locator);
			return webElement.isDisplayed(); // Returns true if the element is visible
		} catch (NoSuchElementException | TimeoutException e) {
			return false; // Returns false if the element is not found
		}
	}




	/// <summary>
	/// Method that highLights elements	        
	/// </summary>
	public void highLighterMethod(WebDriver driver, WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String bgColor = element.getCssValue("backgroundColor");
		js.executeScript("arguments[0].setAttribute('style', 'background: "+bgColor+"; border: 2px solid red;');", element);

	}

	/// <summary>
	/// Select checkBox
	/// </summary>
	public void selectCheckBox(By locator) {
		webElement  = driver.findElement(locator);
		boolean isSelected = webElement.isSelected();
		//performing click operation if element is not checked
		if(isSelected == false) {
			webElement.click();

		}
	}


	/// <summary>
	/// Verifying that modules can be seen
	/// </summary>
	public void checkSubMenue(By locator,java.util.List<String>list) {

		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		webElements = (List<WebElement>)driver.findElements(locator);

		for(int i=0;i<list.size();i++) {

			for(int j=0;j<webElements.size();j++) {

				String actualText = webElements.get(j).getText();
				String expectedText = list.get(i);

				if(actualText.equals(expectedText)) {

					asrt.assertEquals(actualText,expectedText);
					break;
				}

			}
		}	   

	}


	/// <summary>
	/// Selecting Multiple values from the Dropdown
	/// </summary>

	public void multiSelectDropdown(By locator,java.util.List<String>list) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElements = (List<WebElement>)driver.findElements(locator);
		highLighterMethod(driver, webElement);

		for(int i=0;i<list.size();i++) {

			for(int j=0;j<webElements.size();j++) {

				String actualText = webElements.get(j).getText();
				String expectedText = list.get(i);

				if(actualText.equals(expectedText)) {

					webElements.get(j).click();
					break;
				}

			}
		}	   
	}


	/// <summary>
	/// Get Value
	/// </summary>
	public String GetValue(By locator) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement =driver.findElement(locator);
		data = webElement.getAttribute("value"); 
		return data;
	}


	/// <summary>
	/// Getting Attributes of Elements
	/// </summary>
	public String GetAttribte(By locator,String AttributeName) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement =driver.findElement(locator);
		data = webElement.getAttribute(AttributeName); 
		return data;
	}


	/// <summary>
	/// To Hover an element with given timeout
	/// </summary>
	public void Hover(By locator) {
		webElement  = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(webElement).perform();
	}


	/// <summary>
	/// To create a random string by passing number of characters
	/// </summary>
	public static String CreateRandom(int n)
	{

		// choose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"
				+ "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index
			= (int)(AlphaNumericString.length()
					* Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString
					.charAt(index));
		}

		return sb.toString();
	}

	/// <summary>
	/// To fetch elements
	/// </summary>
	public List<WebElement> GetElement(By locator) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		List<WebElement> elements = driver.findElements(locator);
		return elements;
	}

	/// <summary>
	/// JS click

	/// </summary>
	public void JsClick(String locator) throws InterruptedException {

		js = (JavascriptExecutor)driver;
		//WebDriverWait wait = getWait();
		Thread.sleep(4000);
		js.executeScript("(document.getElementsByClassName('"+locator+"'))[0].click()");
	}
	/// <summary>
	/// Perform Action On Alert

	/// </summary>
	public void PerformActionOnAlert(String Action,String ExpectedAlertMessage, String InputValue) throws Exception {
		switch (Action) 
		{
		case "accept":
			driver.switchTo().alert().accept();			
			break;

		case "dismiss":
			driver.switchTo().alert().dismiss();		
			break;

		case "getText":
			String AlertMessage = driver.switchTo().alert().getText();
			asrt.assertEquals(AlertMessage, ExpectedAlertMessage,"Difference in Actaul and Expected Message");
			break;

		case "sendKeys":
			driver.switchTo().alert().sendKeys(InputValue);
			break;

		default:
			throw new IllegalArgumentException("Action \"" + Action + "\" isn't supported.");
		}
	}


	/// <summary>
	/// Reusable Method for Switching to a New Window by Index
	/// </summary>
	public void switchToWindowByIndex(WebDriver driver, int index) {
		// Get all window handles
		WebDriverWait wait = new WebDriverWait(driver, 60); // Timeout in seconds

		// Wait until the number of windows is greater than the target index
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver d) {
				return d.getWindowHandles().size() > index;
			}
		});
		Set<String> allWindows = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(allWindows);

		// Ensure the index is valid
		if (index < windowList.size()) {
			// Switch to the desired window by index
			driver.switchTo().window(windowList.get(index));
		} else {
			throw new IllegalArgumentException("Invalid window index: " + index);
		}
	}


	/// <summary>
	/// Reusable Method for Returning to the Original Window

	/// </summary>
	public void returnToMainWindow(WebDriver driver) {
		// Capture the current (main) window handle
		String mainWindowHandle = driver.getWindowHandles().iterator().next();

		// Switch back to the main window
		driver.switchTo().window(mainWindowHandle);
	}


	/// <summary>
	/// Reusable Method for Scrolldown	        
	/// </summary>
	public void scrollToElement(By locator) {
		js= (JavascriptExecutor) driver;
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		webElement =driver.findElement(locator);
		highLighterMethod(driver, webElement); 
		js.executeScript("arguments[0].scrollIntoView(true);", webElement );
	}


	/// <summary>
	/// To create a random string without Numbers by passing number of characters
	/// </summary>
	public static String CreateRandomWithoutNumbers(int n)
	{

		// choose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index
			= (int)(AlphaNumericString.length()
					* Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString
					.charAt(index));
		}

		return sb.toString();
	}
	/// <summary>
	/// To clear the text in a field
	/// </summary>

	public void clearData(By locator) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement =driver.findElement(locator);
		highLighterMethod(driver, webElement); 
		webElement.clear();
	}
	/// <summary>
	/// To clear the text in a field
	/// </summary>



	public void pressKey(By element, String key) throws InterruptedException {
		Actions actions = new Actions(driver);

		switch (key.toUpperCase()) {
		case "ENTER":
			actions.sendKeys(driver.findElement(element), Keys.ENTER).perform();
			break;
		case "TAB":
			actions.sendKeys(driver.findElement(element), Keys.TAB).perform();
			break;
		case "ESCAPE":
			actions.sendKeys(driver.findElement(element), Keys.ESCAPE).perform();
			break;
		case "SPACE":
			actions.sendKeys(driver.findElement(element), Keys.SPACE).perform();
			break;
		case "ARROW_UP":
			actions.sendKeys(driver.findElement(element), Keys.ARROW_UP).perform();
			break;
		case "ARROW_DOWN":
			actions.sendKeys(driver.findElement(element), Keys.ARROW_DOWN).perform();
			break;
		case "ARROW_LEFT":
			actions.sendKeys(driver.findElement(element), Keys.ARROW_LEFT).perform();
			break;
		case "ARROW_RIGHT":
			actions.sendKeys(driver.findElement(element), Keys.ARROW_RIGHT).perform();
			break;
		case "CONTROL_A":
			actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
			break;
		case "CONTROL_C":
			actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
			break;
		case "CONTROL_V":
			actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
			break;
		case "KEYBOARD_SPACE":
			actions.sendKeys(" ").perform();
			break;
		case "KEYBOARD_M":
			actions.sendKeys("m").perform();
			break;
		case "KEYBOARD_RIGHTARROW":
			actions.sendKeys("\uE014").perform();
			break;
		case "KEYBOARD_L":
			actions.sendKeys("l").perform();
			break;
		case "KEYBOARD_J":
			actions.sendKeys("j").perform();
			break;
		case "KEYBOARD_'":
			actions.sendKeys("'").perform();
			break;
		case "KEYBOARD_.":
			actions.sendKeys(".").perform();
			break;
		case "KEYBOARD_>":
			actions.sendKeys(">").perform();
			break;
		case "KEYBOARD_DOWN":
			actions.sendKeys("\uE015").perform();
			break;
		case "KEYBOARD_]":
			actions.sendKeys("]").perform();
			break;
		case "KEYBOARD_[":
			actions.sendKeys("[").perform();
			break;
		case "KEYBOARD_1-9":
			for (int i = 0; i <= 9; i++) {
				String keys = String.valueOf(i); // Convert the number to a string
				Thread.sleep(1000);
				actions.sendKeys(keys).perform();
			}
			break;
		case "KEYBOARD_F":
			actions.sendKeys("F").perform();
			break;
		case "KEYBOARD_D":
			actions.sendKeys("D").perform();
			break;
		case "KEYBOARD_S":
			actions.sendKeys("S").perform();
			break;
		case "KEYBOARD_ENTER":
			actions.sendKeys(Keys.ENTER).perform();
			break;
		case "ESCAPE1":
			actions.sendKeys(Keys.ESCAPE).perform();
			break;
		default:
			System.out.println("Invalid key action: " + key);
			break;
		}
	}

	/// <summary>
	/// Verifying that user can click on the text which is equal to actualText and expectedText
	/// </summary>
	public String checkSubMenueAndClick(By locator,java.util.List<String>list,String text) throws InterruptedException {
		String name = null;
		WebDriverWait wait = new WebDriverWait(driver, 20);
		List<WebElement> listItems = wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(locator)
				);
		webElements = (List<WebElement>)driver.findElements(locator);

		for(int i=0;i<list.size();i++) {

			for(int j=0;j<webElements.size();j++) {

				String actualText = webElements.get(j).getText();
				Thread.sleep(500);
				String expectedText = list.get(i);

				if(actualText.equals(expectedText)) {
					WebDriverWait wait1 = new WebDriverWait(driver, 20);
					WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(webElements.get(j)));

					try {
						Thread.sleep(500); // Short delay to ensure scroll completes
						name=element.findElement(By.xpath(text)).getText();
						element.click();
					} catch (org.openqa.selenium.ElementClickInterceptedException e) {
						System.out.println("catching Element click intercepted");
					}
					break;  
				}

			}
		}	   
		return name;  
	}

	/// <summary>
	/// To check an element is enabled or not
	/// </summary>

	public boolean isEnabledBy(By locator) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		webElement =driver.findElement(locator);
		highLighterMethod(driver, webElement); 
		return webElement.isEnabled();
	}
	// <summary>
	// File Upload
	// </summary>
	public void uploadFile(By locator, String filePath, List<String> allowedTypes) {
		// Validate the file format
		if (!isValidFile(filePath, allowedTypes)) {
			throw new IllegalArgumentException("Invalid file format. Allowed formats: " + allowedTypes);
		}

		// Find the file input element
		WebElement fileInput = driver.findElement(locator);

		// Provide the absolute file path to the input element
		fileInput.sendKeys(filePath);
	}
	// <summary>
	// Checking the validity of a file based on the file path and a list of allowed types.
	// </summary>
	private boolean isValidFile(String filePath, List<String> allowedTypes) {
		File file = new File(filePath);
		String fileName = file.getName().toLowerCase();

		return file.exists() && file.isFile() && 
				allowedTypes.stream().anyMatch(fileName::endsWith);
	}

	// <summary>
	// Reusable Method for Scrolldown the element to Center
	// </summary>
	public void scrollToElementtoCenter(By locator) {
		js = (JavascriptExecutor) driver;
		WebDriverWait wait = getWait();		    
		// Wait until the element is clickable
		wait.until(ExpectedConditions.elementToBeClickable(locator));		    
		webElement = driver.findElement(locator);
		// Highlight the element (Optional, for debugging purposes)
		highLighterMethod(driver, webElement);
		// Scroll and align the element in the viewport
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", webElement);
	}

	/// <summary>
	/// Verify my string is present in the list if present then true or it is false
	/// </summary>

	public boolean verifyStringPresent(By locator,String checkString) {
		boolean isPresent=false;
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		webElements =driver.findElements(locator);

		// Iterate over the list using a for loop
		for (WebElement element : webElements) {
			String text = element.getText();
			if (text.equals(checkString)) {
				isPresent = true; // Mark as found
				break;
			}
		}
		return isPresent;
	}



	/// <summary>
	/// To fetch List of texts
	/// </summary>
	public List<String> GetElementTexts(By locator) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		List<WebElement> elements = driver.findElements(locator);
		// Extract text from each element and collect into a List<String>
		List<String> elementTexts = new ArrayList<>();
		for (WebElement element : elements) {
			elementTexts.add(element.getText());
		}

		return elementTexts;
	} 
	// <summary>
	// To clear the text in a field
	// </summary>
	public static String CreateRandomNumber(int n) {

		String NumericString = "0123456789";
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {
			// Generate a random index within the NumericString length
			int index = (int) (NumericString.length() * Math.random());
			// Append the character at the random index
			sb.append(NumericString.charAt(index));
		}
		return sb.toString();
	}

	//Validates if the invite link is highlighted in red when the copy button is clicked.
	// @param inviteLinkLocator Locator for the invite link.
	// @param expectedColor The expected color (e.g., "rgb(255, 0, 0)" for red).
	// @return true if the invite link is highlighted in the expected color, false otherwise.
	public boolean validateInviteLinkColor(By inviteLinkLocator, String expectedColor) {

		// Wait for the invite link to change color
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(inviteLinkLocator));
		webElement =driver.findElement(inviteLinkLocator);
		String actualColor = webElement.getCssValue("color");
		System.out.println("actualColor is ="+actualColor);

		// Validate the color
		return actualColor.equals(expectedColor);
	}

	/// <summary>
	/// Get Value of a particular attribute and if the attributeValue is matching with expected then return the text of the element
	/// </summary>
	public String GetValueForList(java.util.List<WebElement> list,String attributeName,String attributeValue) {


		for (WebElement element : list) {
			// Get the attribute value of the current element
			String actualValue = element.getAttribute(attributeName);

			// Check if it matches the given value
			if (actualValue != null && actualValue.equals(attributeValue)) {
				// Return the text or any other desired property of the matched element
				return element.getText();
			}
		}

		// Return null or a default value if no match is found
		return null;

	}

	// <summary>
	/// user selecting the color in snipcollection color tag
	/// </summary>
	public void selectColor(int xOffset, int yOffset) {
		try {

			WebElement colorCircle = driver.findElement(By.cssSelector(".IroWheel")); // Update the selector if necessary
			Actions actions = new Actions(driver);
			actions.moveToElement(colorCircle, xOffset, yOffset).click().perform();
		} catch (Exception e) {
			System.out.println("Error while selecting color: " + e.getMessage());
		}
	}
	// <summary>
	// Reusable method to adjust brightness using the slider in SnipCollection color selection
	// </summary>
	public void adjustBrightness(int sliderOffset) {
		try {
			WebElement brightnessSlider = driver.findElement(By.cssSelector(".IroWheelLightness"));
			Actions actions = new Actions(driver);
			actions.dragAndDropBy(brightnessSlider, sliderOffset, 0).perform();
		} catch (Exception e) {
			System.out.println("Error while adjusting brightness: " + e.getMessage());
		}
	}

	/// <summary>
	/// Validate Text if actual text contains the expected text
	/// </summary>

	public void validateTextIfContains(By locator,String expectedText) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = driver.findElement(locator);
		String actualText = webElement.getText();
		asrt.assertTrue(actualText.contains(expectedText),"Actual text does not contain the expected text");
	}

	/// <summary>
	/// Get the selected Text in the dropDown 
	/// </summary>

	public String getTheSelectedTextInDropDown(By locator) {  
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = driver.findElement(locator);
		select = new Select(webElement);
		return select.getFirstSelectedOption().getText();

	}

	/// <summary>
	// Helper method to get clipboard content,  URL should be copied to the clipboard,
	public static String getClipboardText() {
		String clipboardText = "";
		try {
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboardText = (String) clipboard.getData(DataFlavor.stringFlavor);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to retrieve clipboard content: " + e.getMessage());
		}
		return clipboardText;
	}

	/// <summary>
	/// Verify if a popup or element is disappeared
	//   if the popup or element is shown then this will fail the test case
	/// </summary>

	public void isDoesNotExist(By locator,String message) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (org.openqa.selenium.TimeoutException e) {
			//if element is existing then conditionally failing the test case 
			asrt.fail(message);

		}
	}
	
	/// <summary>
	/// Verify if a popup or element is disappeared
	//   if the popup or element is shown then this will fail the test case
	/// </summary>
	public boolean isDoesNotExistBool(By locator) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	        return true; // Element is not visible (does not exist)
	    } catch (org.openqa.selenium.TimeoutException e) {
	        return false; // Element is still visible
	    }
	}

	/// <summary>
	/// moving slider from 0 to mid point
	/// </summary>
	public void moveSlider(By locator,String text,String text1) {

		// Locate the slider element
		WebElement slider = driver.findElement(locator);

		// Get the min and max values of the slider
		double min = Double.parseDouble(slider.getAttribute("min"));
		double max = Double.parseDouble(slider.getAttribute("max"));

		// Calculate the midpoint value
		double midpoint = (min + max) / 2;

		// Use JavaScript to set the slider value to the midpoint
		String script = "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input'));";
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript(script, slider, midpoint);
		double actualValue = Double.parseDouble(slider.getAttribute(text)); 
		Assert.assertNotEquals(actualValue, min,text1);
	}
	// <summary>
	/// user selecting the color in CustomTag color pick inside playerpage
	/// </summary>
	public void selectCustomTagColor(int xOffset, int yOffset) {
		try {

			WebElement colorRectangle = driver.findElement(By.cssSelector(".black box")); // Update the selector if necessary
			Actions actions = new Actions(driver);
			actions.moveToElement(colorRectangle, xOffset, yOffset).click().perform();
		} catch (Exception e) {
			System.out.println("Error while selecting color: " + e.getMessage());
		}
	}
	// <summary>
	// Reusable method to adjust color using the pointerbox in Custom tag color selection inside playerpage
	// </summary>
	public void adjustBrightnessCustomTag(int sliderOffset) {
		try {
			WebElement brightnessSlider = driver.findElement(By.cssSelector(".pointer box"));
			Actions actions = new Actions(driver);
			actions.dragAndDropBy(brightnessSlider, sliderOffset, 0).perform();
		} catch (Exception e) {
			System.out.println("Error while adjusting brightness: " + e.getMessage());
		}
	}



	/// <summary>
	/// Get all options from dropdown
	/// </summary>

	public List<WebElement> getTheAllOptions(By locator) {    
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = driver.findElement(locator);
		highLighterMethod(driver, webElement); 
		select = new Select(webElement);
		return select.getOptions();

	}
	/// <summary>
	/// To Get future days 
	/// </summary>
	public String getDateAfterDays(int numberOfDays) {
		LocalDateTime currentDate = LocalDateTime.now().plusDays(numberOfDays);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
		return currentDate.format(formatter);
	}
	//To get current date
	public String getDate() {
		LocalDateTime currentDate = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy 'at' hh:mm:00 a",Locale.US);
		return currentDate.format(formatter);

		//return formattedDate.replaceAll("(?i)am|pm", match -> match.group().toUpperCase());
	}
	//To clearText
	public void clearTextUsingKeys(WebElement element) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		element.sendKeys(Keys.BACK_SPACE);

	}
	/// <summary>
	/// Adjusts the zoom level of the webpage using JavaScript.
	/// </summary>
	public void setZoom(WebDriver driver, int zoomPercentage) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='" + zoomPercentage + "%'");
		//driver.manage().window().setSize(new Dimension(1280, 720));
	}

	//<summary>
	//Reusable Method for ScrollUp	        
	//</summary>
	public void scrollUp(By locator) 
	{
		js= (JavascriptExecutor) driver;
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		webElement =driver.findElement(locator);
		highLighterMethod(driver, webElement); 
		js.executeScript("window.scrollBy(0, -250);");
	}

	//<summary>
	//Reusable Method for Backspace	        
	//</summary>
	public void backspace(By locator) 
	{
		js= (JavascriptExecutor) driver;
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = driver.findElement(locator);
		element.click();  // Focus on the element
		Actions actions = new Actions(driver);

		// Send backspace key multiple times (based on the length of text in the field)
		for (int i = 0; i < element.getAttribute("value").length(); i++) 
		{
			actions.sendKeys(element, "\u0008").perform();  // Send backspace key
		}
	}
	//<summary>
	//Reusable Method for cleartext	        
	//</summary>
	public void clearAllText(By locator) {
		js= (JavascriptExecutor) driver;
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = driver.findElement(locator);

		element.clear();
	}
	//<summary>
	//Reusable Method for Backspace	        
	//</summary>
	public void backspaces(By locator, int noofspaces) {
		// Wait until the element is clickable
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(locator));

		WebElement element = driver.findElement(locator);
		element.click();  // Focus on the input field

		// Create an instance of Actions class
		Actions actions = new Actions(driver);

		// Send backspace key the specified number of times
		for (int i = 0; i < noofspaces; i++) {
			actions.sendKeys(Keys.BACK_SPACE).perform();  // Simulate backspace key
		}
	}

	//<Summary>
	//<Is exists/contains in text>
	//</Summary>
	public boolean isExistsInText(List<String> elementTexts, String searchTerm) {
		for (String text : elementTexts) {
			if (text.contains(searchTerm)) {
				return true;  // If any text contains the search term, return true
			}
		}
		return false;  // Otherwise, return false
	}
	//<Summary>
		//<For button click more than once>
		//</Summary>
		public void clickMultipleTimes(By locator, int clickCount) {
		    for (int i = 0; i < clickCount; i++) {
		    	buttonClick(locator);
		    }
		}
		//Summary
		//<Is exists/starts with >
		//</Summary>
		public boolean isExistsInStart(List<String> elementTexts, String searchTerm) {
	        for (String text : elementTexts) {
	            if (text.toLowerCase().startsWith(searchTerm.toLowerCase())) {
	                return true;
	            }
	        }
	        return false;
	    }
		//Summary
		//<Is exists/starts with >
		//</Summary>
		public String DropDownText (By locator) {
			Select select = new Select(driver.findElement(locator));
			String selectedOption = select.getFirstSelectedOption().getText();
			return selectedOption;
		}
		
}








