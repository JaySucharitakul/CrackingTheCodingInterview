package animalshelter;

import javafx.util.Pair;

import java.util.LinkedList;

public class AnimalShelter {

    LinkedList<Pair<String, Boolean>> animalQueue;
    LinkedList<String> dogQueue;
    LinkedList<String> catQueue;

    public AnimalShelter() {
        animalQueue = new LinkedList<>();
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
    }

    public void enqueue(String name, boolean isDog) {
        Pair<String, Boolean> animalRegistry = new Pair<>(name, isDog);
        animalQueue.addLast(animalRegistry);
        if (animalRegistry.getValue())
            dogQueue.addLast(name);
        else
            catQueue.addLast(name);
    }

    public String dequeueAny() {
        return animalQueue.pop().getKey();
    }

    public String dequeueDog() {
        return dogQueue.pop();
    }

    public String dequeueCat() {
        return catQueue.pop();
    }
}
