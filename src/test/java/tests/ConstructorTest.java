package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static generator.DriverConfig.createDriver;
import static org.hamcrest.core.StringContains.containsString;

public class ConstructorTest {

    private WebDriver driver;

    @Before
    public void startUp() {
        driver = createDriver();
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/");

    }

    @DisplayName("Переход к разделу 'Булки'")
    @Description("Кнопка перехода в секцию Булки должна быть активной")
    @Test
    public void bunTabTest() {

        MainPage mainPage = new MainPage(driver);

        mainPage.clickFillingButton();
        mainPage.clickBunsButton();
        MatcherAssert.assertThat("Ошибка перехода", mainPage.getBunsAttribute(), containsString("current"));
    }

    @DisplayName("Переход к разделу 'Соусы'")
    @Description("Кнопка перехода в секцию Соусы должна быть активной")
    @Test
    public void souseTabTest() {

        MainPage mainPage = new MainPage(driver);

        mainPage.clickSaucesButton();
        MatcherAssert.assertThat("Ошибка перехода", mainPage.getSaucesAttribute(), containsString("current"));
    }

    @DisplayName("Переход к разделу 'Начинки'")
    @Description("Кнопка перехода в секцию Начинки должна быть активной")
    @Test
    public void fillingTabTest() {

        MainPage mainPage = new MainPage(driver);

        mainPage.clickFillingButton();
        MatcherAssert.assertThat("Ошибка перехода", mainPage.getFillingsAttribute(), containsString("current"));
    }


    @After
    public void teardown() {
        driver.quit();
    }
}
