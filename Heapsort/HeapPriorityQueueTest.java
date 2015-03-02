import org.junit.*;
import static org.junit.Assert.*;

import java.util.Random;

public class HeapPriorityQueueTest {
    Random generator = new Random();
    HeapPriorityQueue<Integer> priorityQueue = new HeapPriorityQueue<Integer>();

    @Test
    public void test_enqueue() {
        for (int trial = 0; trial < 1000; trial++) {
            priorityQueue.enqueue(generator.nextInt());
            Assert.assertEquals("failure - priority queue should be heapified", true, priorityQueue.heapified());
        }

        Assert.assertEquals("failure - priority queue should have n items", 1000, priorityQueue.size());
    }

    @Test
    public void test_dequeue() {
        for (int trial = 0; trial < 1000; trial++) {
            Integer value = generator.nextInt();
            priorityQueue.enqueue(value);
        }
        Integer previous = priorityQueue.dequeue();

        while (priorityQueue.size() > 0) {
            Assert.assertEquals("failure - priority queue should be heapified", true, priorityQueue.heapified());
            Integer current = priorityQueue.dequeue();
            Assert.assertEquals("failure - current element should be greater than or equal to previous", true, current >= previous);
            previous = current;
        }
    }
}
