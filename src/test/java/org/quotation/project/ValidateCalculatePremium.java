package org.quotation.project;

import static org.testng.Assert.fail;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidateCalculatePremium extends Driver {

	@BeforeMethod
	public void initialize() throws Exception {

	}

	@Test
	public void verifyPremiumCalculation() throws InterruptedException {
		Thread.sleep(3000);
		fail("Not yet Implemented");

	}

	@AfterMethod
	public void reset() {

	}
}
