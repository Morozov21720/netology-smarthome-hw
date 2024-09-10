import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {


    @Test
    public void validStationMiddle() {
        Radio radio = new Radio();

        radio.setCurrentStation(4);

        int expected = 4;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void validStationLowerLimit() {
        Radio radio = new Radio();
        radio.setCurrentStation(4);

        radio.setCurrentStation(0);

        int expected = 0;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void validStationTopLimit() {
        Radio radio = new Radio();

        radio.setCurrentStation(9);

        int expected = 9;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void validStationLow() {
        Radio radio = new Radio();

        radio.setCurrentStation(1);

        int expected = 1;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void validStationHigh() {
        Radio radio = new Radio();

        radio.setCurrentStation(8);

        int expected = 8;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void unValidStationLow() {
        Radio radio = new Radio();

        radio.setCurrentStation(-5);

        int expected = 0;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void unValidStationHigh() {
        Radio radio = new Radio();

        radio.setCurrentStation(12);

        int expected = 0;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void validVolumeLow() {
        Radio radio = new Radio();

        radio.setCurrentVolume(1);

        int expected = 1;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    public void validVolumeMid() {
        Radio radio = new Radio();

        radio.setCurrentVolume(50);

        int expected = 50;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    public void validVolumeTop() {
        Radio radio = new Radio();

        radio.setCurrentVolume(99);

        int expected = 99;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    public void validVolumeLowLimit() {
        Radio radio = new Radio();
        radio.setCurrentVolume(10);
        radio.setCurrentVolume(0);

        int expected = 0;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    public void validVolumeTopLimit() {
        Radio radio = new Radio();

        radio.setCurrentVolume(100);

        int expected = 100;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    public void unValidVolumeLow() {
        Radio radio = new Radio();

        radio.setCurrentVolume(-10);

        int expected = 0;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    public void unValidVolumeTop() {
        Radio radio = new Radio();

        radio.setCurrentVolume(150);

        int expected = 0;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    public void testNextStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(8);
        radio.nextStation();
        assertEquals(9, radio.getCurrentStation());

        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(1);
        radio.prevStation();
        assertEquals(0, radio.getCurrentStation());

        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(99);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());

        radio.increaseVolume(); // Больше 100 не должно быть
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(1);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());

        radio.decreaseVolume(); // Меньше 0 не должно быть
        assertEquals(0, radio.getCurrentVolume());
    }
}