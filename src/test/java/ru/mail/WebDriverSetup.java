package ru.mail;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.mail.helpers.Props;

import java.time.Duration;

/**
 * Абстрактный класс настройки веб-драйвера
 */
public abstract class WebDriverSetup {

    protected final static Props props = Props.props;
    protected WebDriver driver;

    @BeforeEach
    protected void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterEach
    protected void after() {
        driver.quit();
    }

    @Attachment(value = "Attachment Screenshot", type = "image/jpg")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
