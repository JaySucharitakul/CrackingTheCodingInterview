package stackmin;

import java.util.Stack;

class StackMin extends Stack<Integer> {
    // stack containing the minimum values
    private final Stack<Integer> stkMin;

    public StackMin() {
        stkMin = new Stack<>();
    }

    public void Push(int value) {
        if (value < Min()) {
            stkMin.push(value);
        }
        super.push(value);
    }

    public int Pop()
    {
        int value = super.pop();
        if (value == Min())
            stkMin.pop();
        return value;
    }

    public int Min()
    {
        if (stkMin.isEmpty())
            return Integer.MAX_VALUE;
        else
            return stkMin.peek();
    }
}

