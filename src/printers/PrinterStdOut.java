package printers;

public class PrinterStdOut extends Printer {

    @Override
    void output(String str) {
        System.out.println(str);
    }
}
