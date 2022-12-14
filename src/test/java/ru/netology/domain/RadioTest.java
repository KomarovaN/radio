package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    int expected;
    int actual;

    @Test
    public void shouldSetCurrentStationMiddleLimit() {
        Radio radio = new Radio();

        expected = 6;
        radio.setCurrentStation(6);
        actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetCurrentStationLessLimit() {
        Radio radio = new Radio();

        expected = 0;
        radio.setCurrentStation(-6);
        actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetCurrentStationMoreLimit() {
        Radio radio = new Radio();

        expected = 0;
        radio.setCurrentStation(16);
        actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNextStationMiddleLimit() {
        Radio radio = new Radio();
        radio.setCurrentStation(6);

        expected = 7;
        radio.next();
        actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNextStationBoundary() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);

        expected = 0;
        radio.next();
        actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNextStationLessBoundary() {
        Radio radio = new Radio();
        radio.setCurrentStation(8);

        expected = 9;
        radio.next();
        actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPrevStationMiddleLimit() {
        Radio radio = new Radio();
        radio.setCurrentStation(6);

        expected = 5;
        radio.prev();
        actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPrevStationBoundary() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);

        expected = 9;
        radio.prev();
        actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPrevStationMoreBoundary() {
        Radio radio = new Radio();
        radio.setCurrentStation(1);

        expected = 0;
        radio.prev();
        actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }



    @Test
    public void shouldSetCurrentVolumeMiddleLimit() {
        Radio radio = new Radio();

        expected = 6;
        radio.setCurrentVolume(6);
        actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetCurrentVolumeLessLimit() {
        Radio radio = new Radio();

        expected = 0;
        radio.setCurrentVolume(-6);
        actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetCurrentVolumeMoreLimit() {
        Radio radio = new Radio();

        expected = 0;
        radio.setCurrentVolume(16);
        actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldLouderVolumeMiddleLimit() {
        Radio radio = new Radio();
        radio.setCurrentVolume(6);

        expected = 7;
        radio.louder();
        actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldLouderVolumeBoundary() {
        Radio radio = new Radio();
        radio.setCurrentVolume(10);

        expected = 10;
        radio.louder();
        actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldLouderVolumeLessBoundary() {
        Radio radio = new Radio();
        radio.setCurrentVolume(9);

        expected = 10;
        radio.louder();
        actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldQuieterVolumeMiddleLimit() {
        Radio radio = new Radio();
        radio.setCurrentVolume(6);

        expected = 5;
        radio.quieter();
        actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldQuieterVolumeBoundary() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);

        expected = 0;
        radio.quieter();
        actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldQuieterVolumeMoreBoundary() {
        Radio radio = new Radio();
        radio.setCurrentVolume(1);

        expected = 0;
        radio.quieter();
        actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

}
