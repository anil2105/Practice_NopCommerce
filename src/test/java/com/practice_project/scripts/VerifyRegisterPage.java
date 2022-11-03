package com.practice_project.scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.practice_project.pom.RegisterPage;

public class VerifyRegisterPage extends BaseTest
{
	@Test
	public void verifyRegisterPage() throws IOException
	{
		RegisterPage regPage=new RegisterPage(driver);

		/*
		 * regPage.clickOnGenderButton(); 
		 * regPage.setFirstName("Anil");
		 * regPage.setLastName("Kumar"); 
		 * regPage.selectDateOfBirth();
		 * regPage.setEmail("anil.krtg@yahoo.com"); 
		 * regPage.setCompanyName("Nasdaq");
		 * regPage.setPassword("2105"); 
		 * regPage.setConfrimPassword("2105");
		 * regPage.clickOnRegister();
		 */
						
			regPage.registerNewAccount("Anil", "Kumar", "anil.krtg@yahoo.com", "Nasdaq", "210527", "210527");
			
			boolean res = driver.getTitle().contains("nopCommerce demo store");
			
			if(res==true)
			{
				Assert.assertTrue(true);
				//Reporter.log("test case passed");
			}
			else
			{
				captureScreenShot("addNewAccount");
				Assert.assertTrue(false);
				//Reporter.log("test case failed");
			}
	}
	
}
