package org.lesson10.steps;

import io.qameta.allure.Step;
import org.lesson10.models.PartnerLogoInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class PaymentForm {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By buttonLocator = By.xpath("//button[contains(., 'Оплатить')]");
    private final By titleLocator = By.xpath("//*[@class='pay-description__cost']/span");
    private final By phoneLocator = By.xpath("//*[@class='pay-description__text']/span");
    private final By creditCardLocator = By.xpath("//label[text()='Номер карты']");
    private final By expirationDateLocator = By.xpath("//label[text()='Срок действия']");
    private final By cvcLocator = By.xpath("//label[text()='CVC']");
    private final By cardNameLocator = By.xpath("//label[text()='Имя и фамилия на карте']");
    private final By partnersImgLocator = By.cssSelector("div.cards-brands__container img");
    private final By partnersListLocator = By.className("cards-brands__container");
    private final By appleSvgLocator = By.cssSelector(".apple-pay-button svg");
    private final By googleButtonLocator = By.id("gpay-button-online-api-id");

    public PaymentForm(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Проверить отображение кнопки оплатить")
    public boolean isButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLocator)).isDisplayed();
    }

    @Step("Проверить совпадение суммы в кнопке оплатить")
    public boolean isSameButtonSum(String value) {
        var button = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLocator));
        return button.getText().contains(value);
    }

    @Step("Проверить отображение заголовка")
    public boolean isTitleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator)).isDisplayed();
    }

    @Step("Проверить совпадение суммы в заголовке")
    public boolean isSameTitleSum(String value) {
        var title = wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator));
        return title.getText().contains(value);
    }

    @Step("Проверить совпадение номера телефона")
    public boolean isSamePhone(String value) {
        var title = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneLocator));
        return title.getText().contains(value);
    }

    @Step("Проверить отображение поля кредитной карты")
    public boolean isCreditCardDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(creditCardLocator)).isDisplayed();
    }

    @Step("Проверить отображение поля даты окончания кредитной карты")
    public boolean isExpirationDateDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(expirationDateLocator)).isDisplayed();
    }

    @Step("Проверить отображение поля cvc")
    public boolean isCvcDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cvcLocator)).isDisplayed();
    }

    @Step("Проверить отображение поля Имя и фамилия")
    public boolean isCardNameDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardNameLocator)).isDisplayed();
    }

    @Step("Собираются все логотипы в форме оплаты")
    public List<PartnerLogoInfo> getPartnerLogosInfo() {
        wait.until(ExpectedConditions.presenceOfElementLocated(partnersListLocator));
        List<WebElement> logoElements = driver.findElements(partnersImgLocator);
        return logoElements.stream().map((element) ->
                new PartnerLogoInfo(element.getAttribute("src"), element.isEnabled())).collect(Collectors.toList());
    }

    @Step("Проверить отображение логотипа apple на кнопке оплаты")
    public boolean isAppleSvgDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(appleSvgLocator)).isDisplayed();
    }

    @Step("Проверить отображение логотипа google на кнопке оплаты")
    public String getGoogleImage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(googleButtonLocator)).getCssValue("background-image");
    }
}
