package printers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrinterFile extends Printer {
    private File file;

    public PrinterFile(File file){
        this.file=file;
        try (FileWriter fr = new FileWriter(file)) {
            fr.write("");
        } catch (IOException ex) {
            System.out.println("Can't write to file: " + file.getName());
        }
    }

    @Override
    void output(String str) {
        try (FileWriter fr = new FileWriter(file, true)) {
            fr.append(str);
        } catch (IOException ex) {
            System.out.println("Can't create file: " + file.getName());
        }
    }
}
