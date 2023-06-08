package ru.mail.pages;

import io.qameta.allure.Step;

/**
 * Класс PageObject главной страницы mail.ru
 */
public class MainPage extends BasePage {

    /**
     * xPath кнопки логина
     */
    private static final String loginButtonXPath = "//button[@data-testid='enter-mail-primary']";

    /**
     * Открывает окно логина
     */
    @Step("Открываем окно логина")
    public LoginFrame clickLoginButton() {
        click(loginButtonXPath);
        return new LoginFrame();
    }
}