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
    public void testRemove(){
        assertEquals(3,c.size());
        for(int i = 3; i > 0; i--){
            c.remove(String.valueOf(i));
            assertEquals(i-1,c.size());
        }
    }
    @Test
    public void testRemoveEmpty(){
        for(int i = 3; i > 0; i--){
            System.out.println(i);
            c.remove(String.valueOf(i));
            assertEquals(i - 1,c.size());
        }
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            c.remove("5");
        });
    }
    @Test
    public void testRemoveNotInList(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            c.remove("+");
        });
    }
    @Test
    public void testEmpty(){
        assertEquals(3,c.size());
        c.empty();
        assertEquals(0,c.size());
    }
}
