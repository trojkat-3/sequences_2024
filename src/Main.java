import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static final int MAX = 700;
    private static final int MAX_LENGTH = getNumberOfDigits(MAX);
    private static final int MAX_IN_LINE = 20;
    private static final boolean WRITE_TO_FILE = false;

    private static int getNumberOfDigits(int n) {
        int nd = 0;
        while (n > 0) {
            nd++;
            n = (n - n % 10) / 10;
        }
        return nd;
    }

    private static String getFormatedNumbers() {
        String out = "";
        for (int i = 1; i <= MAX; i++) {
            int nd = getNumberOfDigits(i);
            for (int j = 0; j < MAX_LENGTH - nd; j++) {
                out += " ";
            }
            out += Integer.toString(i);
            if (i < MAX) {
                out += ", ";
            }
            if (i % MAX_IN_LINE == 0) {
                out += "\n";
            }
        }
        return out;
    }

    public static void main(String[] args) {
        String out=getFormatedNumbers();
        if (WRITE_TO_FILE) {
            String fName = "output/integers.txt";
            try (FileWriter fr = new FileWriter(fName)) {
                fr.write(out);
            } catch (IOException ex) {
                System.out.println("Can't create file: " + fName);
            }
        } else {
            System.out.println(out);
        }
    }
}