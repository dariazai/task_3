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
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickConstructorButton();
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickSauces();
        objConstructorPage.clickBun();
        assertTrue(objConstructorPage.isBunSectionDisplayed());
    }

    @Description("Проверка, что после клика на Соусы, отображается соответствующий раздел")
    @Test
    public void transitionToTheSaucesSectionTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickConstructorButton();
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickSauces();
        assertTrue(objConstructorPage.isSaucesSectionDisplayed());
    }

    @Description("Проверка, что после клика на Начинки, отображается соответствующий раздел")
    @Test
    public void transitionToTheFillingsSectionTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickConstructorButton();
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickFillings();
        assertTrue(objConstructorPage.isFillingsSectionDisplayed());
    }
}
