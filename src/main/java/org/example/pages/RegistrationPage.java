package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for form fields
    By email = By.name("email");
    By confirmEmail = By.name("confirmEmail");
    By fedExNumber = By.name("fedexNumber");
    By companyName = By.name("companyName");
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By address1 = By.name("address1");
    By submitButton = By.xpath("//button[@type='submit']");
    By successMessage = By.xpath("//*[contains(text(),'Thank you for your submission')]");
    By errorMessage = By.xpath("//*[contains(text(),'Error')]");

    // Methods for interacting with the form
    public void enterEmail(String emailText) {
        driver.findElement(email).sendKeys(emailText);
    }

    public void enterConfirmEmail(String confirmEmailText) {
        driver.findElement(confirmEmail).sendKeys(confirmEmailText);
    }

    public void enterFedExNumber(String fedExNum) {
        driver.findElement(fedExNumber).sendKeys(fedExNum);
    }

    public void enterCompanyName(String company) {
        driver.findElement(companyName).sendKeys(company);
    }

    public void enterFirstName(String first) {
        driver.findElement(firstName).sendKeys(first);
    }

    public void enterLastName(String last) {
        driver.findElement(lastName).sendKeys(last);
    }

    public void enterAddress1(String address) {
        driver.findElement(address1).sendKeys(address);
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }

    public boolean isSubmissionSuccessful() {
        return driver.findElement(successMessage).isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }
}

