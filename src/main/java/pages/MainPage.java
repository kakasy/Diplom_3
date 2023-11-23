package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;

    // Локатор кнопки "Войти в аккаунт"
    private static final By LOGIN_BTN = By.xpath(".//button[text()='Войти в аккаунт']");

    // Локатор кнопки "Личный кабинет"
    private static final By ACC_BTN = By.xpath(".//a[@href='/account']");

    // Локатор кнопки "Булки"
    private static final By BUNS_BTN = By.xpath(".//div[./span[text()='Булки']]");

    // Локатор кнопки "Соусы"
    private static final By SAUCES_BTN = By.xpath(".//div[./span[text()='Соусы']]");

    // Локатор кнопки "Начинки"
    private static final By FILLINGS_BTN = By.xpath(".//div[./span[text()='Начинки']]");

    // Локатор главной страницы
    private static final By MAIN_PAGE_LOCATOR = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке 'Войти в аккаунт'")
    public void clickLoginButton() {

        driver.findElement(LOGIN_BTN).click();
        waitForLoadingAnimation();
    }

    @Step("Клик по кнопке 'Личный кабинет'")
    public void clickAccountButton() {

        driver.findElement(ACC_BTN).click();
        waitForLoadingAnimation();
    }

    @Step("Клик по кнопке 'Булки'")
    public void clickBunsButton() {

        driver.findElement(BUNS_BTN).click();
        waitForLoadingAnimation();

    }

    @Step("Клик по кнопке 'Соуса'")
    public void clickSaucesButton() {

        driver.findElement(SAUCES_BTN).click();
        waitForLoadingAnimation();
    }

    @Step("Клик по кнопке 'Начинки'")
    public void clickFillingButton() {

        driver.findElement(FILLINGS_BTN).click();
        waitForLoadingAnimation();
    }

    @Step("Получение атрибута класса 'Булки'")
    public String getBunsAttribute() {

        return driver.findElement(BUNS_BTN).getAttribute("class");
    }

    @Step("Получение атрибута класса 'Соусы'")
    public String getSaucesAttribute() {

        return driver.findElement(SAUCES_BTN).getAttribute("class");
    }

    @Step("Получение атрибута класса 'Начинки'")
    public String getFillingsAttribute() {

        return driver.findElement(FILLINGS_BTN).getAttribute("class");
    }

    @Step("Ждем загрузки страницы")
    public void waitForLoadingAnimation() {

        ((JavascriptExecutor) driver)
                .executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
    }

    @Step("Проверка отображения главной страницы")
    public boolean isMainPageVisible() {
        return (driver.findElement(MAIN_PAGE_LOCATOR).isDisplayed());
    }
}
