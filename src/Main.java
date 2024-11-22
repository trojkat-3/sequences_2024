import sequences.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        IntegerPrinter printerStdOut = new IntegerPrinter();
        IntegerPrinter printerFile = new IntegerPrinter("integers.txt");
        //Integers
        Sequence integers=new Integers();
        printerStdOut.print(integers);
        printerFile.print(integers);
        //Squares
        Sequence squares=new Squares();
        printerStdOut.print(squares);
        printerFile.print(squares);
        //Primes
        Sequence primes=new Primes();
        primes.setMax(10000);
        printerStdOut.print(primes);
        printerFile.print(primes);
        //Fibonacci numbers
        Sequence fibonacci=new Fibonacci();
        fibonacci.setMax(100000);
        printerStdOut.print(fibonacci);
        printerFile.print(fibonacci);
        //Fibonacci numbers
        Sequence fibonacci2=new Fibonacci(1,3);
        printerStdOut.print(fibonacci2);
        printerFile.print(fibonacci2);
    }
}