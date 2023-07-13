package praktikum.pageobject;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class MainPage {
    private final WebDriver driver;
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By logInYourAccountButton = By.xpath("//button[contains(text(),'Войти в аккаунт')]");
    private final By orderFeedButton = By.xpath("//p[contains(text(),'Лента Заказов')]");
    private final By constructorLink = By.xpath("//*[text()='Конструктор']");
    private final By bunButton = By.xpath("//span[text()='Булки']//parent::div");
    private final By sauceButton = By.xpath("//span[text()='Соусы']//parent::div");
    private final By fillingButton = By.xpath("//span[text()='Начинки']//parent::div");
    private final By designerText =By.xpath("//*[text()='Соберите бургер']");
    private final String ATTRIBUTE_IF_TAB_SELECTED = "tab_tab_type_current";

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


    // вынесены методы получения элемента, если селект выбран, и проверки, что в локаторе есть "tab_tab_type_current"
   @Step("Проверка, что у текущего элемента 'Булки' есть в локаторе атрибут 'tab_tab_type_current'")
    public void getAndCheckAttributeValueIfTabBunsSelected() {
       MatcherAssert.assertThat(driver.findElement(bunButton)
               .getAttribute("class"),containsString(ATTRIBUTE_IF_TAB_SELECTED));
   }

    @Step("Проверка, что у текущего элемента 'Соусы' есть в локаторе атрибут 'tab_tab_type_current'")
    public void getAndCheckAttributeValueIfTabSauceSelected() {
        MatcherAssert.assertThat(driver.findElement(sauceButton)
                .getAttribute("class"),containsString(ATTRIBUTE_IF_TAB_SELECTED));
    }

    @Step("Проверка, что у текущего элемента 'Начинки' есть в локаторе атрибут 'tab_tab_type_current'")
    public void getAndCheckAttributeValueIfTabFillingsSelected() {
        MatcherAssert.assertThat(driver.findElement(fillingButton)
                .getAttribute("class"),containsString(ATTRIBUTE_IF_TAB_SELECTED));
    }

   // добавила методы для проверки, что таб не выбран
   @Step("Проверка, что таб 'Булки' не выбран")
   public void checkBunIsNotSelected() {
       MatcherAssert.assertThat(driver.findElement(bunButton)
               .getAttribute("class"), not(containsString(ATTRIBUTE_IF_TAB_SELECTED)));
   }

    @Step("Проверка, что таб 'Соусы' не выбран")
    public void checkSauceIsNotSelected() {
        MatcherAssert.assertThat(driver.findElement(sauceButton)
                .getAttribute("class"), not(containsString(ATTRIBUTE_IF_TAB_SELECTED)));
    }

    @Step("Проверка, что таб 'Начинки' не выбран")
    public void checkFillingIsNotSelected() {
        MatcherAssert.assertThat(driver.findElement(fillingButton)
                .getAttribute("class"), not(containsString(ATTRIBUTE_IF_TAB_SELECTED)));
    }


    @Step("Ожидание кнопки 'Личный Кабинет'")
    public void expectationPersonalAccount(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .elementToBeClickable(personalAccountButton));
    }
}
