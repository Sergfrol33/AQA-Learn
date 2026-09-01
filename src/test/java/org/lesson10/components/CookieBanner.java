package org.lesson10.components;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CookieBanner {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cookieSubmitButton = By.xpath("//button[text()='Принять']");
    private final By cookieWrapper = By.cssSelector("div.cookie__wrapper");

    public CookieBanner(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void acceptIfPresent() {
        try {
            var cookieAccept = wait.until(ExpectedConditions.elementToBeClickable(cookieSubmitButton));
            cookieAccept.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(cookieWrapper));
        } catch (TimeoutException ignored) {
            // Баннера нет — ну и ладно
        }
    }
}