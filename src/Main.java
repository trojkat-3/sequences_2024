import java.util.ArrayList;

public class Main {
    private static final int MAX = 10000;

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int fibonacci(int n, ArrayList<Integer> fn) {
        if (n <= 1) {
            return n;
        } else if (fn.size() > n) {
            return fn.get(n);
        } else {
            return fibonacci(n - 1, fn) + fibonacci(n - 2, fn);
        }
    }

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