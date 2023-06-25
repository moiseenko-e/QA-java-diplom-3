package praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    private final By inputEmail = By.xpath("//label[contains(text(),'Email')]/../input"); // проверен
    private final By inputPassword = By.xpath("//input[@type='password']"); // проверен
    private final By enterButton = By.xpath("//*[text()='Войти']"); // проверен
    private final By registerButton = By.xpath("//*[text()='Зарегистрироваться']"); // проверен
    private final By forgotPasswordButton = By.xpath("/html/body/div[1]/div/main/div/div/p[2]/a"); // проверен
    private final By enterGetText = By.xpath("//h2[contains(text(),'Вход')]"); // проверен


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидание видимости заголовка 'Вход'")
    public void expectationEnterText() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(enterGetText));
    }

    @Step("Получить текст заголовка 'Вход'")
    public String getEnterText() {
        return driver.findElement(enterGetText).getText();
    }

    @Step("Заполнить поле 'Email'")
    public void setDataEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    @Step("Заполнить поле 'Пароль'")
    public void setDataPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    @Step("Нажать на кнопку 'Войти'")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    @Step("Нажать на кнопку 'Зарегистрироваться'")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Нажать на кнопку 'Востановить пароль'")
    public void clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }

    @Step("Метод авторизации в личном кабинете")
    public void login(String email, String password) {
        setDataEmail(email);
        setDataPassword(password);
        clickEnterButton();
    }
}
