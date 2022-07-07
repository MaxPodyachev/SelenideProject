package pages;

import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

/**
 * Класс главной страницы яндекса
 */
public class YandexMainPage {

    @Step("Открываем сайт: {url}")
    public YandexMainPage openYandex(String url) {
        open(url);
        return this;
    }

    /**
     * Переходим на страницу
     * @param namePage значение страницы
     * @param typeNextPage класс страницы
     * @param <T> тип данных
     * @return typeNextPage.cast(page(typeNextPage))
     */
    @Step("Переходим на страницу: {namePage}")
    public <T extends BasePage> T goLinkByName(String namePage, Class<T> typeNextPage) {
        String xpathButtonYandexMarket = "//a[contains(@href,'"+ namePage +"')]/self::a[@data-id='market']";
        $x(xpathButtonYandexMarket).click();
        switchTo().window(1);
        return typeNextPage.cast(page(typeNextPage));
    }
}
