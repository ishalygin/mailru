package ru.mail.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Класс PageObject фрейма(окна) логина
 */
public class LoginFrame extends BasePage {

    /**
     * xPath фрейма(окна) логина
     */
    private final By frame = By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']");

    /**
     * xPath поля логина
     */
    private final By usernameField = By.xpath("//input[@name='username']");

    /**
     * Поле поля пароля
     */
    private final By passwordField = By.xpath("//input[@name='password']");

    public LoginFrame(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    /**
     * Вводит логин пользователя
     *
     * @param login логин пользователя
     */
    @Step("Вводим логин пользователя")
    public LoginFrame sendLogin(String login) {
        driver.switchTo().frame(driver.findElement(frame));
        wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        driver.findElement(usernameField).sendKeys(login + Keys.ENTER);
        return this;
    }

    /**
     * Вводит пароль пользователя
     *
     * @param password пароль пользователя
     */
    @Step("Вводим пароль пользователя")
    public InboxPage sendPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        driver.findElement(passwordField).sendKeys(password + Keys.ENTER);
        return new InboxPage(driver);
    }

}
