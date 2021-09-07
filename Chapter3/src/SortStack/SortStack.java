package SortStack;

import java.util.Optional;
import java.util.Stack;

public class SortStack {
    private Stack<Integer> stk = new Stack<>();

    public void push(int value)
    {
        if (isEmpty() || value < stk.peek())
            stk.push(value);
        else
        {
            stk.push(value);
            stk = minToMax(stk);
        }
    }

    private Stack<Integer> minToMax(Stack<Integer> input)
    {
        Stack<Integer> tempStk = new Stack<>();
        while (!input.isEmpty())
        {
            int tempVal = input.pop();
            while (!tempStk.isEmpty() && tempStk.peek() < tempVal)
            {
                input.push(tempStk.pop());
            }
            tempStk.push(tempVal);
        }
        return tempStk;
    }

    public Optional<Integer> pop()
    {
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
