package service;

import org.slf4j.Logger;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static org.slf4j.LoggerFactory.getLogger;

public class Command {
    private static final Logger LOG = getLogger(Command.class);

    private Command() {
    }

    public static PrintWriter getRuleWrite() throws FileNotFoundException {
        for (String arg : Main.select) {
            if (arg.equals("File")) {
                LOG.info("Выбран метод записи в файл");
                return new PrintWriter("FileOutput.txt");
            } else if (arg.equals("Console")) {
                LOG.info("Выбран метод вывода в консоль");
                return new PrintWriter(System.out);
            } else {
                LOG.error("Некорректные параметры ввода команд");
                break;
            }
        }
        return null;
    }
}