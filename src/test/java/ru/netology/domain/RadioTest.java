package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {
    int expected;
    int actual;

    @ParameterizedTest
    // подготовка тестовых данных для метода setCurrentStation(currentStation)
    // - выставлять номер радиостанции через прямое указание её номера
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

    void shouldSetCurrentStation(int currentStation, int expected) {
        Radio radio = new Radio();

        radio.setCurrentStation(currentStation);
        actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }


    @ParameterizedTest
    // подготовка тестовых данных для метода переключения на следующую станцию next()
    @CsvSource({
            "6, 7", // позитивный
            "9, 0", // граничные значения
            "8, 9",
            "0, 1",
            "1, 2"
    })

    void shouldNextStation(int currentStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);

        radio.next();
        actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }


    @ParameterizedTest
    // подготовка тестовых данных для метода переключения на предыдущую станцию prev()
    @CsvSource({
            "6, 5", // позитивный
            "0, 9", // граничные значения
            "1, 0",
            "9, 8",
            "8, 7"
    })

    void shouldPrevStation(int currentStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);

        radio.prev();
        actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }


    @ParameterizedTest
    // подготовка тестовых данных для метода установки текущей громкости setCurrentVolume(currentVolume)
    @CsvSource({
            "6, 6", // позитивный
            "-6, 0", // негативныe
            "16, 0",
            "0, 0", // граничные значения
            "-1, 0",
            "1, 1",
            "10, 10",
            "9, 9",
            "11, 0"
    })

    void shouldSetCurrentVolume(int currentVolume, int expected) {
        Radio radio = new Radio();

        radio.setCurrentVolume(currentVolume);
        actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    // подготовка тестовых данных для метода увеличения громкости louder()
    @CsvSource({
            "6, 7", // позитивный
            "10, 10", // граничные значения
            "9, 10",
            "0, 1"
    })

    void shouldLouderVolume(int currentVolume, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);

        radio.louder();
        actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    // подготовка тестовых данных для метода уменьшения громкости quieter()
    @CsvSource({
            "6, 5", // позитивный
            "0, 0", // граничные значения
            "1, 0",
            "10, 9"
    })

    void shouldQuieterVolume(int currentVolume, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);

        radio.quieter();
        actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

}
