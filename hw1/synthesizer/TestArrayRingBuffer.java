package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
//        arb.dequeue();
        for (int i = 0; i < 10; i++) {
            arb.enqueue(i);
        }
//        arb.enqueue(11);
        for (int i = 0; i < 9; i++) {
            System.out.println(arb.dequeue());
        }
        for (int i = 2; i < 11; i++) {
            arb.enqueue(i);
        }
        System.out.println(arb.peek());
    }

    @Test
    public void testIteration() {
        ArrayRingBuffer<Integer> arb1 = new ArrayRingBuffer<>(10);
        for (int i = 0; i < 10; i++) {
            arb1.enqueue(i);
        }
        for (int i : arb1) {
            System.out.println(i);
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
