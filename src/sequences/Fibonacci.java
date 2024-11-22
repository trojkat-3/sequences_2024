package sequences;

import java.util.ArrayList;

public class Fibonacci extends Sequence {
    private int[] fInit={0,1};

    public Fibonacci() {
        super("Fibonacci");
        initializeSequence();
    }

    public Fibonacci(int f0, int f1){
        super("Fibonacci ["+f0+","+f1+"]");
        fInit[0]=f0;
        fInit[1]=f1;
        initializeSequence();
    }

    @Override
    protected void initializeSequence() {
        int f;
        for (int i = 0; (f=fibonacci(i,sequence)) <= max; i++) {
            sequence.add(f);
        }
    }

    private int fibonacci(int n, ArrayList<Integer> fn) {
        if (n <= 1) {
            return fInit[n];
        } else if (fn.size() > n) {
            return fn.get(n);
        } else {
            return fibonacci(n - 1, fn) + fibonacci(n - 2, fn);
        }
    }
}
