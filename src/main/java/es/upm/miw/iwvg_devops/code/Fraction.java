package es.upm.miw.iwvg_devops.code;

import java.util.function.Consumer;

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

    public void add(Fraction fraction) {
        assert fraction != null;

        int CM = this.commonMultiple(this.denominator, fraction.getDenominator());
        this.numerator = this.numerator * fraction.getDenominator() + fraction.getNumerator() * this.denominator;
        this.denominator = CM;

        int GCD = this.greatestCommonDivisor(this.numerator, CM);
        this.reduceFractions(this, GCD);
    }

    public void multiply(Fraction fraction) {
        assert fraction != null;

        this.numerator = this.numerator * fraction.getNumerator();
        this.denominator = this.denominator * fraction.getDenominator();
        int GCD = this.greatestCommonDivisor(this.numerator, this.denominator);
        this.reduceFractions(this, GCD);
    }

    public void divide(Fraction fraction) {
        assert fraction != null;

        this.inverseFraction(fraction);
        this.multiply(fraction);
    }

    public void inverseFraction(Fraction fraction) {
        assert fraction != null;

        int numeratorToBecomeDenominator = fraction.getNumerator();
        fraction.setNumerator(fraction.getDenominator());
        fraction.setDenominator(numeratorToBecomeDenominator);
    }

    public int greatestCommonDivisor(int firstNumber, int secondNumber) {
        if (firstNumber == 0 || secondNumber == 0) {
            throw new IllegalArgumentException();
        }
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
        if (thisDenominator == 0 || fractionDenominator == 0) {
            throw new IllegalArgumentException();
        }

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
