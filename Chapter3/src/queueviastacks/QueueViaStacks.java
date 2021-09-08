package queueviastacks;

import java.util.Optional;
import java.util.Stack;

public class QueueViaStacks <T extends Comparable<T>> {
    Stack<T> oldStack;
    Stack<T> newStack;

    public QueueViaStacks() {
        oldStack = new Stack<>();
        newStack = new Stack<>();
    }

    private void newToOld() {
        if (oldStack.isEmpty()) {
            while (!newStack.empty()) {
                oldStack.push(newStack.pop());
            }
        }
    }

    public void add(T value) {
        newStack.push(value);
    }

    public Optional<T> remove() {
        if (isEmpty())
            return Optional.empty();
        newToOld();
        return Optional.of(oldStack.pop());
    }

    public Optional<T> peek() {
        if (isEmpty())
            return Optional.empty();
        newToOld();
        return Optional.of(oldStack.peek());
    }

    public boolean isEmpty() {
        return oldStack.isEmpty() && newStack.isEmpty();
    }
}
