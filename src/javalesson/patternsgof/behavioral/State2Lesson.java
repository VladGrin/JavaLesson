package javalesson.patternsgof.behavioral;

public class State2Lesson {
    public static void main(String[] args) {
        Station fm = new RadioFM();
        Radio radio = new Radio();
        radio.setStation(fm);
        for (int i = 0; i < 10; i++) {
            radio.play();
            radio.nextStation();
        }
    }
}

interface Station {
    void play();
}

class RadioFM implements Station {
    @Override
    public void play() {
        System.out.println("RadioFM...");
    }
}

class RadioEra implements Station {
    @Override
    public void play() {
        System.out.println("RadioEra...");
    }
}

class RadioRock implements Station {
    @Override
    public void play() {
        System.out.println("RadioRock...");
    }
}

class Radio {
    Station station;

    public void setStation(Station station) {
        this.station = station;
    }

    void nextStation() {
        if (station instanceof RadioFM) {
            setStation(new RadioEra());
        } else if (station instanceof RadioEra) {
            setStation(new RadioRock());
        } else if (station instanceof RadioRock) {
            setStation(new RadioFM());
        }
    }

    void play() {
        station.play();
    }
}