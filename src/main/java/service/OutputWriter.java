package service;

import model.Circle;
import model.Figure;
import model.Rectangle;
import model.Triangle;
import org.slf4j.Logger;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import static org.slf4j.LoggerFactory.getLogger;
import static service.Command.getRuleWrite;

public class OutputWriter {
    private static final Logger LOG = getLogger(OutputWriter.class);
    PrintWriter output = getRuleWrite();
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private final String distanceFormat = " мм.";
    private final String angleFormat = " градусов";

    public OutputWriter() throws FileNotFoundException {
        //при отсутствии файла
    }

    public void writeGeneralParams(Figure figure) {
        output.println("Тип фигуры: " + figure.getName());
        output.println("Площадь: " + decimalFormat.format(figure.getSquare()) + " кв." + distanceFormat);
        output.println("Периметр: " + decimalFormat.format(figure.getPerimeter()) + distanceFormat);
        output.flush();
        LOG.info("Основные параметры фигуры записаны");
    }

    public void writeCircle(Circle circle) {
        writeGeneralParams(circle);
        output.println("Радиус: " + decimalFormat.format(circle.getRadius()) + distanceFormat);
        output.println("Диаметр: " + decimalFormat.format(circle.getDiameter()) + distanceFormat);
        output.flush();
        LOG.info("Расчеты для круга записаны");
        output.close();
    }

    public void writeRectangle(Rectangle rectangle) {
        writeGeneralParams(rectangle);
        output.println("Длина диагонали: " + decimalFormat.format(rectangle.getDiagonal()) + distanceFormat);
        output.println("Длина: " + decimalFormat.format(rectangle.getLongSide()) + distanceFormat);
        output.println("Ширина: " + decimalFormat.format(rectangle.getShortSide()) + distanceFormat);
        output.flush();
        output.close();
        LOG.info("Расчеты для прямоугольника записаны");
    }

    public void writeTriangle(Triangle triangle) {
        writeGeneralParams(triangle);
        output.println("Длина стороны А: " + decimalFormat.format(triangle.getLengthSideA()) +
                distanceFormat + " и противолежащий угол: " + decimalFormat.format(triangle.getAngleA()) + angleFormat);

        output.println("Длина стороны В: " + decimalFormat.format(triangle.getLengthSideB()) +
                distanceFormat + " и противолежащий угол: " + decimalFormat.format(triangle.getAngleB()) + angleFormat);

        output.println("Длина стороны С: " + decimalFormat.format(triangle.getLengthSideC()) +
                distanceFormat + " и противолежащий угол: " + decimalFormat.format(triangle.getAngleC()) + angleFormat);
        output.flush();
        output.close();
        LOG.info("Расчет для треугольника записаны");
    }
}