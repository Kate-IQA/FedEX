package org.example.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailFormatValidation {
    WebDriver driver;

    @BeforeEach
    @Step("Setting up the test environment")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/WebDrivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://cafedexslopess2024.staging.dja.com/");
    }

    @Test
    @Description("Verify email format validation")
    @Step("Test: Email format validation")
    public void testEmailFormatValidation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Заполнение всех необходимых полей для корректной отправки формы
        fillInputField(wait, "fedex_account", "123456");
        fillInputField(wait, "first_name", "John");
        fillInputField(wait, "last_name", "Doe");
        fillInputField(wait, "address_1", "123 Test Street");
        fillInputField(wait, "city", "Test City");

        // Выбор Province
        WebElement provinceDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.name("province")));
        scrollToElement(provinceDropdown);
        provinceDropdown.click();
        WebElement provinceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='Alberta']")));
        provinceOption.click();

        fillInputField(wait, "zip", "T8S 1M5");
        fillInputField(wait, "primary_phone", "1234567890");
        fillInputField(wait, "mobile_phone", "1234567890");

        // Ввод неправильного формата email
        fillInputField(wait, "email", "invalid-email");
        fillInputField(wait, "confirm_email", "invalid-email");

        // Чекбоксы
        WebElement optinContact = wait.until(ExpectedConditions.elementToBeClickable(By.id("optin_contact")));
        scrollToElement(optinContact);
        if (!optinContact.isSelected()) {
            optinContact.click();
        }

        WebElement optinRules = wait.until(ExpectedConditions.elementToBeClickable(By.id("optin_rules")));
        scrollToElement(optinRules);
        if (!optinRules.isSelected()) {
            optinRules.click();
        }

        // Нажатие на кнопку Submit
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-submit")));
        scrollToElement(submitButton);
        submitButton.click();

        // Проверка, что появилось сообщение об ошибке формата email
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Invalid email format')]")));
        assertTrue(errorMessage.isDisplayed(), "The email format validation failed!");
    }

    @AfterEach
    @Step("Closing the browser after test execution")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Step("Fill input field: {fieldName} with value: {value}")
    private void fillInputField(WebDriverWait wait, String fieldName, String value) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(fieldName)));
        scrollToElement(element);
        element.clear();
        element.sendKeys(value);
    }

    @Step("Scroll to element")
    private void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("window.scrollBy(0, -100)"); // Необходимая подстройка
    }
}
