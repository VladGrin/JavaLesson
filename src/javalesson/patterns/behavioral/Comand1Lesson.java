package javalesson.patterns.behavioral;

public class Comand1Lesson {
    public static void main(String[] args) {
        Database database = new Database();
        Developer developer = new Developer(
                new InsertCommand(database),
                new UpdateCommand(database),
                new SelectCommand(database),
                new DeleteCommand(database)
        );
        developer.insertRecord();
        developer.updateRecord();
        developer.selectRecord();
        developer.deleteRecord();
    }
}
class Database{
    void insert(){
        System.out.println("Inserting record ...");
    }
    void update(){
        System.out.println("Updating record ...");
    }
    void select(){
        System.out.println("Reading record ...");
    }
    void delete(){
        System.out.println("Deleting record ...");
    }
}
interface Command{
    void execute();
}
class InsertCommand implements Command{
    Database database;
    public InsertCommand(Database database) {
        this.database = database;
    }
    @Override
    public void execute() {
        database.insert();
    }
}
class UpdateCommand implements Command{
    Database database;
    public UpdateCommand(Database database) {
        this.database = database;
    }
    @Override
    public void execute() {
        database.update();
    }
}
class SelectCommand implements Command{
    Database database;
    public SelectCommand(Database database) {
        this.database = database;
    }
    @Override
    public void execute() {
        database.select();
    }
}
class DeleteCommand implements Command{
    Database database;
    public DeleteCommand(Database database) {
        this.database = database;
    }
    @Override
    public void execute() {
        database.delete();
    }
}
class Developer{
    Command insert;
    Command update;
    Command select;
    Command delete;
    public Developer(Command insert, Command update, Command select, Command delete) {
        this.insert = insert;
        this.update = update;
        this.select = select;
        this.delete = delete;
    }
    void insertRecord(){
        insert.execute();
    }
    void updateRecord(){
        update.execute();
    }
    void selectRecord(){
        select.execute();
    }
    void deleteRecord(){
        delete.execute();
    }
}