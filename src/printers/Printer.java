package printers;

import sequences.Sequence;

import java.util.ArrayList;
import java.util.Collections;

abstract public class Printer {
    private static final int MAX_IN_LINE = 20;

    abstract void output(String str);

    public String print(Sequence sq) {
        ArrayList<Integer> numbers=sq.getSequence();
        String out = "\n" + sq.toString() + ":\n";
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
        output(out);
        return out;
    }

    public String printDecomposition(ArrayList<Integer> list){
        int s=0;
        String str="";
        for (int a: list){
            str+=a+"+";
            s+=a;
        }
        str=str.substring(0,str.length()-1);
        str=s+" = "+str;
        output(str);
        return str;
    }

    private int getNumberOfDigits(int n) {
        int nd = 0;
        while (n > 0) {
            nd++;
            n = (n - n % 10) / 10;
        }
        return nd;
    }


}
