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
}








