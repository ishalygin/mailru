package ru.mail.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Класс PageObject входящих писем
 */
public class InboxPage extends BasePage {

    /**
     * xPath кнопки "Написать письмо"
     */
    private final By sendLetterButton = By.xpath("//span[text()='Написать письмо']");

    public InboxPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    /**
     * Открывает фрейм(окно) нового письма
     */
    @Step("Открываем фрейм(окно) нового письма")
    public LetterFrame writeLetter() {
        wait.until(ExpectedConditions.elementToBeClickable(sendLetterButton));
        driver.findElement(sendLetterButton).click();
        return new LetterFrame(driver);
    }

}