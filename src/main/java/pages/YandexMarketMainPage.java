package pages;

import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

/**
 * Класс главной страницы ЯндексМаркета
 */
public class YandexMarketMainPage extends BasePage {

    /**
     * Выбираем категорию
     * @param category значение категории
     * @param typeNextPage класс страницы
     * @return page(YandexMarketCategory.class)
     */
    @Step("Выбираем категорию: {category}")
    public <T extends BasePage> T categorySelection(String category, Class<T> typeNextPage) {
        String xpathCategory = "//span[text()='"+category+"']/parent::a";
        $x(xpathCategory).click();
        return typeNextPage.cast(page(typeNextPage));
    }

}
