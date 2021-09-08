package queueviastacks;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class QueueViaStacksTest {

    @Test
    void addAndRemove() {
        QueueViaStacks<Integer> queue = new QueueViaStacks<>();
        for (int i = 0; i < 10; i++) {
            queue.add(i * 5);
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(i * 5, queue.remove().orElse(null));
        }
    }

    @Test
    void peek() {
        QueueViaStacks<Integer> queue = new QueueViaStacks<>();
        assertEquals(Optional.empty(), queue.peek());
        queue.add(1);
        assertEquals(1, queue.peek().orElse(null));
    }

    @Test
    void isEmpty() {
        QueueViaStacks<Integer> queue = new QueueViaStacks<>();
        assertTrue(queue.isEmpty());
        queue.add(42);
        assertFalse(queue.isEmpty());
    }
}