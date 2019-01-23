package javalesson.patternsgof.behavioral;

public class TemplateMethodLesson {
    public static void main(String[] args) {
        TemplateGame game = new Pocker();
        game.run();
    }
}
abstract class TemplateGame{
    abstract void startGame();
    abstract void playGame();
    abstract void endGame();
    void run(){
        startGame();
        playGame();
        endGame();
    }
}
class Pocker extends TemplateGame{

    @Override
    void startGame() {
        System.out.println("Get cards");
    }

    @Override
    void playGame() {
        System.out.println("Play");
    }

    @Override
    void endGame() {
        System.out.println("Loose money");
    }
}
