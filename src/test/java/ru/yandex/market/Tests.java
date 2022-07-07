package ru.yandex.market;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.*;
import properties.TestData;

public class Tests extends BaseTests{

    @DisplayName("Тестирование сайта: ЯндекМаркет")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("helpers.DataProvider#checkingBrand")
    public void yandexMarketSelenide(String category, String subCategory, String brandName) {

        YandexMainPage yandexMainPage = new YandexMainPage();
        yandexMainPage.openYandex(TestData.propsUrl.baseUrlYandex())
                .goLinkByName(TestData.namePage.namePage(), YandexMarketMainPage.class)
                .categorySelection(category, YandexMarketCategory.class)
                .subCategorySelection(subCategory, YandexMarketSubCategory.class)
                .brandChoice(brandName)
                .listBrand(brandName);
    }
}
