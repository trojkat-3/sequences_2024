import sequences.Sequence;

import java.util.ArrayList;

public class Main {
    private static final int MAX = 10000;




    public static void main(String[] args) {


        IntegerPrinter printerStdOut = new IntegerPrinter();
        IntegerPrinter printerFile = new IntegerPrinter("integers.txt");
        //Integers
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 1; i <= MAX; i++) {
            lst.add(i);
        }
        printerStdOut.print(lst, "Integers");
        printerFile.print(lst, "Integers");
        //Squares
        lst.clear();
        for (int i = 1; i * i <= MAX; i++) {
            lst.add(i * i);
        }
        printerStdOut.print(lst, "Squares");
        printerFile.print(lst, "Squares");
        //Primes
        lst.clear();
        for (int i = 1; i <= MAX; i++) {
            if (isPrime(i)) {
                lst.add(i);
            }
        }
        printerStdOut.print(lst, "Primes");
        printerFile.print(lst, "Primes");
        //Fibonacci numbers
        lst.clear();
        int f;
        for (int i = 0; (f=fibonacci(i,lst)) <= MAX; i++) {
            lst.add(f);
        }
        printerStdOut.print(lst, "Fibonacci");
        printerFile.print(lst, "Fibonacci");
    }
}