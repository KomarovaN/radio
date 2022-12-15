package ru.netology.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor(staticName = "of")
//@NoArgsConstructor
@Data

public class Radio {
    int currentStation;
    int currentVolume;
    int minStation;
    int maxStation;
    int minVolume;
    int maxVolume = 100;
    int numStations = 10;



    public Radio(int numStations) {
        if (numStations > minStation) {
           maxStation = minStation + numStations - 1;
           this.numStations = numStations;
        }
    }

    public Radio() {
        maxStation = numStations - 1;
    }

    public void setCurrentStation(int newCurrentStation) {
        if (newCurrentStation < minStation || newCurrentStation > maxStation) {
            return;
        }
        currentStation = newCurrentStation;
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume < minVolume || newCurrentVolume > maxVolume) {
            return;
        }
        currentVolume = newCurrentVolume;
    }

    // переключаем станции
    public void next() {
        if (currentStation == maxStation) {
            currentStation = minStation;
        }
        else {
            currentStation++;
        }
    }

    public void prev() {
        if (currentStation == minStation) {
            currentStation = maxStation;
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
