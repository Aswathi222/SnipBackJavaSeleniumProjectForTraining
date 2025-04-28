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

public class ElementActions {
	protected WebDriver driver;
	WebElement webElement;
	List<WebElement> webElements;
	Assert asrt;
	JavascriptExecutor js;
	Select select;
	String data;
	int exitVal;
	public ElementActions(WebDriver driver) {
		this.driver=driver;	
	}

	//Summary
	//<DropDownText >
	//</Summary>
	public String DropDownText (By locator) {
		Select select = new Select(driver.findElement(locator));
		String selectedOption = select.getFirstSelectedOption().getText();
		return selectedOption;
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
	///<summary>
	/////to get todays date
	///</summary>
	public String getFormattedDate(By locator) {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy", Locale.US);
		return currentDate.format(formatter);
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
	/// Method that highLights elements	        
	/// </summary>
	public void highLighterMethod(WebDriver driver, WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String bgColor = element.getCssValue("backgroundColor");
		js.executeScript("arguments[0].setAttribute('style', 'background: "+bgColor+"; border: 2px solid red;');", element);
	}
	//<summary>
	//To click an element with given timeout         
	public void buttonClick(By locator) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		webElement =driver.findElement(locator);
		highLighterMethod(driver, webElement); 
		webElement.click();
	}
	// </summary>
	//<For button click more than once>
	//</Summary>
	public void clickMultipleTimes(By locator, int clickCount) {
		for (int i = 0; i < clickCount; i++) {
			buttonClick(locator);
		}
	}
	// <summary>
	// To check if an element is disabled
	// </summary>
	public boolean isDisabledBy(By locator) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		webElement = driver.findElement(locator);
		highLighterMethod(driver, webElement);
		return !webElement.isEnabled();
	}
	/// <summary>
	/// To create a random integer with the specified number of digits
	/// </summary>
	public static String CreateRandomIntString(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Number of digits must be greater than 0");
		}

		int min = (int) Math.pow(10, n - 1);
		int max = (int) Math.pow(10, n) - 1;

		int randomNumber = min + (int)(Math.random() * ((max - min) + 1));
		return String.valueOf(randomNumber);
	}
}








