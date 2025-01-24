import exceptions.CantDecomposeException;
import exceptions.OutOfBoundsException;
import gui.MainFrame;
import printers.PrinterFile;
import printers.PrinterStdOut;
import sequences.*;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        MainFrame frame=new MainFrame();
        frame.setTitle("Sequences");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        PrinterStdOut printerStdOut = new PrinterStdOut();
        PrinterFile printerFile = new PrinterFile("integers.txt");
        //Integers
        Sequence integers = new Integers();
        printerStdOut.print(integers);
        printerFile.print(integers);
        //Squares
        Sequence squares = new Squares();
        printerStdOut.print(squares);
        printerFile.print(squares);
        //Primes
        Sequence primes = new Primes();
        primes.setMax(10000);
        printerStdOut.print(primes);
        printerFile.print(primes);
        //Fibonacci numbers
        Sequence fibonacci = new Fibonacci();
        fibonacci.setMax(100000);
        printerStdOut.print(fibonacci);
        printerFile.print(fibonacci);
        //Fibonacci numbers
        Sequence fibonacci2 = new Fibonacci(1, 3);
        printerStdOut.print(fibonacci2);
        printerFile.print(fibonacci2);
        //Arithmetic sequence
        Sequence arithmetic = new Arithmetic(-7, 3);
        printerStdOut.print(arithmetic);
        printerFile.print(arithmetic);

        try {
            System.out.println(primes.decompose(1234));

            printerStdOut.printDecomposition(squares.decompose(1234));

            System.out.println(squares.decompose(1234));
            System.out.println(primes.decompose(32));
        } catch (CantDecomposeException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(arithmetic.getSum(5));
        } catch (OutOfBoundsException ex) {
            System.out.println("The program is running OK, however: " + ex.getMessage());
        }

        try {
            System.out.println(fibonacci.getSum(100));
        } catch (OutOfBoundsException ex) {
            System.out.println("The program is running OK, however: " + ex.getMessage());
        }
    }
}