package page;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UiHelpers {
    protected  static WebDriver driver;
    @BeforeEach
    public  void setUpDriverAndData() {
        driver = new ChromeDriver();
        driver.get(UrlData.URL_MAIN_PAGE);
    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
