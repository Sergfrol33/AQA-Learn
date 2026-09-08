package org.lesson10.pages;

import org.lesson10.steps.PaymentProcedureInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelpPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    public final PaymentProcedureInfo paymentProcedureInfo;

    public HelpPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.paymentProcedureInfo = new PaymentProcedureInfo(driver, wait);
    }

}
