package javalesson.patterns;

import java.util.Date;

public class FactoryMethod {
    public static void main(String[] args) {
//        WatchMaker watchMaker = getMakerByName("digital");
        WatchMaker watchMaker = getMakerByName("rome");
        Watch watch = watchMaker.createWatch();
        watch.showTime();
    }
    public static WatchMaker getMakerByName(String maker){
        switch (maker){
            case "digital" : return new DigilalWatchMaker();
            case "rome" : return new RomeWatchMaker();
            default: throw new RuntimeException("error!");
        }
    }
}
interface Watch{
    void showTime();
}
class DigitalWatch implements Watch{

    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}
class RomeWatch implements Watch{
    @Override
    public void showTime() {
        System.out.println("XXI");
    }
}
interface WatchMaker{
    Watch createWatch();
}
class DigilalWatchMaker implements WatchMaker{
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}
class RomeWatchMaker implements WatchMaker{
    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}