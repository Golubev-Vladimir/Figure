package model;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class Circle extends Figure {
    private static final Logger LOG = getLogger(Circle.class);

    private final double radius;
    private double diameter;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
        LOG.info("Создан {}", name);
        setPerimeter();
        setSquare();
        setDiameter();
    }

    public double getRadius() {
        return radius;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter() {
        this.diameter = 2 * radius;
    }

    @Override
    public void setPerimeter() {
        this.perimeter = 2 * Math.PI * radius;
    }

    @Override
    public void setSquare() {
        this.square = Math.PI * Math.pow(Math.abs(radius), 2);
    }
}