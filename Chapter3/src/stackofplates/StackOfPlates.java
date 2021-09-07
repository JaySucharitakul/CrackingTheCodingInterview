package stackofplates;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Stack;

public class StackOfPlates {
    private final LinkedList<Stack<Integer>> stacks = new LinkedList<>();
    private final int stackLimit;

    public StackOfPlates(int limit)
    {
        stackLimit = limit;
    }

    public Stack<Integer> lastStack() {
        if (stacks.size() == 0)
            return null;
        return stacks.get(stacks.size() - 1);
    }

    public void push(int value) {
        final Stack<Integer> lastStack = lastStack();
        if (lastStack != null && lastStack.size() != stackLimit) {
            lastStack.push(value);
        } else {
            Stack<Integer> newStack = new Stack<>();
            newStack.push(value);
            stacks.add(newStack);
        }
    }

    public Optional<Integer> pop()
    {
        Stack<Integer> lastStack = lastStack();
        if (lastStack == null)
            return Optional.empty();
        Optional<Integer> poppedVal = Optional.of(lastStack.pop());
        if (lastStack.size() == 0) {
            stacks.removeLast();
        }
        return poppedVal;
    }

    public int popAt(int index) {
        if (index < 0 || index >= stacks.size())
            return -1;
        Stack<Integer> stack = stacks.get(index);
        int poppedVal = stack.pop();
        if (stack.isEmpty())
            stacks.remove(index);
        return poppedVal;
    }
}
