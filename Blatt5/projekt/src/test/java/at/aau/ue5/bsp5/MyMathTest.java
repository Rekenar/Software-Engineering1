package at.aau.ue5.bsp5;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyMathTest {

    Double x = 10d;
    Double y = 5d;
    MyMath myMath;

    @BeforeEach
    public void beforeEach(){
        myMath = new MyMath();
    }

    @Test
    public void Should_AssertTrue_WhenAddIsFifteen() {
        assertTrue(myMath.add(x,y).equals(15d));
    }
    @Test
    public void Should_AssertTrue_WhenSubIsFive() {
        assertTrue(myMath.sub(x,y).equals(5d));
    }
    @Test
    public void Should_AssertTrue_WhenMulIsFifty() {
        assertTrue(myMath.mul(x,y).equals(50d));
    }
    @Test
    public void Should_AssertTrue_WhenDivIsTwo() {
        assertTrue(myMath.div(x,y).equals(2d));
    }
    @Test
    public void Should_AssertTrue_WhenDivIsNaN() {
        assertTrue(myMath.div(x,y-y).equals(Double.NaN));
    }
}
