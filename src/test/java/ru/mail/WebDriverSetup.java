package ru.mail;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.mail.helpers.Props;
import ru.mail.pages.BasePage;

import java.time.Duration;

/**
 * Абстрактный класс настройки веб-драйвера
 */
abstract class WebDriverSetup {

    protected static final Props props = Props.props;
    protected WebDriver driver;

    @BeforeEach
    protected void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(props.mailruUrl());
        BasePage.setDriver(driver);
    }

    @AfterEach
    protected void after() {
        driver.quit();
    }

}