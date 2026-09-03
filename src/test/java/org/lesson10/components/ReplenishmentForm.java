package org.lesson10.components;

import io.qameta.allure.Step;
import org.lesson10.models.PartnerLogoInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class ReplenishmentForm {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By titleLocator = By.xpath(
            "//h2[contains(., 'Онлайн пополнение') and contains(., 'без комиссии')]"
    );
    private final By partnerImgLocator = By.cssSelector("div.pay__partners ul li img");
    private final By partnersListLocator = By.cssSelector("div.pay__partners ul");
    private final By linkLocator = By.linkText("Подробнее о сервисе");
    private final By paymentSelectLocator = By.id("pay");
    private final By submitButtonLocator = By.xpath("//form[@id='pay-connection']/button");
    private final By paymentFrameLocator = By.className("payment-widget-iframe");
    private final By connectionPhoneLocator = By.id("connection-phone");
    private final By connectionSumLocator = By.id("connection-sum");
    private final By connectionEmailLocator = By.id("connection-email");

    public ReplenishmentForm(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Выбирается оплата услуги")
    public void selectPaymentType(String value) {
        var select = new Select(driver.findElement(paymentSelectLocator));
        select.selectByValue(value);
    }

    @Step("Проверить отображение заголовка Онлайн пополнение без комиссии")
    public boolean titleIsDisplayed() {
        return driver.findElement(titleLocator).isDisplayed();
    }

    public ReplenishmentForm fillConnectionData(String phone, String sum, String email) {
        fillField(connectionPhoneLocator, phone);
        fillField(connectionSumLocator, sum);
        fillField(connectionEmailLocator, email);
        return this;
    }

    @Step("Кликнуть на ссылку")
    public void clickOnLink(){
        var element = driver.findElement(linkLocator);
        element.click();
    }

    @Step("Берем атрибут {value} из ссылки")
    public String getLinkAttribute(String value){
        return driver.findElement(linkLocator).getAttribute(value);
    }

    @Step("Берем атрибут {attributeName} поля {fieldName} из формы {serviceType}")
    public String getFieldAttribute(String serviceType, String fieldName, String attributeName) {
        By dynamicLocator = By.id(serviceType + "-" + fieldName);
        return driver.findElement(dynamicLocator).getAttribute(attributeName);
    }

    @Step("Клик в форме")
    public void submit() {
        driver.findElement(submitButtonLocator).click();
    }

    @Step("Переключение на форму оплаты")
    public void toggleToPaymentForm(){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrameLocator));
    }

    @Step("Проверить открытие формы оплаты")
    public boolean isOpenPaymentForm() {
        return wait.until(ExpectedConditions.or(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrameLocator),
                ExpectedConditions.urlContains("checkout.bepaid.by")
        ));
    }

    @Step("Заполнить поля в форме")
    private void fillField(By locator, String value) {
        if (value != null) {
            var element = driver.findElement(locator);
            element.clear();
            element.sendKeys(value);
        }
    }

    @Step("Собираются все логотипы в форме заполнения информации")
    public List<PartnerLogoInfo> getPartnerLogosInfo() {
        wait.until(ExpectedConditions.presenceOfElementLocated(partnersListLocator));
        List<WebElement> logoElements = driver.findElements(partnerImgLocator);

        return logoElements.stream()
                .map(element -> new PartnerLogoInfo(
                        element.isDisplayed(),
                        element.getAttribute("alt")
                ))
                .collect(Collectors.toList());
    }
}
