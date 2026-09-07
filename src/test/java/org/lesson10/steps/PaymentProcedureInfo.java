package org.lesson10.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentProcedureInfo {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By titleLocator = By.xpath("//span[text()='Порядок оплаты и безопасность интернет платежей']");

    public PaymentProcedureInfo(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isPaymentProcedureInfo() {
        var element = wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator));
        return element.isDisplayed();
    }
}
