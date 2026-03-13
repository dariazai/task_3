package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    //Информационное сообщение в личном кабинете
    private final By informationMassage = By.xpath("//p[text()='В этом разделе вы можете изменить свои персональные данные']");

    @Step("Ожидание видимости заголовка Выход")
    public void waitLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(exitButton));
    }

    @Step("Нажимаем на кнопку Конструктор")
    public void clickConstructorButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(constructorButton))
                .click();
    }

    @Step("Нажимаем на кнопку Выход")
    public void clickExitButton() {
        click.waitClick(driver.findElement(exitButton));
    }

    @Step("Проверяем, что информационное сообщение в личном кабинете отображается")
    public boolean isInformationMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(informationMassage));
        return element.isDisplayed();
    }
}