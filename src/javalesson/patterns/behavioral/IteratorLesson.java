package javalesson.patterns.behavioral;

public class IteratorLesson {
    public static void main(String[] args) {
        String[] array = {"Maik", "John", "Bob", "Nike"};
        ArrayConteiner arrayConteiner = new ArrayConteiner(array);
        Iterator iterator = arrayConteiner.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
interface Iterator1{
    boolean hasNext();
    Object next();
}
interface Conteiner{
    Iterator getIterator();
}
class ArrayConteiner implements Conteiner{
    String[] array;

    public ArrayConteiner(String[] array) {
        this.array = array;
    }

    @Override
    public Iterator getIterator() {
        return new ArrayIterator();
    }
    private class ArrayIterator implements Iterator{
        int index;

        @Override
        public boolean hasNext() {
            if(index < array.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return array[index++];
        }
    }
}