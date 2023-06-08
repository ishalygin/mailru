package ru.mail.pages;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Абстрактный класс базовой страницы
 */
public abstract class BasePage {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void setDriver(WebDriver existDriver) {
        driver = existDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    /**
     * Записывает текст в поле
     *
     * @param text  текст для вставки
     * @param xPath xPath элемента
     */
    protected void write(String text, String xPath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
        driver.findElement(By.xpath(xPath)).sendKeys(text + Keys.ENTER);
    }

    /**
     * Кликает на элемент
     *
     * @param xPath xPath элемента
     */
    protected void click(String xPath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
        driver.findElement(By.xpath(xPath)).click();
    }

    /**
     * Переходит на фрейм
     *
     * @param xPath xPath фрейма
     */
    protected void switchToFrame(String xPath) {
        driver.switchTo().frame(driver.findElement(By.xpath(xPath)));
    }

    /**
     * Ожидает состояние clickable элемента
     *
     * @param xPath xPath элемента
     */
    protected void clickableWait(String xPath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
    }

    /**
     * Получает текст элемента
     *
     * @param xPath xPath элемента
     */
    protected String getText(String xPath) {
        return driver.findElement(By.xpath(xPath)).getText();
    }

    /**
     * Делает скриншот страницы
     */
    @Attachment(value = "Attachment Screenshot", type = "image/jpg")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}