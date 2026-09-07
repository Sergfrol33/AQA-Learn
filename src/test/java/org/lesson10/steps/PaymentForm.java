package org.lesson10.steps;

import org.lesson10.models.PartnerLogoInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class PaymentForm {
    public final WebDriver driver;
    public final WebDriverWait wait;
    public final By buttonLocator = By.xpath("//button[contains(., 'Оплатить')]");
    public final By titleLocator = By.xpath("//*[@class='pay-description__cost']/span");
    public final By phoneLocator = By.xpath("//*[@class='pay-description__text']/span");
    public final By creditCardLocator = By.xpath("//label[text()='Номер карты']");
    public final By expirationDateLocator = By.xpath("//label[text()='Срок действия']");
    public final By cvcLocator = By.xpath("//label[text()='CVC']");
    public final By cardNameLocator = By.xpath("//label[text()='Имя и фамилия на карте']");
    public final By partnersImgLocator = By.cssSelector("div.cards-brands__container img");
    public final By partnersListLocator = By.className("cards-brands__container");
    public final By appleSvgLocator = By.cssSelector(".apple-pay-button svg");
    public final By googleButtonLocator = By.id("gpay-button-online-api-id");

    public PaymentForm(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLocator)).isDisplayed();
    }

    public boolean isSameButtonSum(String value) {
        var button = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLocator));
        return button.getText().contains(value);
    }

    public boolean isTitleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator)).isDisplayed();
    }

    public boolean isSameTitleSum(String value) {
        var title = wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator));
        return title.getText().contains(value);
    }

    public boolean isSamePhone(String value) {
        var title = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneLocator));
        return title.getText().contains(value);
    }

    public boolean isCreditCardDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(creditCardLocator)).isDisplayed();
    }

    public boolean isExpirationDateDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(expirationDateLocator)).isDisplayed();
    }

    public boolean isCvcDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cvcLocator)).isDisplayed();
    }

    public boolean isCardNameDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardNameLocator)).isDisplayed();
    }

    public List<PartnerLogoInfo> getPartnerLogosInfo() {
        wait.until(ExpectedConditions.presenceOfElementLocated(partnersListLocator));
        List<WebElement> logoElements = driver.findElements(partnersImgLocator);
        return logoElements.stream().map((element) ->
                new PartnerLogoInfo(element.getAttribute("src"), element.isEnabled())).collect(Collectors.toList());
    }

    public boolean isAppleSvgDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(appleSvgLocator)).isDisplayed();
    }
    public String getGoogleImage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(googleButtonLocator)).getCssValue("background-image");
    }
}
