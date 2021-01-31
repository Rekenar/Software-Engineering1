package at.aau.ue5.bsp5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTest {

    Fraction f;
    Fraction reduced;
    MyMath mm;
    Double aDouble;

    @BeforeEach
    public void beforeEach(){
        mm = new MyMath();
        aDouble = null;
    }

    @Test
    public void Should_AssertEquals_WhenNumeratorAndDenumeraterAreOne(){
        f = new Fraction(1, 1);
        reduced = mm.reduce(f);
        assertEquals(Integer.valueOf(1), reduced.getNumerator());
        assertEquals(Integer.valueOf(1), reduced.getDenumerator());
    }
    @Test
    public void Should_AssertEquals_WhenNumeratorAndDenumeraterAreTenAndSix(){
        f = new Fraction(10, 6);
        reduced = mm.reduce(f);
        assertEquals(Integer.valueOf(5), reduced.getNumerator());
        assertEquals(Integer.valueOf(3), reduced.getDenumerator());
    }
    @Test
    public void Should_AssertEquals_WhenNumeratorAndDenumeraterAreTenAndFive(){
        f = new Fraction(10, 5);
        reduced = mm.reduce(f);
        assertEquals(Integer.valueOf(2), reduced.getNumerator());
        assertEquals(Integer.valueOf(1), reduced.getDenumerator());
    }
    @Test
    public void Should_AssertEquals_WhenToDoubleReturnsTwo(){
        f = new Fraction(10, 5);
        aDouble = mm.toDouble(f);
        assertEquals(Double.valueOf(2), aDouble);
    }
    @Test
    public void Should_AssertEquals_WhenToDoubleReturnsTwoPointFive(){
        f = new Fraction(10, 4);
        aDouble = mm.toDouble(f);
        assertEquals(Double.valueOf(2.5d), aDouble);
    }
    @Test
    public void Should_AssertEquals_WhenToDoubleReturnsDoublePointNaN(){
        f = new Fraction(10, 0);
        aDouble = mm.toDouble(f);
        Assertions.assertTrue(aDouble.equals(Double.NaN));
    }
    @Test
    public void Should_ReturnThree_WhenNumeratorIsChangedAndThree(){
        f = new Fraction(10, 5);
        Assertions.assertEquals(Integer.valueOf(10),f.getNumerator());
        f.setNumerator(3);
        Assertions.assertEquals(Integer.valueOf(3),f.getNumerator());
    }
    @Test
    public void Should_ReturnThree_WhenDeNumeratorIsChangedAndThree(){
        f = new Fraction(10, 5);
        Assertions.assertEquals(Integer.valueOf(5),f.getDenumerator());
        f.setDenumerator(3);
        Assertions.assertEquals(Integer.valueOf(3),f.getDenumerator());
    }
    @Test
    public void Should_ReturnTrue_WhenFractionEqualsFraction(){
        f = new Fraction(10, 5);
        Fraction d = f;
        Assertions.assertTrue(f.equals(d));
    }
    @Test
    public void Should_ReturnFalse_WhenFractionEqualsNull(){
        f = new Fraction(10, 5);
        Assertions.assertFalse(f.equals(null));
    }
    @Test
    public void Should_ReturnFalse_WhenFractionEqualsMyMath(){
        f = new Fraction(10, 5);
        Assertions.assertFalse(f.equals(mm));
    }
    @Test
    public void Should_ReturnFalse_WhenFractionNumeratorEqual(){
        f = new Fraction(10, 5);
        Fraction d = new Fraction(10,2);
        Assertions.assertFalse(f.equals(d));
    }
    @Test
    public void Should_ReturnTrue_WhenFractionFieldsEqual(){
        f = new Fraction(10, 5);
        Fraction d = new Fraction(10,5);
        Assertions.assertTrue(f.equals(d));
    }
    @Test
    public void Should_ReturnFalse_WhenFractionFieldsEqual(){
        f = new Fraction(9, 5);
        Fraction d = new Fraction(10,5);
        Assertions.assertFalse(f.equals(d));
    }
    @Test
    public void Should_ReturnFalse_WhenFractionFNumeratorIsNull(){
        f = new Fraction(null, 5);
        Fraction d = new Fraction(10,5);
        Assertions.assertFalse(f.equals(d));
    }

    @Test
    public void Should_ReturnThreeHundredFifteen_WhenFractionFieldsAreNotNull(){
        f = new Fraction(10, 5);
        Assertions.assertEquals(315,f.hashCode());
    }
    @Test
    public void Should_ReturnFive_WhenFractionDeNumeratorIsNotNull(){
        f = new Fraction(null, 5);
        Assertions.assertEquals(5,f.hashCode());
    }
    @Test
    public void Should_ReturnThreeHundredAndTen_WhenFractionDeNumeratorIsNotNull(){
        f = new Fraction(10, null);
        Assertions.assertEquals(310,f.hashCode());
    }
    @Test
    public void Should_ReturnCorrectString_WhenToStringIsCalled(){
        f = new Fraction(10, 5);
        Assertions.assertEquals("Fraction{numerator=10, denumerator=5}",f.toString());
    }
}
