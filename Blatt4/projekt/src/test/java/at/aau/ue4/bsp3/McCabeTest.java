package at.aau.ue4.bsp3;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class McCabeTest {
    @Test
    public void test() {
        assertEquals(3, McCabe.ggt(3,0));
    }

    @Test
    public void testPath2() {
        assertEquals(2, McCabe.ggt(2,10));
    }

    @Test
    public void testPath3() {
        assertEquals(5, McCabe.ggt(35,25));
    }
}
