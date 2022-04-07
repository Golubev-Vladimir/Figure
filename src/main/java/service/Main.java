package service;

import org.apache.log4j.PropertyConfigurator;

import java.io.FileNotFoundException;

public class Main {
    public static String[] select;
    private static String path;

    public static void main(String[] args) throws FileNotFoundException {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        select = args;
        path = args[1];
        Handler handler = new Handler();
        handler.startReadWrite(path);
    }
}