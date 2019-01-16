package org.quotation.project;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Demo extends Driver {

	Alert alert;

	@Test
	public void verifyAgeEntered() {
		WebElement calculatePremium = getDriver().findElement(By.id("calculatepremium"));
		calculatePremium.click();

		WebDriverWait wait = new WebDriverWait(getDriver(), 5);
		wait.until(ExpectedConditions.alertIsPresent());

		alert = getDriver().switchTo().alert();
		
		assertEquals(alert.getText(), "Please enter the age of the customer");

		alert.accept();

	}
	
}



