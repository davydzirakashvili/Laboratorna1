package proxy;

public class CalculatorImpl implements Calculator {

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }
}