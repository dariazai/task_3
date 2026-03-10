package page;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UiHelpers {
    protected  static WebDriver driver;
    boolean useYaBrowser = false;

    @BeforeEach
    public  void setUpDriverAndData() {
        if (useYaBrowser) {
            // Указываем путь к ChromeDriver версии 142
            System.setProperty("webdriver.chrome.driver", "C:/chromedriver-142.exe");

            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:/Program Files (x86)/Yandex/YandexBrowser/Application/browser.exe");

            // Добавляем дополнительные аргументы для стабильности
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-plugins");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);
        } else {
            driver = new ChromeDriver();
        }

        driver.get(UrlData.URL_MAIN_PAGE);
    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
