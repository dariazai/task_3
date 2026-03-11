package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Поле с данными для регистрации (Имя, email, пароль)
    private final By field = By.cssSelector(".input__container .input__textfield");

    //Кнопка "Зарегистрироваться"
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");

    //Ошибка "Некорректный пароль"
    private final By errorPassword = By.xpath("//p[text()='Некорректный пароль']");

    //Кнопка "Войти"
    private final By loginButton = By.className("Auth_link__1fOlj");

    //Заполнение поля "Имя"
    public void setField(String nameData) {
        driver.findElements(field).get(0).sendKeys(nameData);
    }

    @Step("Заполняем поле email")
    public void setEmail(String emailData) {
        driver.findElements(field).get(1).sendKeys(emailData);
    }

    @Step("Заполняем поле пароль")
    public void setPassword(String passwordData) {
        driver.findElements(field).get(2).sendKeys(passwordData);
    }

    @Step("Кликаем на кнопку Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Проверяем отображение ошибки")
    public boolean isHeaderDisplayed() {
        return driver.findElement(errorPassword).isDisplayed();
    }

    @Step("Кликаем на кнопку Войти")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
