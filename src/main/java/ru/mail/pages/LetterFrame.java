package ru.mail.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Класс PageObject фрейма(окна) нового письма
 */
public class LetterFrame extends BasePage {

    /**
     * xPath поля "Кому"
     */
    private final By recipientField = By.xpath("//div[text()='Кому']//following::input");

    /**
     * xPath поля для ввода текста письма
     */
    private final By textField = By.xpath("//div[contains(@class, 'editable-container')]/div");

    /**
     * xPath кнопки "Отправить"
     */
    private final By sendLetterButton = By.xpath("//span[text()='Отправить']");

    /**
     * xPath текста об успешной отправке письма
     */
    private final By successText = By.xpath("//a[text()='Письмо отправлено']");

    /**
     * xPath текста имени и email получателя
     */
    private final By recipientEmail = By.xpath("//span[contains(text(), 'Кому')]//following-sibling::span");


    public LetterFrame(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    /**
     * Заполняет email получателя
     *
     * @param recipient email получателя
     */
    @Step("Заполняем email получателя")
    public LetterFrame fillRecipient(String recipient) {
        wait.until(ExpectedConditions.elementToBeClickable(recipientField));
        driver.findElement(recipientField).sendKeys(recipient);
        return this;
    }

    /**
     * Заполняет текст письма
     *
     * @param text текст письма
     */
    @Step("Заполняем текст письма")
    public LetterFrame fillText(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(textField));
        driver.findElement(textField).sendKeys(text);
        return this;
    }

    /**
     * Отправляет письмо
     */
    @Step("Отправляем письмо")
    public String sendLetter() {
        driver.findElement(sendLetterButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(successText));
        String email = driver.findElement(recipientEmail).getText();
        return email.substring(email.indexOf('<') + 1, email.indexOf('>'));
    }
}