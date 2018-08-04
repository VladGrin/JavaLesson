package javalesson.stepic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class AnimalSerializable {
    public static void main(String[] args) throws IOException {
        Animal[] animalM1 = {new Animal("Cat"), new Animal("Dog"), new Animal("Elephant"),
                new Animal("Cock"), new Animal("Bull"), new Animal("Ant"),
                new Animal("Tentecles"), new Animal("Worm")};
        ByteArrayOutputStream bai = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bai);
        oos.writeInt(animalM1.length);
        for (int i = 0; i < animalM1.length; i++) {
            oos.writeObject(animalM1[i]);
        }
        oos.flush();
        oos.close();
        Animal[] animalM2 = deserializeAnimalArray(bai.toByteArray());
        for (Animal animal : animalM2) {
            System.out.println(animal);
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] animals = null;
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
             ObjectInputStream streamInp = new ObjectInputStream(inputStream);) {
            int amount = streamInp.readInt();
            animals = new Animal[amount];
            for (int i = 0; i < amount; i++) {
                animals[i] = (Animal) streamInp.readObject();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return animals;
    }
}

class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}