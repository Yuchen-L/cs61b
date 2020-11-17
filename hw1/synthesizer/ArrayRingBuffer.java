// TODO: Make sure to make this class a part of the synthesizer package
// package <package name>;
package synthesizer;
import synthesizer.AbstractBoundedQueue;

import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        this.capacity = capacity;
        rb = (T []) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
    }

    /**
     * the helper function to do the wrap-around for plus operation
     */
    private int oneplus(int point) {
        if (point == capacity - 1) {
            point = 0;
        } else {
            point += 1;
        }
        return point;
    }

    /**
     * the iterator implementation
     */
    public Iterator<T> iterator() {
        return new ArrayRingIterator();
    }

    private class ArrayRingIterator implements Iterator<T> {
        private int wizpos;
        private int outputcnt;
        public ArrayRingIterator() {
            wizpos = first;
            outputcnt = 0;
        }

        @Override
        public boolean hasNext() {
            if ((rb[wizpos] == null) || (outputcnt == capacity)) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public T next() {
            T item = rb[wizpos];
            wizpos = oneplus(wizpos);
            outputcnt += 1;
            return item;
        }
    }


    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (!isFull()) {
            rb[last] = x;
            last = oneplus(last);
            fillCount += 1;
        } else {
            throw new RuntimeException("Ring buffer overflow");
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if (!isEmpty()) {
            T firstrec = rb[first];
            rb[first] = null;
            first = oneplus(first);
            fillCount -= 1;
            return firstrec;
        } else {
            throw new RuntimeException("Ring buffer underflow");
        }

    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
}
