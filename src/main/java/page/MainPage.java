package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WaitAndClickHelpers click = new WaitAndClickHelpers();
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка "Личный кабинет"
    private final By personalAccount = By.xpath("//p[text()='Личный Кабинет']");

    //Заголовок "Соберите бургер"
    private final By header = By.xpath("//h1[text()='Соберите бургер']");

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

    @Step("Проверяем, что Конструктор отображается")
    public boolean isHeaderDisplayed() {
        return driver.findElement(header).isDisplayed();
    }

    @Step("Нажимаем на логотип")
    public void clickLogo() {
        click.waitClick(driver.findElement(logo));
    }
}