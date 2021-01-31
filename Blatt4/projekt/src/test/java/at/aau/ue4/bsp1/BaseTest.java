package at.aau.ue4.bsp1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BaseTest {

    private RingBuffer<Integer> ringBufferEmpty;
    private RingBuffer<Integer> ringBufferFull;
    private Iterator<Integer> ringBufferIteratorFull;
    private Iterator<Integer> ringBufferIteratorEmpty;

    @BeforeEach
    public void initialize() {
        ringBufferEmpty = new RingBuffer(5);
        ringBufferFull = new RingBuffer(5);
        ringBufferFull.push(1);
        ringBufferFull.push(2);
        ringBufferFull.push(3);
        ringBufferFull.push(4);
        ringBufferFull.push(5);
        ringBufferIteratorFull = ringBufferFull.iterator();
        ringBufferIteratorEmpty = ringBufferEmpty.iterator();
    }
    @Test
    public void Should_AssertTrue_When_BufferIsEmpty() {
        Assertions.assertTrue(ringBufferEmpty.isEmpty());
    }

    @Test
    public void Should_AssertFalse_When_BufferIsNotEmpty() {
        Assertions.assertFalse(ringBufferFull.isEmpty());
    }
    @Test
    public void Should_ReturnZero_When_BufferIsEmpty() {
        Assertions.assertEquals(0, ringBufferEmpty.size());
    }
    @Test
    public void Should_ReturnFive_When_BufferHasFiveElement() {
        Assertions.assertEquals(5, ringBufferFull.size());
    }
    @Test
    public void Should_ThrowRuntimeException_When_BufferLengthIsFull() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            ringBufferFull.push(1);
        });
    }
    @Test
    public void Should_ThrowRuntimeException_When_BufferIsEmpty() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            ringBufferEmpty.pop();
        });
    }
    @Test
    public void Should_ReturnItem_When_BufferIsNotEmpty() {
        for(int i = 1; i<ringBufferFull.size();i++){
            Assertions.assertEquals(i, (int)ringBufferFull.pop());
        }
    }
    @Test
    public void Should_ReturnFalse_When_BufferIsEmpty() {
        Assertions.assertFalse(ringBufferIteratorEmpty.hasNext());
    }
    @Test
    public void Should_ReturnTrue_When_BufferIsFull() {
        Assertions.assertTrue(ringBufferIteratorFull.hasNext());
    }
    @Test
    public void Should_ReturnUnsupportedOperationException_When_MethodRemoveIsLoaded() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            ringBufferIteratorFull.remove();
        });
    }
    @Test
    public void Should_ReturnNoSuchElementException_When_ThereIsNoNextElement() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            ringBufferIteratorEmpty.next();
        });
    }
    @Test
    public void Should_ReturnNextElement_When_ThereIsNextElement() {
        for (int i = 1; i < ringBufferFull.size(); i++) {
            Assertions.assertEquals(i, (int) ringBufferIteratorFull.next());
        }
    }
}
