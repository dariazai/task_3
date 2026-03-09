package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    WaitAndClickHelpers click = new WaitAndClickHelpers();
    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка "Конструктор"
    private final By constructorButton =By.xpath("//button[text()='Конструктор']");

    //метод нажимает кнопку "Конструктор"
    public void clickConstructorButton() {
        click.waitClick(driver.findElement(constructorButton));
    }
}
