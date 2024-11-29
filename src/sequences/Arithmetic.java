package sequences;

import exceptions.OutOfBoundsException;

public class Arithmetic extends Sequence {
    private int a1, diff;

    public Arithmetic(int a1, int diff) {
        super("Arithemtic");
        this.a1 = a1;
        this.diff = diff;
        initializeSequence();
    }

    @Override
    protected void initializeSequence() {
        int i = 1;
        int an;
        while ((an = a1 + (i - 1) * diff) <= max) {
            sequence.add(an);
            i++;
        }
    }

    @Override
    public int getSum(int n) throws OutOfBoundsException {
        if (n > sequence.size()) {
            throw new OutOfBoundsException("In getSum of Arithmetic sequence.", n);
        }
        return (2 * a1 + (n - 1) * diff) * n / 2;
    }
}
