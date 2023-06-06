package ru.mail;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.mail.pages.InboxPage;
import ru.mail.pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Класс степов
 */
public class Steps extends WebDriverSetup {

    private MainPage mainPage;

    private InboxPage inboxPage;


    public Steps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открываем mail.ru")
    public Steps openMailRu() {
        driver.get(props.mailruUrl());
        mainPage = new MainPage(driver);
        makeScreenshot();
        return this;
    }

    @Step("Логинимся в систему")
    public Steps logInSystem(String login, String password) {
        inboxPage = mainPage
                .clickLoginButton()
                .sendLogin(login)
                .sendPassword(password);
        makeScreenshot();
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
        makeScreenshot();
    }
}
