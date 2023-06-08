package ru.mail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import ru.mail.helpers.TestRunData;

/**
 * Класс тестов
 */
class EmailSendTest extends WebDriverSetup {

    @ParameterizedTest(name = "[{arguments}]")
    @DisplayName("Отправка письма через mail.ru")
    @ArgumentsSource(TestRunData.SendLetterTestData.class)
    public void sendLetterTest(TestRunData.SendLetterTestData testData) {
        new Steps()
                .openMailRu()
                .logInSystem(testData.login, testData.password)
                .sendLetter(testData.email, testData.text);
    }
}