package ru.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Абстрактный класс базовой страницы
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

}
