package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WaitAndClickHelpers click = new WaitAndClickHelpers();
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

    //Заполнение поля "Email"
    public void setEmail(String emailData) {
        driver.findElements(field).get(1).sendKeys(emailData);
    }

    //Заполнение поля "Пароль"
    public void setPassword(String passwordData) {
        driver.findElements(field).get(2).sendKeys(passwordData);
    }

    //Кликнуть на кнопку "Зарегистироваться"
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    //Метод проверяет отображение ошибки Некорректный пароль
    public boolean isHeaderDisplayed() {
        return driver.findElement(errorPassword).isDisplayed();
    }
    //Кликнуть на кнопку "Войти"
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
