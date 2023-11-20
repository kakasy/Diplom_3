package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    private final WebDriver driver;


    // Локатор поля "Email"
    private static final By EMAIL = By.xpath("//input[@name='name']");

    // Локатор поля "Пароль"
    private static final By PASSWORD = By.xpath("//input[@name='Пароль']");

    // Локатор кнопки "Войти"
    private static final By LOGIN_BTN = By.xpath(".//button[text()='Войти']");

    // Локатор ссылки "Зарегистрироваться"
    private static final By REG_LINK = By.xpath(".//a[@href='/register' and text()='Зарегистрироваться']");

    // Локатор ссылки "Восстановить пароль"
    private static final By RESTORE_PASS_LINK = By.xpath(".//a[@href='/forgot-password' and text()='Восстановить пароль']");

    // Локатор начальной страницы
    private static final By LOGIN_PAGE_LOCATOR = By.xpath("//div[@class='Auth_login__3hAey']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввод Email")
    public void setEmail(String email) {

        driver.findElement(EMAIL).sendKeys(email);
    }

    @Step("Ввод пароля")
    public void setPassword(String password) {

        driver.findElement(PASSWORD).sendKeys(password);
    }

    @Step("Клик по кнопке 'Войти'")
    public void clickLoginButton() {

        driver.findElement(LOGIN_BTN).click();

        waitForLoadingAnimation();
    }

    @Step("Клик по ссылке 'Зарегистрироваться'")
    public void clickRegister() {

        driver.findElement(REG_LINK).click();

        waitForLoadingAnimation();
    }

    @Step("Клик по ссылке 'Восстановить пароль'")
    public void clickForgotPasswordLink() {

        driver.findElement(RESTORE_PASS_LINK).click();

        waitForLoadingAnimation();
    }


    @Step("Вход пользователя")
    public void userLogin(String email, String password) {

        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    @Step("Проверка отображения страницы входа")
    public boolean isLoginPageVisible() {

        return (driver.findElement(LOGIN_PAGE_LOCATOR).isDisplayed());
    }

    @Step("Ждем загрузки страницы")
    public void waitForLoadingAnimation() {

        ((JavascriptExecutor) driver)
                .executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
    }
}
