import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import page.ConstructorPage;
import page.MainPage;
import page.UiHelpers;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConstructorTransitionTest extends UiHelpers {

    @Description("Проверка, что после клика на Булки, отображается соответствующий раздел")
    @Test
    public void transitionToTheBunsSectionTest() {
        clickConstruction();
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickSauces();
        objConstructorPage.clickBun();
        assertTrue(objConstructorPage.isBunSectionDisplayed());
    }

    @Description("Проверка, что после клика на Соусы, отображается соответствующий раздел")
    @Test
    public void transitionToTheSaucesSectionTest() {
        clickConstruction();
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickSauces();
        assertTrue(objConstructorPage.isSaucesSectionDisplayed());
    }

    @Description("Проверка, что после клика на Начинки, отображается соответствующий раздел")
    @Test
    public void transitionToTheFillingsSectionTest() {
        clickConstruction();
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickFillings();
        assertTrue(objConstructorPage.isFillingsSectionDisplayed());
    }
    @Step ("Нажимаем на кнопку конструктора")
    public void clickConstruction(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickConstructorButton();
    }
}
