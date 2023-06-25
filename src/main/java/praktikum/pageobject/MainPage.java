package praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final By personalAccountButton = By.xpath("/html/body/div/div/header/nav/a/p"); // проверен
    private final By logInYourAccountButton = By.xpath("//button[contains(text(),'Войти в аккаунт')]"); // проверен
    private final By orderFeedButton = By.xpath("//p[contains(text(),'Лента Заказов')]"); // проверен
    private final By constructorLink = By.xpath("//*[text()='Конструктор']"); // проверен
    private final By bunButton = By.xpath("//span[contains(text(),'Булки')]"); // проверен
    private final By sauceButton = By.xpath("//span[contains(text(),'Соусы')]"); // проверен
    private final By fillingButton = By.xpath("//span[contains(text(),'Начинки')]"); // проверен
    private final By designerText =By.xpath("//*[text()='Соберите бургер']"); // проверен
    private final By bunHeaderText = By.xpath("//h2[contains(text(),'Булки')]"); // проверен
    private final By sauceHeaderText = By.xpath("//h2[contains(text(),'Соусы')]"); // проверен
    private final By fillingHeaderText = By.xpath("//h2[contains(text(),'Начинки')]"); // проверен


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на кнопку 'Личный кабинет'")
    public void clickPersonalAccountButton(){
        driver.findElement(personalAccountButton).click();
    }

    @Step("Нажать на кнопку 'Войти в аккаунт'")
    public void clickLogInYourAccountButton(){
        driver.findElement(logInYourAccountButton).click();
    }

    @Step("Нажать на кнопку 'Лента заказов'")
    public void clickOrderFeedButton(){
        driver.findElement(orderFeedButton).click();
    }

    @Step("Нажать на кнопку 'Конструктор'")
    public void clickConstructorLink(){
        driver.findElement(constructorLink).click();
    }

    @Step("Нажать на таб 'Булки'")
    public void clickBunButton(){
        driver.findElement(bunButton).click();
    }

    @Step("Нажать на таб 'Соусы'")
    public void clickSauceButton(){
        driver.findElement(sauceButton).click();
    }

    @Step("Нажать на таб 'Начинки'")
    public void clickFillingButton(){
        driver.findElement(fillingButton).click();
    }

    @Step("Получить текст 'Соберите бургер'")
    public String getDesignerText(){
        return driver.findElement(designerText).getText();
    }

    @Step("Получить текст 'Булки'")
    public String getBunText(){
        return driver.findElement(bunHeaderText).getText();
    }
    @Step("Получить текст 'Соусы'")
    public String getSauceText(){
        return driver.findElement(sauceHeaderText).getText();
    }

    @Step("Получить текст 'Начинки'")
    public String getFillingText(){
        return driver.findElement(fillingHeaderText).getText();
    }

    @Step("Ожидание кнопки 'Личный Кабинет'")
    public void expectationPersonalAccount(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(personalAccountButton));
    }
}
