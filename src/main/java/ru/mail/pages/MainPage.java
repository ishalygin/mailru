package ru.mail.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Класс PageObject главной страницы mail.ru
 */
public class MainPage extends BasePage {

    /**
     * xPath кнопки логина
     */
    private final By loginButton = By.xpath("//button[@data-testid='enter-mail-primary']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    /**
     * Открывает окно логина
     */
    @Step("Открываем окно логина")
    public LoginFrame clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
        return new LoginFrame(driver);
    }
}
