package praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPage {
    private final WebDriver driver;
    private final By resetPasswordButton= By.xpath("//button[contains(text(),'Восстановить пароль')]"); // проверен ?
    private final By enterButton = By.xpath("//*[text()='Войти']"); // проверен
    private final By inputEmail = By.xpath("//label[contains(text(),'Email')]/../input"); // проверен
    private final By recoveryButton = By.xpath("//button[contains(text(),'Восстановить')]"); // проверен

    public RecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на кнопку 'Востановить пароль'")
    public void clickResetPasswordButton(){
        driver.findElement(resetPasswordButton).click();
    }

    @Step("Нажать на кнопку 'Войти'")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    @Step("Заполнить поле 'Email'")
    public void setInputEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    @Step("Нажать на кнопку 'Восстановить'")
    public void clickRecoveryButton(){
        driver.findElement(recoveryButton).click();
    }

    @Step("Метод восстановление пароля")
    public void recoveryPasswordMethod(String email){
        clickResetPasswordButton();
        setInputEmail(email);
        clickRecoveryButton();
    }
}
