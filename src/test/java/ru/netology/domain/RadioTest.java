package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {
    int expected;
    int actual;

    @ParameterizedTest
    // подготовка тестовых данных для конструктора с параметром Radio(numStations)
    // если количество станций задано пользователем:
    //     первое значение - количество станций,
    //     второе значение - ожидаемое значение максимального номера станции
    @CsvSource({
            "60, 59", // позитивный
            "-60, 0", // негативный
            "0, 0", // граничные значения
            "-1, 0",
            "1, 0",
    })

    public void shouldNewRadioWithParam(int numStations, int expected) {
        Radio radio = new Radio(numStations);

        actual = radio.getMaxStation();  // фактическое значение максимального номера станции

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNewRadioDefault() {
        Radio radio = new Radio();

        expected = 9;
        actual = radio.getMaxStation();

        Assertions.assertEquals(expected, actual);
    }


    @ParameterizedTest
    // подготовка тестовых данных для метода setCurrentStation(currentStation)
    // - выставлять номер радиостанции через прямое указание её номера,
    // если количество станций задано по умолчанию
    @CsvSource({
            "6, 6", // позитивный
            "-6, 0", // негативныe
            "16, 0",
            "0, 0", // граничные значения
            "-1, 0",
            "1, 1",
            "8, 8",
            "9, 9",
            "10, 0"
    })

    public void shouldSetCurrentStationDefault(int currentStation, int expected) {
        Radio radio = new Radio();

        radio.setCurrentStation(currentStation);
        actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    // подготовка тестовых данных для метода setCurrentStation(currentStation)
    // - выставлять номер радиостанции через прямое указание её номера
    // если количество станций задано пользователем
    @CsvSource({
            "30, 60, 30", // позитивный
            "-30, 60, 0", // негативныe
            "160, 60, 0",
            "0, 60, 0", // граничные значения
            "-1, 60, 0",
            "1, 60, 1",
            "58, 60, 58",
            "59, 60, 59",
            "60, 60, 0"
    })

    public void shouldSetCurrentStation(int currentStation, int numStations, int expected) {
        Radio radio = new Radio(numStations);

        radio.setCurrentStation(currentStation);
        actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }


    @ParameterizedTest
    // подготовка тестовых данных для метода переключения на следующую станцию next()
    // если количество станций задано по умолчанию
    @CsvSource({
            "6, 7", // позитивный
            "9, 0", // граничные значения
            "8, 9",
            "0, 1",
            "1, 2"
    })

    public void shouldNextStationDefault(int currentStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);

        radio.next();
        actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    // подготовка тестовых данных для метода переключения на следующую станцию next()
    // если количество станций задано пользователем
    @CsvSource({
            "30, 60, 31", // позитивный
            "59, 60, 0", // граничные значения
            "58, 60, 59",
            "0, 60, 1",
            "1, 60, 2"
    })

    public void shouldNextStation(int currentStation, int numStations, int expected) {
        Radio radio = new Radio(numStations);
        radio.setCurrentStation(currentStation);

        radio.next();
        actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }


    @ParameterizedTest
    // подготовка тестовых данных для метода переключения на предыдущую станцию prev()
    // если количество станций задано по умолчанию
    @CsvSource({
            "6, 5", // позитивный
            "0, 9", // граничные значения
            "1, 0",
            "9, 8",
            "8, 7"
    })

    public void shouldPrevStationDefault(int currentStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);

        radio.prev();
        actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    // подготовка тестовых данных для метода переключения на предыдущую станцию prev()
    // если количество станций задано пользователем
    @CsvSource({
            "30, 60, 29", // позитивный
            "0, 60, 59", // граничные значения
            "1, 60, 0",
            "59, 60, 58",
            "58, 60, 57"
    })

    public void shouldPrevStation(int currentStation, int numStations, int expected) {
        Radio radio = new Radio(numStations);
        radio.setCurrentStation(currentStation);

        radio.prev();
        actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }


    @ParameterizedTest
    // подготовка тестовых данных для метода установки текущей громкости setCurrentVolume(currentVolume)
    @CsvSource({
            "60, 60", // позитивный
            "-10, 0", // негативныe
            "160, 0",
            "0, 0", // граничные значения
            "-1, 0",
            "1, 1",
            "100, 100",
            "99, 99",
            "101, 0"
    })

    public void shouldSetCurrentVolume(int currentVolume, int expected) {
        Radio radio = new Radio();

        radio.setCurrentVolume(currentVolume);
        actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    // подготовка тестовых данных для метода увеличения громкости louder()
    @CsvSource({
            "60, 61", // позитивный
            "100, 100", // граничные значения
            "99, 100",
            "0, 1"
    })

    public void shouldLouderVolume(int currentVolume, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);

        radio.louder();
        actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    // подготовка тестовых данных для метода уменьшения громкости quieter()
    @CsvSource({
            "60, 59", // позитивный
            "0, 0", // граничные значения
            "1, 0",
            "100, 99"
    })

    public void shouldQuieterVolume(int currentVolume, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);

        radio.quieter();
        actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

}
