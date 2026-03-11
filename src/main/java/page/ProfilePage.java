package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    WaitAndClickHelpers click = new WaitAndClickHelpers();
    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка "Конструктор"
    private final By constructorButton = By.xpath("//p[text()='Конструктор']");

    //Кнопка "Конструктор"
    private final By exitButton = By.xpath("//button[text()='Выход']");

    // Ожидание видимости заголовка "Выход"
    public void waitLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(exitButton));
    }

    //Метод нажимает кнопку "Конструктор"
    public void clickConstructorButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(constructorButton))
                .click();
    }

    //Метод нажимает кнопку "Выход"
    public void clickExitButton() {
        click.waitClick(driver.findElement(exitButton));
    }
}
