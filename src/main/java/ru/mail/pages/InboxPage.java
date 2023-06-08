package ru.mail.pages;

import io.qameta.allure.Step;

/**
 * Класс PageObject входящих писем
 */
public class InboxPage extends BasePage {

    /**
     * xPath кнопки "Написать письмо"
     */
    private static final String sendLetterButtonXPath = "//span[text()='Написать письмо']";

    /**
     * Открывает фрейм(окно) нового письма
     */
    @Step("Открываем фрейм(окно) нового письма")
    public LetterFrame writeLetter() {
        click(sendLetterButtonXPath);
        return new LetterFrame();
    }

}