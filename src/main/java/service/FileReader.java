package service;

import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.slf4j.LoggerFactory.getLogger;

public class FileReader {
    private static final Logger LOG = getLogger(FileReader.class);

    FileReader() {
    }

    public static String readFileContentsOrNull(String path) {
        try {
            String reader = Files.readString(Path.of(path));
            LOG.info("Файл прочитан, содержание:\n{}", reader);
            return reader;

        } catch (IOException e) {
            LOG.error("Файл не может быть прочитан. " +
                    "Возможно нужный файл не размещен в каталоге.");
            return "";
        }
    }
}