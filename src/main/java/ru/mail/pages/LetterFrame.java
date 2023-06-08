package ru.mail.pages;

import io.qameta.allure.Step;

/**
 * Класс PageObject фрейма(окна) нового письма
 */
public class LetterFrame extends BasePage {

    /**
     * xPath поля "Кому"
     */
    private static final String recipientFieldXPath = "//div[text()='Кому']//following::input";

    /**
     * xPath поля для ввода текста письма
     */
    private static final String textFieldXPath = "//div[contains(@class, 'editable-container')]/div";

    /**
     * xPath кнопки "Отправить"
     */
    private static final String sendLetterButtonXPath = "//span[text()='Отправить']";

    /**
     * xPath текста об успешной отправке письма
     */
    private static final String successTextXPath = "//a[text()='Письмо отправлено']";

    /**
     * xPath текста имени и email получателя
     */
    private static final String recipientEmailXPath = "//span[contains(text(), 'Кому')]//following-sibling::span";

    /**
     * Заполняет email получателя
     *
     * @param recipient email получателя
     */
    @Step("Заполняем email получателя")
    public LetterFrame fillRecipient(String recipient) {
        write(recipient, recipientFieldXPath);
        return this;
    }

    /**
     * Заполняет текст письма
     *
     * @param text текст письма
     */
    @Step("Заполняем текст письма")
    public LetterFrame fillText(String text) {
        write(text, textFieldXPath);
        return this;
    }

    /**
     * Отправляет письмо
     */
    @Step("Отправляем письмо")
    public String sendLetter() {
        click(sendLetterButtonXPath);
        clickableWait(successTextXPath);
        String email = getText(recipientEmailXPath);
        return email.substring(email.indexOf('<') + 1, email.indexOf('>'));
    }
}