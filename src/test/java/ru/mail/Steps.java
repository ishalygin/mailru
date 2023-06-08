package ru.mail;

import io.qameta.allure.Step;
import ru.mail.pages.InboxPage;
import ru.mail.pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Класс степов
 */
class Steps extends WebDriverSetup {

    private MainPage mainPage;

    private InboxPage inboxPage;

    public Steps() {
    }

    @Step("Открываем mail.ru")
    public Steps openMailRu() {
        mainPage = new MainPage();
        mainPage.makeScreenshot();
        return this;
    }

    @Step("Логинимся в систему")
    public Steps logInSystem(String login, String password) {
        inboxPage = mainPage
                .clickLoginButton()
                .sendLogin(login)
                .sendPassword(password);
        inboxPage.makeScreenshot();
        return this;
    }

    @Step("Отправляем письмо")
    public void sendLetter(String email, String text) {
        String recipientEmail = inboxPage
                .writeLetter()
                .fillRecipient(email)
                .fillText(text)
                .sendLetter();
        assertEquals(email, recipientEmail, "Письмо не отправлено!");
        inboxPage.makeScreenshot();
    }
}