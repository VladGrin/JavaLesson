package javalesson.solid;


public class Ex {
    public static void main(String[] args) throws CloneNotSupportedException {
        CarWash carWash = new CarWash();
        carWash.washCar(new Daf());
        carWash.washCar(new TrackWrap(new VOLVO()));
    }
}
class TrackWrap implements Car1{
    Track track;
    public TrackWrap(Track track) {
        this.track = track;
    }
    @Override
    public void wash() {
        System.out.println("Track clean here");
        track.clean();
    }
}

interface Track{
    void clean();
}
class VOLVO implements Track{
    @Override
    public void clean() {
        System.out.println("clean me");
    }
}

interface Car1{
    void wash();
}
class Daf implements Car1{
    @Override
    public void wash() {
        System.out.println("wash me");
    }
}
class CarWash{
    void washCar(Car1 car1){
        System.out.println("Car wash here");
        car1.wash();
    }
}