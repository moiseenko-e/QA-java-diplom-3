package praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;
    private final By inputNewName = By.xpath("//label[contains(text(),'Имя')]/../input"); // проверен
    private final By inputNewEmail = By.xpath("//label[contains(text(),'Email')]/../input"); // проверен
    private final By inputNewPassword = By.xpath("//input[@type='password']"); // проверен
    private final By registerButton = By.xpath("//*[text()='Зарегистрироваться']"); // проверен
    private final By loginButton = By.xpath("//*[text()='Войти']"); // проверен
    private final By errorText = By.xpath("//*[text()='Некорректный пароль']"); // проверен

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнить поле 'Имя'")
    public void setInputNewName(String name) {
        driver.findElement(inputNewName).sendKeys(name);
    }

    @Step("Заполнить поле 'Email'")
    public void setInputNewEmail(String email) {
        driver.findElement(inputNewEmail).sendKeys(email);
    }

    @Step("Заполнить поле 'Пароль'")
    public void setInputNewPassword(String password) {
        driver.findElement(inputNewPassword).sendKeys(password);
    }

    @Step("Нажать на кнопку 'Зарегистрироваться'")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Нажать на кнопку 'Войти'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Получить текст ошибки 'Некорректный пароль'")
    public String getErrorText() {
        return driver.findElement(errorText).getText();
    }

    @Step("Метод регистрации нового пользователя")
    public void registrationMethod(String name, String email, String password) {
        setInputNewName(name);
        setInputNewEmail(email);
        setInputNewPassword(password);
        clickRegisterButton();
    }
}
