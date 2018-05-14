package com.caoO.algorithms.numbers;

import com.caoO.algorithms.CMath;

import java.util.Objects;

public class Rational {

    private int numerator;
    private int denominator;

    public Rational() {
    }

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Plus a specified Rational.
     * @param b the specified Rational
     * @return the result Rational
     */
    public Rational plus(Rational b) {
        int newNumerator = this.getNumerator() * b.getDenominator() + this.getDenominator() * b.getNumerator();
        int newDenominator = this.getDenominator() * b.getDenominator();
        return new Rational(newNumerator, newDenominator).fractionReduction();
    }

    /**
     * Minus a specified Rational.
     * @param b the specified Rational
     * @return the result Rational
     */
    public Rational minus(Rational b) {
        int newNumerator = this.getNumerator() * b.getDenominator() - this.getDenominator() * b.getNumerator();
        int newDenominator = this.getDenominator() * b.getDenominator();
        return new Rational(newNumerator, newDenominator).fractionReduction();
    }

    /**
     * Times a specified Rational.
     * @param b the specified Rational
     * @return the result Rational
     */
    public Rational times(Rational b) {
        int newNumerator = this.getNumerator() * b.getNumerator();
        int newDenominator = this.getDenominator() * b.getDenominator();
        return new Rational(newNumerator, newDenominator).fractionReduction();
    }

    /**
     * Divides a specified Rational.
     * @param b the specified Rational
     * @return the result Rational
     */
    public Rational divides(Rational b) {
        int newNumerator = this.getNumerator() * b.getDenominator();
        int newDenominator = this.getDenominator() * b.getNumerator();
        return new Rational(newNumerator, newDenominator).fractionReduction();
    }

    /**
     * Reduction of a fraction.
     * @return the result Rational after reduction
     */
    public Rational fractionReduction() {
        int gcd = CMath.gcd(numerator, denominator);
        return new Rational(numerator / gcd, denominator / gcd);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rational rational = ((Rational) o).fractionReduction();
        Rational temp = this.fractionReduction();
        return temp.getNumerator() == rational.getNumerator() && temp.getDenominator() == rational.getDenominator();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fractionReduction().getNumerator(), this.fractionReduction().getDenominator());
    }

    @Override
    public String toString() {
        return "Rational{ " + numerator + "/" + denominator + " }";
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
}
