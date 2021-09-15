package animalshelter;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;

public class AnimalShelter {
    private final LinkedList<Pair<String, Boolean>> animalQueue;
    private final LinkedList<String> dogQueue;
    private final LinkedList<String> catQueue;

    public AnimalShelter() {
        animalQueue = new LinkedList<>();
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
    }

    public void enqueue(String name, boolean isDog) {
        Pair<String, Boolean> animalRegistry = new Pair<>(name, isDog);
        animalQueue.addLast(animalRegistry);
        if (isDog)
            dogQueue.addLast(name);
        else
            catQueue.addLast(name);
    }

    public Optional<String> dequeueAny() {
        if (animalQueue.isEmpty())
            return Optional.empty();

        Pair<String, Boolean> animal = animalQueue.peek();
        if (animal.getValue()) {
            if (Objects.equals(animal.getKey(), dogQueue.peek()))
                return Optional.empty();
            dogQueue.pop();
        } else {
            if (!Objects.equals(animal.getKey(), catQueue.peek()))
                return Optional.empty();
            catQueue.pop();
        }
        return Optional.of(animalQueue.pop().getKey());
    }

    public Optional<String> dequeueDog() {
        if (dogQueue.isEmpty())
            return Optional.empty();

        String dogName = dogQueue.peek();
        if (!animalQueue.remove(new Pair<>(dogName, true)))
            return Optional.empty();
        return Optional.of(dogQueue.pop());
    }

    public Optional<String> dequeueCat() {
        if (catQueue.isEmpty())
            return Optional.empty();

        String catName = catQueue.peek();
        if (!animalQueue.remove(new Pair<>(catName, false)))
            return Optional.empty();
        return Optional.of(catQueue.pop());
    }
}
