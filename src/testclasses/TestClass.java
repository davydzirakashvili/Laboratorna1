package testclasses;

public class TestClass {

    private int x;
    private double y;

    public TestClass() {
        x = 10;
        y = 5.5;
    }

    public TestClass(int x, double y) {
        this.x = x;
        this.y = y;
    }

    public void printData() {
        System.out.println("x = " + x + ", y = " + y);
    }

    public double distance() {
        return Math.sqrt(x * x + y * y);
    }
}
