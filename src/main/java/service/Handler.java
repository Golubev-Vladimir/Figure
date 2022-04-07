package service;

import model.Circle;
import model.Rectangle;
import model.Triangle;
import org.slf4j.Logger;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import static org.slf4j.LoggerFactory.getLogger;
import static service.FileReader.readFileContentsOrNull;

public class Handler {
    private static final Logger LOG = getLogger(Handler.class);
    private static final Set<String> STRINGS = Set.of("CIRCLE", "RECTANGLE", "TRIANGLE");

    private final OutputWriter writer = new OutputWriter();
    private final ArrayList<Double> paramList = new ArrayList<>();

    private String[] nameContents;
    private String[] paramContents;
    private String name;
    private Scanner scanner;

    public Handler() throws FileNotFoundException {
        //при отсутствии файла
    }

    public void startReadWrite(String path) {
        String reader = readFileContentsOrNull(path);
        if (reader == null) {
            return;
        }

        if (inPutFileIsEmpty(reader)) {
            return;
        }

        if (!checkSetName()) {
            return;
        }

        switch (name) {
            case "CIRCLE":
                if (findParams(1)) {
                    Circle circle = new Circle(name, paramList.get(0));
                    writer.writeCircle(circle);
                }
                break;
            case "RECTANGLE":
                if (findParams(2)) {
                    Rectangle rectangle = new Rectangle(name, paramList.get(0), paramList.get(1));
                    writer.writeRectangle(rectangle);
                }
                break;

            case "TRIANGLE":
                if (findParams(3)) {
                    Triangle triangle = new Triangle(name, paramList.get(0), paramList.get(1), paramList.get(2));
                    writer.writeTriangle(triangle);
                }
                break;

            default:
                break;
        }
    }

    private boolean inPutFileIsEmpty(String reader) {
        try {
            String[] fileContents = reader.split("\r\n");
            nameContents = fileContents[0].trim().split(" ");
            paramContents = fileContents[1].trim().split(" ");
            return false;
        } catch (Exception e) {
            LOG.error("Файл пустой или отсутствуют данные в 1 и 2 строках");
            return true;
        }
    }

    private boolean checkSetName() {
        for (String note : nameContents) {
            if (STRINGS.contains(note.toUpperCase())) {
                name = note.toUpperCase();
                LOG.info("Форма фигуры определена - {}", name);
                return true;
            }
        }
        LOG.error("Некорректно указано название фигуры в 1 строке файле");
        return false;
    }

    public boolean findParams(int numberParams) {
        for (String paramContent : paramContents) {
            scanner = new Scanner(paramContent);
            if (scanner.hasNextDouble()) {
                paramList.add(Double.parseDouble(paramContent));
            }
        }
        scanner.close();
        if (paramList.size() < numberParams) {
            LOG.error("Проверьте вторую строку Файла. Отсутствует необходимый обьем параметров (числа)");
            return false;
        }
        return true;
    }
}