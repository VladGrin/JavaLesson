package javalesson.patterns.structural;

import java.util.Calendar;

public class AdapterLesson {
    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        carWash.washCar(new BMW());
        carWash.washCar(new TrackWrap(new MAN()));
    }
}
class TrackWrap implements Car{
    Track track;
    public TrackWrap(Track track) {
        this.track = track;
    }
    @Override
    public void wash() {
        track.clean();
    }
}
interface Track{
    void clean();
}
class MAN implements Track{
    @Override
    public void clean() {
        System.out.println("I am MAN. Clean me");
    }
}
interface Car{
    void wash();
}
class BMW implements Car{

    @Override
    public void wash() {
        System.out.println("I am BMW. Brush me");
    }
}
class CarWash{
    public void washCar(Car car){
        System.out.println("Cars wash here");
        car.wash();
    }
}