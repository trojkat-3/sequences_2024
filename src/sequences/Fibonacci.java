package sequences;

import java.util.ArrayList;

public class Fibonacci extends Sequence {

    public Fibonacci() {
        super("Fibonacci");
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
            return n;
        } else if (fn.size() > n) {
            return fn.get(n);
        } else {
            return fibonacci(n - 1, fn) + fibonacci(n - 2, fn);
        }
    }
}
