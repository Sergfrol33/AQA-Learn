package org.lesson10.pages;

import org.lesson10.steps.CookieBanner;
import org.lesson10.steps.PaymentForm;
import org.lesson10.steps.ReplenishmentForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public final ReplenishmentForm replenishmentForm;
    public final CookieBanner cookieBanner;
    public final PaymentForm paymentForm;

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.replenishmentForm = new ReplenishmentForm(driver, wait);
        this.cookieBanner = new CookieBanner(driver, wait);
        this.paymentForm = new PaymentForm(driver, wait);
    }

}
