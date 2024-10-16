package org.example.tests;

import io.qameta.allure.*;
import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RequiredFieldsValidation {
    WebDriver driver;
    RegistrationPage registrationPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/WebDrivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9222"); // Указание порта вручную

        driver = new ChromeDriver(options);
        driver.get("https://cafedexslopess2024.staging.dja.com/");
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    @Description("Check required fields validation")
    @Severity(SeverityLevel.CRITICAL)
    public void checkRequiredFieldsValidation() {
        registrationPage.submitForm();  // Submit without filling anything
        assertTrue(registrationPage.isErrorMessageDisplayed(), "Error message should be displayed for missing required fields.");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
