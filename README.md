# ФРЕЙМВОРК АВТОМАТИЗИРОВАННОГО ТЕСТИРОВАНИЯ WEB ВЕРСИИ ПОЧТЫ mail.ru

Предназначен для тестирования web версии почты mail.ru, содержит в себе функционал взаимодействия с web-интерфейсом
страниц и инструменты для выполнения необходимых проверок

## Перед запуском необходимо внести Логин и Пароль пользователя в класс [TestRunData](src/main/java/ru/mail/helpers/TestRunData.java)

- - -
### Общая информация

`src/test/java/ru/mail/WebDriverSetup.java` настройка web-драйвера\
`src/test/resources/general.properties` техданные для фрейма\
`src/test/java/ru/mail/EmailSendTest.java` автотесты\
`src/main/java/ru/mail/pages` PO\
`src/main/java/ru/mail/helpers/TestRunData.java` тестовые данные (перед запуском внесите сюда Логин и Пароль пользователя)
- - -
### Локальный запуск

Запуск автотестов осуществляется:

1. Выполнением команды `mvn clean test -Dtest=EmailSendTest`

2. Ручным запуском тестов из класса [EmailSendTest](src/test/java/ru/mail/EmailSendTest.java)
- - -
### Сборка Allure отчёта

Сборка Allure отчёта осуществляется:

Выполнением команды `mvn allure:serve`
- - -