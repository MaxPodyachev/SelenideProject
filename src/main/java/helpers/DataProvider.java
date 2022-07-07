package helpers;

import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

/**
 * Класс подачи данных в тест
 */
public class DataProvider {

    /**
     * Передаем аргументы
     * @return Stream.of(Arguments.of())
     */
    public static Stream<Arguments> checkingBrand() {

        return Stream.of(
//                Arguments.of("Электроника", "Смартфоны", "Apple")
                Arguments.of("Электроника", "Смартфоны", "Google")
//                Arguments.of("Электроника", "Смартфоны", "HONOR")
//                Arguments.of("Электроника", "Смартфоны", "HUAWEI")
//                Arguments.of("Электроника", "Смартфоны", "Nokia")
//                Arguments.of("Электроника", "Смартфоны", "OnePlus")
//                Arguments.of("Электроника", "Смартфоны", "OPPO")
//                Arguments.of("Электроника", "Смартфоны", "realme")
//                Arguments.of("Электроника", "Смартфоны", "Samsung")
//                Arguments.of("Электроника", "Смартфоны", "vivo")
//                Arguments.of("Электроника", "Смартфоны", "Xiaomi")
//                Arguments.of("Электроника", "Смартфоны", "ZTE")
        );
    }
}
