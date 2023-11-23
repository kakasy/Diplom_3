package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class RegisterPage {

    // Локатор кнопки "Зарегистрироваться"
    private static final By REG_BTN = By.xpath("//button[text()='Зарегистрироваться']");

    // Локатор поля ввода имени
    private static final By NAME_INPUT = By.xpath("//label[text()='Имя']/following::input");

    // Локатор поля ввода email
    private static final By EMAIL_INPUT = By.xpath("//label[text()='Email']/following::input");

    // Локатор поля ввода пароля
    private static final By PASS_INPUT = By.xpath("//input[@type='password']");

    // Локатор ссылки с кнопкой "Войти"
    private static final By LOGIN_LINK = By.xpath("//a[@href='/login']");

    // Локатор сообщения о некорректном пароле
    private final By passwordErrorMessage = By.xpath("//*[text()='Некорректный пароль']");

    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввод имени")
    public void setName(String name) {

        driver.findElement(NAME_INPUT).sendKeys(name);
        waitForLoadingAnimation();
    }

    @Step("Ввод email")
    public void setEmail(String email) {

        driver.findElement(EMAIL_INPUT).sendKeys(email);
        waitForLoadingAnimation();
    }

    @Step("Ввод пароля")
    public void setPassword(String password) {

        driver.findElement(PASS_INPUT).sendKeys(password);
        waitForLoadingAnimation();
    }

    @Step("Нажатие кнопки 'Зарегистрироваться'")
    public void clickRegisterButton() {

        driver.findElement(REG_BTN).click();
        waitForLoadingAnimation();
    }

    @Step("Регистрация пользователя")
    public void registerUser(String name, String email, String password) {

        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterButton();
    }

    @Step("Нажатие ссылки 'Войти'")
    public void clickLoginLink() {
        driver.findElement(LOGIN_LINK).click();

        waitForLoadingAnimation();
    }

    @Step("Проверка некорректного пароля")
    public boolean isErrorMessageVisible() {
        waitForLoadingAnimation();
        return (driver.findElement(passwordErrorMessage).isDisplayed());
    }


    @Step("Ждем загрузки страницы")
    public void waitForLoadingAnimation() {

        ((JavascriptExecutor) driver)
                .executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
    }
}
