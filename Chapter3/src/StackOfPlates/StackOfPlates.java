package StackOfPlates;

import java.util.LinkedList;
import java.util.Stack;

public class StackOfPlates {
    private LinkedList<Stack<Integer>> stacks = new LinkedList<Stack<Integer>>();
    private int stackLimit;

    public StackOfPlates(int limit)
    {
        stackLimit = limit;
    }

    public Stack lastStack() {
        if (stacks.size() == 0)
            return null;
        return stacks.get(stacks.size() - 1);
    }

    public void Push(int value) {
        Stack lastStack = lastStack();
        if (lastStack != null && lastStack.size() != stackLimit) {
            lastStack.push(value);
        } else {
            Stack newStack = new Stack();
            newStack.push(value);
            stacks.add(newStack);
        }
    }

    public int Pop()
    {
        Stack lastStack = lastStack();
        if (lastStack == null)
            return -1;
        int poppedVal = (int) lastStack.pop();
        if (lastStack.size() == 0) {
            stacks.remove(stacks.size() - 1);
        }
        return poppedVal;
    }

    public int PopAt(int index) {
        Stack stack = stacks.get(index);
        int poppedVal = (int) stack.pop();
        if (stack.isEmpty())
            stacks.remove(index);
        return poppedVal;
    }
}
