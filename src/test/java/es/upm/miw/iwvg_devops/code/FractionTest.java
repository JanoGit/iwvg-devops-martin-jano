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
    void testConstructorWithParametersAndAllMethods() {
        Fraction fraction = new Fraction(2, 5);
        assertNotEquals(fraction.getNumerator(), fraction.getDenominator());
        assertEquals(0.4, fraction.decimal());

        fraction.setNumerator(8);
        fraction.setDenominator(7);
        assertEquals(fraction.getNumerator(), (fraction.getDenominator() + 1));
    }

}
