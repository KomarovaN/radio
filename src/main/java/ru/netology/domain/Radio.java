package ru.netology.domain;

public class Radio {
    int currentStation;
    int currentVolume;

    // set/get для станции
    public void setCurrentStation(int newCurrentStation) {
        if (newCurrentStation < 0 || newCurrentStation > 9) {
            return;
        }
        currentStation = newCurrentStation;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    // set/get для громкости
    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume < 0 || newCurrentVolume > 10) {
            return;
        }
        currentVolume = newCurrentVolume;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    // переключаем станции
    public void next() {
        if (currentStation == 9) {
            currentStation = 0;
        }
        else {
            currentStation++;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = 9;
        }
        else {
            currentStation--;
        }
    }

    // управляем уровнем громкости
    public void louder() {
        setCurrentVolume(currentVolume+1);
    }

    public void quieter() {
        setCurrentVolume(currentVolume-1);
    }

}
