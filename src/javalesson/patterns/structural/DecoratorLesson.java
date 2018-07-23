package javalesson.patterns.structural;

public class DecoratorLesson {
    public static void main(String[] args) {
        NewFile newFile = new FileBufferedReader(new NewFileReader());
        newFile.read();
    }
}
interface NewFile{
    void read();
}
class NewFileReader implements NewFile{
    @Override
    public void read() {
        System.out.println("read new file");
    }
}
abstract class FileDecorator implements NewFile{
    NewFile newFile;
    public FileDecorator(NewFile newFile) {
        this.newFile = newFile;
    }

    public abstract void read();
}
class FileBufferedReader extends FileDecorator {

    public FileBufferedReader(NewFile newFile) {
        super(newFile);
    }

    @Override
    public void read() {
        newFile.read();
        System.out.println("buffered read");
    }
}