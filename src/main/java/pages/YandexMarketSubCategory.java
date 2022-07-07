package pages;


import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Класс страницы ЯндексМаркета подкатегрий
 */
public class YandexMarketSubCategory extends BasePage {

    /**
     * Задаем нужного производителя
     * @param brandName значение производителя
     * @return this
     */
    @Step("Задаем параметр 'Производитель': {brandName}")
    public YandexMarketSubCategory brandChoice(String brandName) {
        String xpathShowAll = "//span[text()='Показать всё']/parent::span[@role='button']";
        String xpathBrandChoice = "//span[text()='"+ brandName +"']/ancestor::label";
        String xpathWait = "//span[contains(@aria-label,'Загрузка...')]";
        String xpathWaitPage = "//div[@data-apiary-widget-id='/content/cms/4/SearchSerp-SearchSerp']//span[contains(@aria-label,'Загрузка...')]";
        $x(xpathShowAll).click();
        $x(xpathWait).shouldNotBe(exist);
        $x(xpathBrandChoice).click();
        $x(xpathWaitPage).shouldNotBe(exist);
        return this;
    }

    /**
     * Проверяем, что в выборку попали только: {brandName}. Если страниц несколько - проверяем все
     * @param brandName значение производителя
     * @return this
     */
    @Step("Проверяем, соответствует ли: {brandName} всем производителям на всех страницах")
    public YandexMarketSubCategory listBrand(String brandName) {
        String xpathElements = "//div[@data-apiary-widget-id='/content/cms/4/SearchSerp-SearchSerp']//h3[@data-zone-name='title']/parent::div/parent::div";
        String xpathNextPage = "//span[text()='Вперёд']/parent::div";
        String xpathViewed = "//div[contains(text(),'Вы посмотрели')]";
        String xpathWait = "//div[@data-apiary-widget-id='/content/cms/4/SearchSerp-SearchSerp']//span[contains(@aria-label,'Загрузка...')]";

        List<String> listElements = new ArrayList<>();
        $x(xpathViewed).hover();
        $x(xpathWait).shouldNotBe(exist);
        $$x(xpathElements).forEach(x -> listElements.add(x.getText()));

        while ($x(xpathNextPage).exists()) {
            $x(xpathNextPage).click();
            $x(xpathViewed).hover();
            $x(xpathWait).shouldNotBe(exist);
            $$x(xpathElements).forEach(x -> listElements.add(x.getText()));
        }
        Assertions.assertTrue(listElements.stream().allMatch(x -> x.toLowerCase().contains(brandName.toLowerCase())),
                "Ошибка, в полученном списке есть элементы, которые не соответсвуют производителю");
        return this;
    }
}
