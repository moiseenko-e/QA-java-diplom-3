package praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private final WebDriver driver;
    public final By accountLink = By.xpath("//*[text()='Профиль']"); // проверен
    public final By historyOfOrdersLink = By.xpath("//*[text()='История заказов']"); // проверен
    public final By exitLink = By.xpath("//*[text()='Выход']"); // проверен
    private final By constructorLink = By.xpath("//*[text()='Конструктор']"); // проверен
    private final By logoStellarBurgersLink = By.className("AppHeader_header__logo__2D0X2"); // проверен


    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Получить текст кнопки 'Профиль'")
    public String getAccountLinkText() {
        return driver.findElement(accountLink).getText();
    }

    @Step("Нажать на кнопку 'Выход'")
    public void clickExitButton() {
        driver.findElement(exitLink).click();
    }

    @Step("Нажать на кнопку 'История заказов'")
    public void clickHistoryOfOrdersButton() {
        driver.findElement(historyOfOrdersLink).click();
    }

    @Step("Нажать на кнопку 'Конструктор'")
    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }

    @Step("Нажать на логотип 'StellarBurgers'")
    public void clickStellarBurgersButton() {
        driver.findElement(logoStellarBurgersLink).click();
    }

    @Step("Ожидание кнопки 'Выход'")
    public void expectationExitButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(exitLink));
    }

    @Step("Ожидание кнопки 'Конструктор'")
    public void expectationConstructorButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(constructorLink));
    }

    @Step("Ожидание лого 'StellarBurgers'")
    public void expectationStellarBurgersButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(logoStellarBurgersLink));
    }

    @Step("Ожидание кнопки 'Профиль'")
    public void expectationAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(accountLink));
    }
}
