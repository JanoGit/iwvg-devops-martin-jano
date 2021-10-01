package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {

    @Test
    void testConstructor() {
        Fraction fraction = new Fraction();
        assertEquals(fraction.getNumerator(), fraction.getDenominator());
    }

    @Test
    void testConstructorWithParameters() {
        Fraction fraction = new Fraction(2, 5);
        assertNotEquals(fraction.getNumerator(), fraction.getDenominator());
        assertEquals(0.4, fraction.decimal());

        fraction.setNumerator(8);
        fraction.setDenominator(7);
        assertEquals(fraction.getNumerator(), (fraction.getDenominator() + 1));
    }

    @Test
    void testAddMethod() {
        Fraction fraction = new Fraction(4, 6);
        Fraction fractionToBeAdded = new Fraction(2, 3);
        fraction.add(fractionToBeAdded);
        assertEquals(4, fraction.getNumerator());
        assertEquals(3, fraction.getDenominator());
    }

    @Test
    void testIsMethods() {
        Fraction fraction = new Fraction(2, 3);
        assertTrue(fraction.isProper());
        assertFalse(fraction.isImproper());
        Fraction fractionToBeEquivalent = new Fraction(4, 6);
        assertTrue(fraction.isEquivalent(fractionToBeEquivalent));
    }

    @Test
    void testMultiplyAndDivideMethods() {
        Fraction fraction = new Fraction(2, 3);
        Fraction fraction2 = new Fraction(4, 6);
        fraction.multiply(fraction2);
        assertEquals(4, fraction.getNumerator());
        assertEquals(9, fraction.getDenominator());
        fraction.divide(fraction2);
        assertEquals(2, fraction.getNumerator());
        assertEquals(3, fraction.getDenominator());
    }

}
