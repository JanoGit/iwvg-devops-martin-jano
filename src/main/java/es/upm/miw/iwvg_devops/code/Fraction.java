package es.upm.miw.iwvg_devops.code;

/**
 * Conceptos: Las fracciones propias son aquellas cuyo numerador es menor que el denominador
 * <p>
 * Las fracciones impropias son aquellas cuyo numerador es mayor que el denominador
 * <p>
 * Dos fracciones son equivalentes cuando el producto de extremos (numerador de la primera por denominador de la segunda) es igual al
 * producto de medios (denominador de la primera por el numerador de la segunda)
 * <p>
 * Las fracciones irreducibles son aquellas que no se pueden simplificar, esto sucede cuando el numerador y el denominador son primos entre
 * sí
 * <p>
 * Reducir varias fracciones a común denominador consiste en convertirlas en otras equivalentes que tengan el mismo denominador
 * <p>
 * Comparar fracciones
 * <p>
 * Suma fracciones: En primer lugar se reducen los denominadores a común denominador, y se suman o se restan los numeradores de las
 * fracciones equivalentes obtenidas
 * <p>
 * Multiplicación: La multiplicación de dos fracciones es otra fracción que tiene: Por numerador el producto de los numeradores. Por
 * denominador el producto de los denominadores.
 * <p>
 * La división de dos fracciones es otra fracción que tiene: Por numerador el producto de los extremos. Por denominador el producto de los
 * medios. Invertir fraccion
 */

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public boolean isProper() {
        return this.numerator < this.denominator;
    }

    public boolean isImproper() {
        return this.numerator > this.denominator;
    }

    public boolean isEquivalent(Fraction fraction) {
        assert fraction != null;

        return this.numerator * fraction.getDenominator() == this.denominator * fraction.getNumerator();
    }

    public Fraction add(Fraction fraction) {
        assert fraction != null;

        Fraction calculatedFraction = new Fraction(this.numerator, this.denominator);
        this.changeNegativeDenominator(calculatedFraction);
        this.changeNegativeDenominator(fraction);
        int CM = this.commonMultiple(calculatedFraction.getDenominator(), fraction.getDenominator());
        calculatedFraction.setNumerator(calculatedFraction.getNumerator() * fraction.getDenominator() + fraction.getNumerator() * calculatedFraction.getDenominator());
        calculatedFraction.setDenominator(CM);

        int GCD = this.greatestCommonDivisor(calculatedFraction.getNumerator(), CM);
        this.reduceFractions(calculatedFraction, GCD);
        return calculatedFraction;
    }

    public void changeNegativeDenominator(Fraction fraction) {
        if (fraction.getDenominator() < 0) {
            fraction.setDenominator(-fraction.getDenominator());
            fraction.setNumerator(-fraction.getNumerator());
        }
    }

    public Fraction multiply(Fraction fraction) {
        assert fraction != null;

        Fraction calculatedFraction = new Fraction(this.numerator, this.denominator);
        calculatedFraction.setNumerator(calculatedFraction.getNumerator() * fraction.getNumerator());
        calculatedFraction.setDenominator(calculatedFraction.getDenominator() * fraction.getDenominator());
        int GCD = this.greatestCommonDivisor(calculatedFraction.getNumerator(), calculatedFraction.getDenominator());
        this.reduceFractions(calculatedFraction, GCD);
        return calculatedFraction;
    }

    public Fraction divide(Fraction fraction) {
        assert fraction != null;

        return this.multiply(this.inverseFraction(fraction));
    }

    public Fraction inverseFraction(Fraction fraction) {
        assert fraction != null;

        Fraction invertedFraction = new Fraction();
        invertedFraction.setNumerator(fraction.getDenominator());
        invertedFraction.setDenominator(fraction.getNumerator());
        return invertedFraction;
    }

    public int greatestCommonDivisor(int firstNumber, int secondNumber) {
        int auxiliaryNumber;
        while (secondNumber != 0) {
            auxiliaryNumber = secondNumber;
            secondNumber = firstNumber % auxiliaryNumber;
            firstNumber = auxiliaryNumber;
        }

        return firstNumber;
    }

    public void reduceFractions(Fraction fraction, int GCD) {
        assert fraction != null;

        fraction.setNumerator(fraction.getNumerator() / GCD);
        fraction.setDenominator(fraction.getDenominator() / GCD);
    }

    public int commonMultiple(int thisDenominator, int fractionDenominator) {
        return thisDenominator * fractionDenominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) this.numerator / this.denominator;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + this.numerator +
                ", denominator=" + this.denominator +
                '}';
    }

}
