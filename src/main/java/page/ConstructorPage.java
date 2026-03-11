package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class ConstructorPage {
    WaitAndClickHelpers click = new WaitAndClickHelpers();
    private final WebDriver driver;

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка "Булки
    private final By bun = By.xpath("//div[contains(@class,'tab_tab')][.//span[text()='Булки']]");

    //Кнопка "Соусы"
    private final By sauce = By.xpath("//span[text()='Соусы']");

    //Кнопка "Начинки"
    private final By fillings = By.xpath("//span[text()='Начинки']");

    //Заголовок "Соусы"
    private final By saucesSection = By.xpath("//span[text()='Соусы']/parent::*[contains(@class,'current')]");

    //Заголовок "Булки"
    private final By bunSection = By.xpath("//span[text()='Булки']/parent::*");

    //Заголовок "Начинки"
    private final By fillingsSection = By.xpath("//span[text()='Начинки']/parent::*[contains(@class,'current')]");

    @Step("Кликнуть на кнопку Булки")
    public void clickBun() {
        click.waitClick(driver.findElement(bun));
    }

    @Step("Кликнуть на кнопку Соус")
    public void clickSauces() {
        click.waitClick(driver.findElement(sauce));
    }

    @Step("Кликнуть на кнопку Начинки")
    public void clickFillings() {
        click.waitClick(driver.findElement(fillings));
    }

    @Step("Проверка, что раздел Соусы активен")
    public boolean isSaucesSectionDisplayed() {
        return driver.findElement(saucesSection).isDisplayed();
    }

    @Step("Проверка, что раздел Булки активен")
    public boolean isBunSectionDisplayed() {
        return driver.findElement(bunSection).isDisplayed();
    }

    @Step("Проверка, что раздел Булки активен")
    public boolean isFillingsSectionDisplayed() {
        return driver.findElement(fillingsSection).isDisplayed();
    }
}