package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //кнопка "Зарегистрироваться"
    private final By register = By.className("Auth_link__1fOlj");

    //Поле с данными для входа (email, пароль)
    private final By field = By.cssSelector(".input__container .input__textfield");

    //Кнопка "Войти"
    private final By enterButton = By.xpath("//button[text()='Войти']");

    //Кнопка "Забыли пароль"
    private final By failPassword = By.className("Auth_link__1fOlj");

    //Заголовок "Вход"
    private final By entrance = By.xpath("//h2[text()='Вход']");

    @Step("Ожидание видимости заголовка Вход")
    public void waitLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(entrance));
    }

    @Step("Нажимаем на кнопку Зарегистрироваться")
    public void clickRegister() {
        driver.findElement(register).click();
    }

    @Step("Заполняем поле Email")
    public void setEmail(String emailData) {
        driver.findElements(field).get(0).sendKeys(emailData);
    }

    @Step("Заполняем поле Пароль")
    public void setPassword(String passwordData) {
        driver.findElements(field).get(1).sendKeys(passwordData);
    }

    @Step("Нажимаем на кнопку Войти")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    @Step("Нажимаем на кнопку Забыли пароль")
    public void clickFailPassword() {
        driver.findElement(failPassword).click();
    }

    @Step("Проверяем, что что хэдер \"Вход\" отображается")
    public boolean isEntranceDisplayed() {
        return driver.findElement(entrance).isDisplayed();
    }
}