package at.aau.ue4.bsp2;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class MyCollectionTest
{
    private MyCollection c;

    @BeforeEach
    public void setup() {
        c = new MyCollection(5);
        c.add("1");
        c.add("2");
        c.add("3");
    }
    @Test
    public void testSizeSimple() {
        assertEquals(3,c.size());
    }

    @Test
    public void Should_ReturnIllegalArgumentException_WhenCollectionIsEmpty(){
        c.remove("3");
        c.remove("2");
        c.remove("1");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            c.remove("1");
        });
    }

    @Test
    public void Should_ReturnIllegalArgumentException_WhenStringIsNotInCollection(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            c.remove("5");
        });
    }

    @Test
    public void Should_RemoveString_WhenStringIsInCollection(){
        assertEquals(3,c.size());
        c.remove("2");
        Assertions.assertEquals(2,c.size());
    }

    @Test
    public void Should_ReturnEmptyList_WhenMethodEmptyIsCalled(){
        assertEquals(3,c.size());
        c.empty();
        assertEquals(0,c.size());
    }
}