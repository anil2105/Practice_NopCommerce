package com.practice_project.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage 
{
	@FindBy(id = "gender-male")
	private WebElement genderRadioButton;

	@FindBy(id = "FirstName")
	private WebElement firstNameTextBox;

	@FindBy(id = "LastName")
	private WebElement lastNameTextBox;

	@FindBy(name = "DateOfBirthDay")
	private WebElement dateOfBirthDay;

	@FindBy(name = "DateOfBirthMonth")
	private WebElement dateOfBirthMonth;

	@FindBy(name = "DateOfBirthYear")
	private WebElement dateOfBirthYear;

	@FindBy(id = "Email")
	private WebElement emailTextBox;

	@FindBy(id = "Company")
	private WebElement companyNameTextBox;

	@FindBy(id = "Password")
	private WebElement passwordTextBox;

	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextBox;

	@FindBy(id = "register-button")
	private WebElement registerButton;

	public RegisterPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnGenderButton() 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");

		genderRadioButton.click();
	}

	public void setFirstName(String fn) 
	{
		firstNameTextBox.sendKeys(fn);
	}

	public void setLastName(String ln) 
	{
		lastNameTextBox.sendKeys(ln);
	}

	public void selectDateOfBirth()
	{
		dateOfBirthDay.click();
		Select selectDay = new Select(dateOfBirthDay);
		selectDay.selectByIndex(27);

		dateOfBirthMonth.click();
		Select selectMonth = new Select(dateOfBirthMonth);
		selectMonth.selectByVisibleText("July");

		dateOfBirthYear.click();
		Select selectYear = new Select(dateOfBirthYear);
		selectYear.selectByValue("1992");

	}

	public void setEmail(String email)
	{
		emailTextBox.sendKeys(email);
	}

	public void setCompanyName(String companyName)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");

		companyNameTextBox.sendKeys(companyName);
	}

	public void setPassword(String password) 
	{
		passwordTextBox.sendKeys(password);
	}

	public void setConfrimPassword(String confirmPassword) 
	{
		confirmPasswordTextBox.sendKeys(confirmPassword);
	}

	public void clickOnRegister() 
	{
		registerButton.click();
	}

	// Business Methods

	public void registerNewAccount(String fn, String ln, String email, String companyName, String password,
			String confirmPassword) 
	{
		clickOnGenderButton();
		setFirstName(fn);
		setLastName(ln);
		selectDateOfBirth();
		setEmail(email);
		setCompanyName(companyName);
		setPassword(password);
		setConfrimPassword(confirmPassword);
		clickOnRegister();
	}
}
