package org.lesson9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты страницы")
public class PageTest extends BaseTest {

    private WebDriverWait wait;

    @BeforeEach
    void openPage() {
        driver.get("https://www.mts.by");
        var duration = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, duration.getSeconds());
    }

    @DisplayName("Проверяем открытие сайта")
    @Test
    public void checkIsOpen() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")
                .equals("complete"));
    }

    @DisplayName("Проверяем наличие блока пополнения")
    @Test
    public void searchBlockTitle() {
        By title = By.xpath(
                "//h2[contains(., 'Онлайн пополнение') and contains(., 'без комиссии')]"
        );
        driver.findElement(title);
    }

    @DisplayName("Проверяем наличие alt логотипов платежных систем")
    @Test
    public void altTitlePayPartnersAreVisible() {
        var expectedPartners = List.of("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");
        var items = driver.findElements(By.cssSelector("div.pay__partners ul li img"));
        var actualAlts = items.stream()
                .map(img -> img.getAttribute("alt"))
                .collect(Collectors.toList());
        assertAll(() -> assertEquals(expectedPartners.size(), items.size(), "Количество партнеров не совпадает"),
                () -> assertTrue(actualAlts.containsAll(expectedPartners),
                        "Ожидалось: " + expectedPartners + ", найдено: " + actualAlts));
    }

    @DisplayName("Проверяем видимость логотипов платежных систем")
    @Test
    public void allPartnersAreVisible() {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("div.pay__partners ul")
        ));
        var logos = driver.findElements(By.cssSelector("div.pay__partners ul li img"));
        assertFalse(logos.isEmpty());
        for (WebElement logo : logos) {
            var alt = logo.getAttribute("alt");
            assertTrue(logo.isDisplayed(), "Логотип не виден:" + alt);
            assertFalse(alt.isBlank(), "У логотипа пустой alt");
        }
    }

    @DisplayName("Проверяем ссылку 'Подробнее о сервисе'")
    @Test
    public void checkLinkHref() {
        var link = driver.findElement(By.linkText("Подробнее о сервисе"));
        var href = link.getAttribute("href");

        assertTrue(href.contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    @DisplayName("Проверяем ссылку 'Подробнее о сервисе'")
    @Test
    public void checkIsLinkClickable() {
        clickCookies(wait);
        var link = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.pay__wrapper a")));
        link.click();
        wait.until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey"));
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @DisplayName("Проверяем валидный инпут формы")
    @Test
    public void checkInputValues() {
        clickCookies(wait);
        var phoneInput = driver.findElement(By.id("connection-phone"));
        var sumInput = driver.findElement(By.id("connection-sum"));
        var emailInput = driver.findElement(By.id("connection-email"));
        phoneInput.clear();
        sumInput.clear();
        emailInput.clear();
        phoneInput.sendKeys("297777777");
        sumInput.sendKeys("100");
        emailInput.sendKeys("sergfrol33@gmail.com");
        var sumValue = sumInput.getAttribute("value");
        var phoneValue = phoneInput.getAttribute("value");
        var emailValue = emailInput.getAttribute("value");
        assertEquals("100", sumValue);
        assertEquals("sergfrol33@gmail.com", emailValue);
        assertEquals("(29)777-77-77", phoneValue);
    }

    @DisplayName("Проверяем открытие модалки")
    @Test
    public void checkFormSubmit() {
        clickCookies(wait);
        var phoneInput = driver.findElement(By.id("connection-phone"));
        var sumInput = driver.findElement(By.id("connection-sum"));
        var emailInput = driver.findElement(By.id("connection-email"));
        var submitButton = driver.findElement(By.xpath("//form[@id='pay-connection']/button"));
        phoneInput.clear();
        sumInput.clear();
        emailInput.clear();
        phoneInput.sendKeys("297777777");
        sumInput.sendKeys("100");
        emailInput.sendKeys("sergfrol33@gmail.com");
        submitButton.click();
        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("iframe.payment-widget-iframe")
                )
        );


    }
}
