package javalesson.patterns;

public class FacadeApp {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.copy();
    }
}
class Computer{
    private Power power = new Power();
    private DVDRom dvdRom = new DVDRom();
    private HDD hdd = new HDD();
    void copy(){
        power.on();
        dvdRom.load();
        hdd.copyFromDvd(dvdRom);
        power.off();
    }
}
class Power{
    void on(){
        System.out.println("Включение компьютера");
    }
    void off(){
        System.out.println("Выключение компьютера");
    }
}
class DVDRom{
    private boolean data = false;

    public boolean isData() {
        return data;
    }
    void load(){
        data = true;
    }
    void unLoad(){
        data = false;
    }
}
class HDD{
    void copyFromDvd(DVDRom dvdRom){
        if (dvdRom.isData()){
            System.out.println("Копируем данные");
        } else {
            System.out.println("Вставьте диск с данными");
        }
    }
}
