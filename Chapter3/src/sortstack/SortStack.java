package sortstack;

import java.util.Optional;
import java.util.Stack;

public class SortStack <T extends Comparable<T>> {
    private Stack<T> stk;

    public SortStack() {
        stk = new Stack<>();
    }

    public void push(T value) {
        if (isEmpty() || value.compareTo(stk.peek()) < 0)
            stk.push(value);
        else {
            stk.push(value);
            stk = sort(stk);
        }
    }

    private Stack<T> sort(Stack<T> input) {
        Stack<T> tempStk = new Stack<>();
        while (!input.isEmpty()) {
            T tempVal = input.pop();
            while (!tempStk.isEmpty() && tempVal.compareTo(tempStk.peek()) > 0) {
                input.push(tempStk.pop());
            }
            tempStk.push(tempVal);
        }
        return tempStk;
    }

    public Optional<T> pop() {
        if (isEmpty())
            return Optional.empty();
        else
            return Optional.of(stk.pop());
    }

    public boolean isEmpty()
    {
        return stk.isEmpty();
    }
}
