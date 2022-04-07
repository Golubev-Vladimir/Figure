package model;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class Rectangle extends Figure {
    private static final Logger LOG = getLogger(Rectangle.class);

    private final double lengthFirstSide;
    private final double lengthSecondSide;

    private double shortSide;
    private double longSide;
    private double diagonal;

    public Rectangle(String name, double lengthFirstSide, double lengthSecondSide) {
        super(name);
        this.lengthFirstSide = lengthFirstSide;
        this.lengthSecondSide = lengthSecondSide;
        LOG.info("Создан {}", name);
        setPerimeter();
        setSquare();
        setLongShort();
        setDiagonal();
    }

    public double getDiagonal() {
        return diagonal;
    }

    public double getLongSide() {
        return longSide;
    }

    public double getShortSide() {
        return shortSide;
    }

    public void setLongShort() {
        if (lengthFirstSide > lengthSecondSide) {
            longSide = lengthFirstSide;
            shortSide = lengthSecondSide;
        } else {
            longSide = lengthSecondSide;
            shortSide = lengthFirstSide;
        }
    }

    public void setDiagonal() {
        this.diagonal = Math.sqrt(Math.pow(lengthFirstSide, 2) + Math.pow(lengthSecondSide, 2));
    }

    @Override
    public void setPerimeter() {
        this.perimeter = 2 * (lengthFirstSide + lengthSecondSide);
    }

    @Override
    public void setSquare() {
        this.square = lengthFirstSide * lengthSecondSide;
    }
}