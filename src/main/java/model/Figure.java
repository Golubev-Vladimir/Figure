package model;

public abstract class Figure {
    protected String name;
    protected double square;
    protected double perimeter;
    private final double scale = Math.pow(10, 2);

    protected Figure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPerimeter() {
        return Math.ceil(perimeter * scale) / scale;
    }

    public double getSquare() {
        return Math.ceil(square * scale) / scale;
    }

    public abstract void setPerimeter();

    public abstract void setSquare();
}