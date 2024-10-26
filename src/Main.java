import java.util.ArrayList;

public class Main {
    private static final int MAX = 700;

    public static void main(String[] args) {
        ArrayList<Integer> lst=new ArrayList<>();
        for (int i = 1; i <= MAX; i++) {
            lst.add(i*i);
        }
        IntegerPrinter printerStdOut=new IntegerPrinter();
        printerStdOut.print(lst);
        IntegerPrinter printerFile=new IntegerPrinter("output/integers.txt");
        printerFile.print(lst);
    }
}