package javalesson.patternsgof.structural;

public class AdapterLesson {
    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        carWash.washCar(new Audi());
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
interface Car{
    void wash();
}
class Audi implements Car{
    @Override
    public void wash() {
        System.out.println("Wash car Audi");
    }
}
class CarWash{
    public void washCar(Car car){
        car.wash();
    }
}
interface Track{
    void clean();
}
class MAN implements Track{
    @Override
    public void clean() {
        System.out.println("Wash car MAN");
    }
}