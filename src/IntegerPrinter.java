import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class IntegerPrinter {
    private static final int MAX_IN_LINE = 20;
    private static final String OUTPUT_PATH = "output/";

    private String fileName;

    public IntegerPrinter() {
        fileName = null;
    }

    public IntegerPrinter(String fileName) {
        this.fileName = fileName;
        try (FileWriter fr = new FileWriter(OUTPUT_PATH + fileName)) {
            fr.write("");
        } catch (IOException ex) {
            System.out.println("Can't write to file: " + fileName);
        }
    }

    private int getNumberOfDigits(int n) {
        int nd = 0;
        while (n > 0) {
            nd++;
            n = (n - n % 10) / 10;
        }
        return nd;
    }

    public void print(ArrayList<Integer> numbers, String title) {
        String out = "\n" + title + ":\n";
        for (int i = 0; i < numbers.size(); i++) {
            int nd = getNumberOfDigits(numbers.get(i));
            int maxLength = getNumberOfDigits(Collections.max(numbers));
            for (int j = 0; j < maxLength - nd; j++) {
                out += " ";
            }
            out += Integer.toString(numbers.get(i));
            if (i < numbers.size() - 1) {
                out += ", ";
            }
            if ((i + 1) % MAX_IN_LINE == 0 && i + 1 != numbers.size()) {
                out += "\n";
            }
        }
        if (fileName != null) {
            //String fName = "output/integers.txt";
            try (FileWriter fr = new FileWriter(OUTPUT_PATH + fileName, true)) {
                fr.append(out);
            } catch (IOException ex) {
                System.out.println("Can't create file: " + fileName);
            }
        } else {
            System.out.println(out);
        }
    }
}
