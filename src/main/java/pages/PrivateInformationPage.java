package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class PrivateInformationPage {

    private final WebDriver driver;

    // Локатор кнопки Выход
    private static final By LOGOUT_BTN = By.xpath("//button[text()='Выход']");

    // Локатор кнопки Конструктор
    private static final By CONSTRUCTOR_BTN = By.xpath("//p[contains(text(),'Конструктор')]");

    // Локатор логотипа Stellar Burgers
    private static final By LOGO = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");

    // Локатор блока с личной информацией
    private static final By PERSONAL_PAGE_LOCATOR = By.xpath("//div[@class='Account_account__vgk_w']");


    public PrivateInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатие на кнопку Выход")
    public void clickLogOutButton() {

        driver.findElement(LOGOUT_BTN).click();
        waitForLoadingAnimation();
    }


    @Step("Нажатие на кнопку Конструктор")
    public void clickConstructorButton() {

        driver.findElement(CONSTRUCTOR_BTN).click();
        waitForLoadingAnimation();
    }

    @Step("Нажатие на логотип")
    public void clickLogo() {
        driver.findElement(LOGO).click();
    }

    @Step("Проверка отображения личной страницы")
    public boolean isPersonalPageVisible() {

        waitForLoadingAnimation();
        return (driver.findElement(PERSONAL_PAGE_LOCATOR).isDisplayed());

    }

    @Step("Ждем загрузки страницы")
    public void waitForLoadingAnimation() {

        ((JavascriptExecutor) driver)
                .executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
    }

}
