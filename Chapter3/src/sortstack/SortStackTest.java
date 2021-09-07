package sortstack;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SortStackTest {

    @org.junit.jupiter.api.Test
    void push() {
        SortStack<Integer> stk = new SortStack<>();
        stk.push(10);
        stk.push(9);
        stk.push(15);
        stk.push(42);
        stk.push(5);
        stk.push(1);
        assertEquals(1, stk.pop().orElse(null));
        assertEquals(5, stk.pop().orElse(null));
        assertEquals(9, stk.pop().orElse(null));
        assertEquals(10, stk.pop().orElse(null));
        assertEquals(15, stk.pop().orElse(null));
        assertEquals(42, stk.pop().orElse(null));
    }

    @org.junit.jupiter.api.Test
    void pop() {
        SortStack<Integer> stk = new SortStack<>();
        stk.push(10);
        stk.push(9);
        assertEquals(9, stk.pop().orElse(null));
        assertEquals(10, stk.pop().orElse(null));
        assertEquals(Optional.empty(), stk.pop());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        SortStack<Integer> stk = new SortStack<>();
        assertTrue(stk.isEmpty());
        stk.push(42);
        assertFalse(stk.isEmpty());
    }
}