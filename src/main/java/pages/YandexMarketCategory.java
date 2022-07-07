package pages;

import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

/**
 * Класс страницы ЯндексМаркет категории
 */
public class YandexMarketCategory extends BasePage {

    /**
     * Выбираем подкатегорию
     * @param subCategory значение подкатегории
     * @param typeNextPage класс страницы
     * @return page(YandexMarketSubCategory.class)
     */
    @Step("Выбираем подкатегорию: {subCategory}")
    public<T extends BasePage> T subCategorySelection(String subCategory, Class<T> typeNextPage) {
        String xpathSubCategory = "//a[text()='"+subCategory+"']";
        $x(xpathSubCategory).click();
        return typeNextPage.cast(page(typeNextPage));
    }
}
