package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPage {
    WaitAndClickHelpers click = new WaitAndClickHelpers();
    private final WebDriver driver;
    public ForgotPage(WebDriver driver) {
        this.driver = driver;
    }

    //кнопка "Войти"
    private final By enter = By.className("Auth_link__1fOlj");

    // Метод нажимает кнопку "Войти"
    public void clickEnterButton() {
        driver.findElement(enter).click();
    }
}
