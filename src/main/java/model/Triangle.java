package model;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class Triangle extends Figure {
    private static final Logger LOG = getLogger(Triangle.class);

    private final double lengthSideA;
    private final double lengthSideB;
    private final double lengthSideC;

    private double angleA;
    private double angleB;
    private double angleC;

    public Triangle(String name, double lengthSideA, double lengthSideB, double lengthSideC) {
        super(name);
        this.lengthSideA = lengthSideA;
        this.lengthSideB = lengthSideB;
        this.lengthSideC = lengthSideC;
        LOG.info("Создан {}", name);
        setPerimeter();
        setSquare();
        setAngleABC();
    }

    public double getLengthSideA() {
        return lengthSideA;
    }

    public double getLengthSideB() {
        return lengthSideB;
    }

    public double getLengthSideC() {
        return lengthSideC;
    }

    public double getAngleA() {
        return angleA;
    }

    public double getAngleB() {
        return angleB;
    }

    public double getAngleC() {
        return angleC;
    }

    public void setAngleABC() {
        angleA = Math.toDegrees(Math.acos((Math.pow(lengthSideB, 2)
                + Math.pow(lengthSideC, 2) - Math.pow(lengthSideA, 2))
                / (2 * lengthSideB * lengthSideC)));

        angleB = Math.toDegrees(Math.acos((Math.pow(lengthSideA, 2)
                + Math.pow(lengthSideC, 2) - Math.pow(lengthSideB, 2))
                / (2 * lengthSideA * lengthSideC)));

        angleC = Math.toDegrees(Math.acos((Math.pow(lengthSideA, 2)
                + Math.pow(lengthSideB, 2) - Math.pow(lengthSideC, 2))
                / (2 * lengthSideA * lengthSideB)));
    }

    @Override
    public void setPerimeter() {
        this.perimeter = lengthSideA + lengthSideB + lengthSideC;
    }

    @Override
    public void setSquare() {
        this.square = Math.sqrt(perimeter / 2.0 * (perimeter / 2.0 - lengthSideA)
                * (perimeter / 2.0 - lengthSideB)
                * (perimeter / 2.0 - lengthSideC));
    }
}