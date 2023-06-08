package ru.mail.pages;

import io.qameta.allure.Step;

/**
 * Класс PageObject фрейма(окна) логина
 */
public class LoginFrame extends BasePage {

    /**
     * xPath фрейма(окна) логина
     */
    private static final String frameXPath = "//iframe[@class='ag-popup__frame__layout__iframe']";

    /**
     * xPath поля логина
     */
    private static final String usernameFieldXPath = "//input[@name='username']";

    /**
     * xPath поля пароля
     */
    private static final String passwordFieldXPath = "//input[@name='password']";

    /**
     * Вводит логин пользователя
     *
     * @param login логин пользователя
     */
    @Step("Вводим логин пользователя")
    public LoginFrame sendLogin(String login) {
        switchToFrame(frameXPath);
        write(login, usernameFieldXPath);
        return this;
    }

    /**
     * Вводит пароль пользователя
     *
     * @param password пароль пользователя
     */
    @Step("Вводим пароль пользователя")
    public InboxPage sendPassword(String password) {
        write(password, passwordFieldXPath);
        return new InboxPage();
    }

}