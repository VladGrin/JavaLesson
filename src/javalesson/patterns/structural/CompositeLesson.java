package javalesson.patterns.structural;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompositeLesson {
    public static void main(String[] args) {

    }
}
class MyFile{
    String fileName;
}
class MyFolder{
    String name;
    Date createDate;
    List<MyFolder> folderList = new ArrayList<>();
    List<MyFile> fileList = new ArrayList<>();

    public MyFolder(String name) {
        this.name = name;
    }
    public void addFolder(MyFolder folder){
        folderList.add(folder);
    }
    public void removeFolder(MyFolder folder){
        folderList.remove(folder);
    }
    public List<MyFolder> getFolders(){
        return folderList;
    }
    public void addFile(MyFile file){
        fileList.add(file);
    }
    public void removeFile(MyFile file){
        fileList.remove(file);
    }
    public List<MyFile> getFiles(){
        return fileList;
    }
}
