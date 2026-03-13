package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WaitAndClickHelpers click = new WaitAndClickHelpers();
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка "Личный кабинет"
    private final By personalAccount = By.xpath("//p[text()='Личный Кабинет']");

    //Заголовок "Соберите бургер"
    private final By headerCollectBurger = By.xpath("//h1[text()='Соберите бургер']");

    //Кнопка "Оформить заказ"
    private final By buttonCreateOrder = By.xpath("//button[text()='Оформить заказ']");

    //Кнопка "Войти в аккаунт"
    private final By entranceInAccount = By.xpath("//button[text()='Войти в аккаунт']");

    //Кнопка "Конструктор"
    private final By constructorButton = By.xpath("//p[text()='Конструктор']");

    //Логотип сайта
    private final By logo = By.cssSelector("svg");

    @Step("Нажимаем на кнопку личный кабинет")
    public void clickPersonalAccount() {
        click.waitClick(driver.findElement(personalAccount));
    }

    @Step("Нажимаем на кнопку Войти в аккаунт")
    public void clickEntranceInAccount() {
        click.waitClick(driver.findElement(entranceInAccount));
    }

    @Step("Нажимаем на кнопку Конструктор")
    public void clickConstructorButton() {
        click.waitClick(driver.findElement(constructorButton));
    }

    @Step("Проверяем, что кнопка Оформить заказ отображается")
    public boolean isCreateButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(buttonCreateOrder));
        return element.isDisplayed();
    }

    @Step("Проверяем, что заголовок Соберите бургер отображается")
    public boolean isHeaderCollectBurgerDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(headerCollectBurger));
        return element.isDisplayed();
    }

    @Step("Нажимаем на логотип")
    public void clickLogo() {
        click.waitClick(driver.findElement(logo));
    }
}