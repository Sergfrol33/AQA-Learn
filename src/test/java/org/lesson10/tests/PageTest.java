package org.lesson10.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.lesson10.base.BaseTest;
import org.lesson10.models.PartnerLogoInfo;
import org.lesson10.pages.MainPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты страницы")
public class PageTest extends BaseTest {

    private WebDriverWait wait;
    private MainPage mainPage;

    @BeforeEach
    void openPage() {
        driver.get("https://www.mts.by");
        var duration = Duration.ofSeconds(20);
        wait = new WebDriverWait(driver, duration);
        mainPage = new MainPage(driver, wait);
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
        assertTrue(mainPage.replenishmentForm.titleIsDisplayed(), "Блок не отображается");
    }

    @DisplayName("Проверяем количество alt логотипов платежных систем")
    @Test
    public void altTitlePayPartnersAreVisible() {
        var expectedPartners = List.of("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");
        var items = mainPage.replenishmentForm.getPartnerLogosInfo();
        var actualAlts = items.stream()
                .map(PartnerLogoInfo::getAltText)
                .toList();
        assertAll(() -> assertEquals(expectedPartners.size(), items.size(), "Количество партнеров не совпадает"),
                () -> assertTrue(actualAlts.containsAll(expectedPartners),
                        "Ожидалось: " + expectedPartners + ", найдено: " + actualAlts));
    }

    @DisplayName("Проверяем видимость логотипов платежных систем")
    @Test
    public void allPartnersAreVisible() {
        var logos = mainPage.replenishmentForm.getPartnerLogosInfo();
        assertFalse(logos.isEmpty());
        for (PartnerLogoInfo logo : logos) {
            var alt = logo.getAltText();
            assertTrue(logo.isDisplayed(), "Логотип не виден:" + alt);
            assertFalse(alt.isBlank(), "У логотипа пустой alt");
        }
    }

    @DisplayName("Проверяем ссылку 'Подробнее о сервисе'")
    @Test
    public void checkLinkHref() {
        var href = mainPage.replenishmentForm.getLinkAttribute("href");
        assertTrue(href.contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    @DisplayName("Проверяем ссылку 'Подробнее о сервисе'")
    @Test
    public void checkIsLinkClickable() {
        mainPage.cookieBanner.acceptIfPresent();
        mainPage.replenishmentForm.clickOnLink();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @DisplayName("Проверяем валидный инпут формы")
    @Test
    public void checkInputValues() {
        mainPage.cookieBanner.acceptIfPresent();
        mainPage.replenishmentForm.fillConnectionData("297777777", "100", "sergfrol33@gmail.com");
        var sumValue = mainPage.replenishmentForm.getFieldAttribute("connection", "sum", "value");
        var phoneValue = mainPage.replenishmentForm.getFieldAttribute("connection", "phone", "value");
        var emailValue = mainPage.replenishmentForm.getFieldAttribute("connection", "email", "value");
        assertEquals("100", sumValue);
        assertEquals("sergfrol33@gmail.com", emailValue);
        assertEquals("(29)777-77-77", phoneValue);
    }

    @DisplayName("Проверяем открытие модалки")
    @Test
    public void checkFormSubmit() {
        mainPage.cookieBanner.acceptIfPresent();
        mainPage.replenishmentForm.fillConnectionData("297777777", "100", "sergfrol33@gmail.com").submit();
        var isPaymentOpened = mainPage.replenishmentForm.isOpenPaymentForm();
        assertTrue(isPaymentOpened, "Окно оплаты не открылось");
    }

    @DisplayName("Проверяем плейсхолдеры Услуг связи")
    @Test
    public void checkConnectionPlaceholders() {
        var sumPlaceholder = mainPage.replenishmentForm
                .getFieldAttribute("connection", "sum", "placeholder");
        var phonePlaceholder = mainPage.replenishmentForm
                .getFieldAttribute("connection", "phone", "placeholder");
        var emailPlaceholder = mainPage.replenishmentForm.
                getFieldAttribute("connection", "email", "placeholder");

        assertAll(
                () -> assertEquals("Номер телефона", phonePlaceholder),
                () -> assertEquals("Сумма", sumPlaceholder),
                () -> assertEquals("E-mail для отправки чека", emailPlaceholder)
        );
    }

    @DisplayName("Проверяем плейсхолдеры Домашний интернет")
    @Test
    public void checkInternetPlaceholders() {
        mainPage.replenishmentForm.selectPaymentType("Домашний интернет");
        var sumPlaceholder = mainPage.replenishmentForm
                .getFieldAttribute("internet", "sum", "placeholder");
        var phonePlaceholder = mainPage.replenishmentForm
                .getFieldAttribute("internet", "phone", "placeholder");
        var emailPlaceholder = mainPage.replenishmentForm.
                getFieldAttribute("internet", "email", "placeholder");

        assertAll(
                () -> assertEquals("Номер абонента", phonePlaceholder),
                () -> assertEquals("Сумма", sumPlaceholder),
                () -> assertEquals("E-mail для отправки чека", emailPlaceholder)
        );
    }

    @DisplayName("Проверяем плейсхолдеры Рассрочка")
    @Test
    public void checkInstalmentPlaceholders() {
        mainPage.replenishmentForm.selectPaymentType("Рассрочка");
        var scorePlaceholder = mainPage.replenishmentForm
                .getFieldAttribute("score", "instalment", "placeholder");
        var sumPlaceholder = mainPage.replenishmentForm
                .getFieldAttribute("instalment", "sum", "placeholder");
        var emailPlaceholder = mainPage.replenishmentForm.
                getFieldAttribute("instalment", "email", "placeholder");

        assertAll(
                () -> assertEquals("Номер счета на 44", scorePlaceholder),
                () -> assertEquals("Сумма", sumPlaceholder),
                () -> assertEquals("E-mail для отправки чека", emailPlaceholder)
        );
    }

    @DisplayName("Проверяем плейсхолдеры Задолженность")
    @Test
    public void checkArrearsPlaceholders() {
        mainPage.replenishmentForm.selectPaymentType("Задолженность");
        var scorePlaceholder = mainPage.replenishmentForm
                .getFieldAttribute("score", "arrears", "placeholder");
        var sumPlaceholder = mainPage.replenishmentForm
                .getFieldAttribute("arrears", "sum", "placeholder");
        var emailPlaceholder = mainPage.replenishmentForm.
                getFieldAttribute("arrears", "email", "placeholder");

        assertAll(
                () -> assertEquals("Номер счета на 2073", scorePlaceholder),
                () -> assertEquals("Сумма", sumPlaceholder),
                () -> assertEquals("E-mail для отправки чека", emailPlaceholder)
        );
    }

    @DisplayName("Проверяем наличие кнопки формы оплаты")
    @Test
    public void isFrameButtonDisplayed() {
        mainPage.cookieBanner.acceptIfPresent();
        mainPage.replenishmentForm.fillConnectionData("297777777", "100", "sergfrol33@gmail.com").submit();
        mainPage.replenishmentForm.toggleToPaymentForm();

        assertTrue(mainPage.paymentForm.isButtonDisplayed(), "Кнопка не отображается");
    }

    @DisplayName("Проверяем сумму в кнопке формы оплаты")
    @Test
    public void checkFrameButtonSum() {
        mainPage.cookieBanner.acceptIfPresent();
        mainPage.replenishmentForm.fillConnectionData("297777777", "100", "sergfrol33@gmail.com").submit();
        mainPage.replenishmentForm.toggleToPaymentForm();

        assertTrue(mainPage.paymentForm.isSameButtonSum("100.00"),
                "Текст кнопки не содержит введенную сумму:" + "100.00");
    }

    @DisplayName("Проверяем наличие заголовка формы оплаты")
    @Test
    public void isFrameTitleDisplayed() {
        mainPage.cookieBanner.acceptIfPresent();
        mainPage.replenishmentForm.fillConnectionData("297777777", "100", "sergfrol33@gmail.com").submit();
        mainPage.replenishmentForm.toggleToPaymentForm();

        assertTrue(mainPage.paymentForm.isTitleDisplayed(), "Заголовок не отображается");
    }

    @DisplayName("Проверяем сумму в заголовке формы оплаты")
    @Test
    public void checkFrameTitleSum() {
        mainPage.cookieBanner.acceptIfPresent();
        mainPage.replenishmentForm.fillConnectionData("297777777", "100", "sergfrol33@gmail.com").submit();
        mainPage.replenishmentForm.toggleToPaymentForm();

        assertTrue(mainPage.paymentForm.isSameTitleSum("100.00"),
                "Текст заголовка не содержит введенную сумму:" + "100.00");
    }

    @DisplayName("Проверяем телефон формы оплаты")
    @Test
    public void isSameFramePhoneNumber() {
        mainPage.cookieBanner.acceptIfPresent();
        mainPage.replenishmentForm.fillConnectionData("297777777", "100", "sergfrol33@gmail.com").submit();
        mainPage.replenishmentForm.toggleToPaymentForm();

        assertTrue(mainPage.paymentForm.isSamePhone("297777777"),
                "Телефон заголовка не совпадает с веденным номером");
    }

    @DisplayName("Проверяем отображение полей формы оплаты")
    @Test
    public void isFrameFieldsDisplayed() {
        mainPage.cookieBanner.acceptIfPresent();
        mainPage.replenishmentForm.fillConnectionData("297777777", "100", "sergfrol33@gmail.com").submit();
        mainPage.replenishmentForm.toggleToPaymentForm();

        assertAll(
                () -> assertTrue(mainPage.paymentForm.isCreditCardDisplayed(),
                        "Поле кредитной карты не отображается"),
                () -> assertTrue(mainPage.paymentForm.isExpirationDateDisplayed(),
                        "Поле срока действия не отображается"),
                () -> assertTrue(mainPage.paymentForm.isCvcDisplayed(),
                        "Поле cvc не отображается"),
                () -> assertTrue(mainPage.paymentForm.isCardNameDisplayed(),
                        "Поле Имя и фамилия на карте не отображается")
        );
    }

    @DisplayName("Проверяем видимость логотипов платежных систем в форме оплаты")
    @Test
    public void allPartnersImagesVisiblePaymentForm() {
        mainPage.cookieBanner.acceptIfPresent();
        mainPage.replenishmentForm.fillConnectionData("297777777", "100", "sergfrol33@gmail.com").submit();
        mainPage.replenishmentForm.toggleToPaymentForm();
        var logos = mainPage.paymentForm.getPartnerLogosInfo();
        assertFalse(logos.isEmpty());
        for (PartnerLogoInfo logo : logos) {
            assertTrue(logo.isDisplayed(), "Логотип не виден: " + logo.getSrc());
        }
    }

    @DisplayName("Проверяем отображение картинок у кнопок оплаты в форме оплаты")
    @Test
    public void isImagesPayButtonDisplayed() {
        mainPage.cookieBanner.acceptIfPresent();
        mainPage.replenishmentForm.fillConnectionData("297777777", "100", "sergfrol33@gmail.com").submit();
        mainPage.replenishmentForm.toggleToPaymentForm();

        assertAll(
                () -> assertTrue(mainPage.paymentForm.isAppleSvgDisplayed(),
                        "Поле кредитной карты не отображается"),
                () -> assertEquals("url(\"https://www.gstatic.com/instantbuy/svg/dark_gpay.svg\")",
                        mainPage.paymentForm.getGoogleImage())
        );
    }
}
