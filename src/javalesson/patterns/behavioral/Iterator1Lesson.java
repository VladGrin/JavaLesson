package javalesson.patterns.behavioral;

public class Iterator1Lesson {
    public static void main(String[] args) {
        String[] skills = {"Java", "Spring", "Hibernate", "Maven", "PostgreSQL"};
        JavaDeveloper javaDeveloper = new JavaDeveloper("Vasia", skills);
        Iterator iterator = javaDeveloper.getIterator();
        System.out.println("Developer : " + javaDeveloper.getName());
        System.out.print("Skills : ");
        while (iterator.hasNext()){
            System.out.print(iterator.next().toString() + ", ");
        }
    }
}

interface Iterator {
    boolean hasNext();

    Object next();
}

interface Collection {
    Iterator getIterator();
}

class JavaDeveloper implements Collection {
    private String name;
    private String[] skills;

    public JavaDeveloper(String name, String[] skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    @Override
    public Iterator getIterator() {
        return new skillIterator();
    }

    private class skillIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < skills.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return skills[index++];
        }
    }
}