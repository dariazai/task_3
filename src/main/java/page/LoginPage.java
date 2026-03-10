package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WaitAndClickHelpers click = new WaitAndClickHelpers();
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
    private final By entrance =By.xpath("//h2[text()='Вход']");

    // Ожидание видимости заголовка "Вход"
    public void waitLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(entrance));
    }

    // Метод нажимает кнопку "Зарегистрироваться"
    public void clickRegister() {
        driver.findElement(register).click();
    }

    //Заполнение поля "Email"
    public void setEmail(String emailData) {
        driver.findElements(field).get(0).sendKeys(emailData);
    }

    //Заполнение поля "Пароль"
    public void setPassword(String passwordData) {
        driver.findElements(field).get(1).sendKeys(passwordData);
    }

    //Кликнуть на кнопку "Войти"
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    // Метод нажимает кнопку "Забыли пароль"
    public void clickFailPassword() {
        driver.findElement(failPassword).click();
    }

    // Метод проверяет что хэдер "Вход" отображается
    public boolean isEntranceDisplayed() {
        return driver.findElement(entrance).isDisplayed();
    }

}
