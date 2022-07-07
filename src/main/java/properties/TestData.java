package properties;

import org.aeonbits.owner.ConfigFactory;

/**
 * Класс проперти
 */
public class TestData {

    /**
     * Проперти сайта
     */
    public static PropsUrl propsUrl = ConfigFactory.create(PropsUrl.class);

    /**
     * Проперти имени страницы
     */
    public static PropsNamePage namePage = ConfigFactory.create(PropsNamePage.class);
}
