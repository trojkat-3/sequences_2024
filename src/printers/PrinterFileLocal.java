package printers;

import java.io.FileWriter;
import java.io.IOException;

public class PrinterFileLocal extends Printer {
    private static final String OUTPUT_PATH = "output/";
    private String fileName;

    public PrinterFileLocal(String fileName) {
        this.fileName = fileName;
        try (FileWriter fr = new FileWriter(OUTPUT_PATH + fileName)) {
            fr.write("");
        } catch (IOException ex) {
            System.out.println("Can't write to file: " + fileName);
        }
    }

    @Override
    void output(String str) {
        //String fName = "output/integers.txt";
        try (FileWriter fr = new FileWriter(OUTPUT_PATH + fileName, true)) {
            fr.append(str);
        } catch (IOException ex) {
            System.out.println("Can't create file: " + fileName);
        }
    }
}
