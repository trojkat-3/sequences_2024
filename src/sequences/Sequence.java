package sequences;

import exceptions.OutOfBoundsException;

import java.util.ArrayList;

abstract public class Sequence {
    protected int max = 1000;
    protected String name;
    protected ArrayList<Integer> sequence = new ArrayList<>();

    public Sequence(String name) {
        this.name = name;
    }

    public void setMax(int max) {
        this.max = max;
        sequence.clear();
        initializeSequence();
    }

    private String getName() {
        return name;
    }

    public String toString() {
        return name + ", max: " + max;
    }

    public ArrayList<Integer> getSequence() {
        return sequence;
    }

    public int getSum(int n) throws OutOfBoundsException {
        if (n > sequence.size()) {
            throw new OutOfBoundsException("In the 'getSum' function.", n);
        }
        int s = 0;
        for (int i = 0; i < n; i++) {
            s += sequence.get(i);
        }
        return s;
    }

    abstract protected void initializeSequence();
}
