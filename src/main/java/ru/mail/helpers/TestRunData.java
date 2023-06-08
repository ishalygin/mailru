package ru.mail.helpers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

/**
 * Класс тестовых данных
 */
public class TestRunData {

    /**
     * Класс для теста отправки письма
     */
    public static class SendLetterTestData implements ArgumentsProvider {

        /**
         * Логин отправителя без @
         */
        public static final String login = "здесь ваш логин";

        /**
         * Пароль отправителя
         */
        public static final String password = "здесь ваш пароль";

        /**
         * Email получателя (по умолчанию используется email отправителя)
         */
        public static final String email = login + "@mail.ru";

        /**
         * Текст письма
         */
        public static final String text = "Test Letter " + System.currentTimeMillis();

        @Override
        public String toString() {
            return "login=" + login + " ● " +
                    "password=" + password + " ● " +
                    "email=" + email + " ● " +
                    "text=" + text;
        }

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(Arguments.of(new SendLetterTestData()));
        }
    }
}