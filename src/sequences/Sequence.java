package sequences;

import exceptions.CantDecomposeException;
import exceptions.OutOfBoundsException;

import java.util.ArrayList;
import java.util.Collections;

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

    public ArrayList<Integer> decompose(int n) throws CantDecomposeException {
        int nBac=n;
        ArrayList<Integer> lst = new ArrayList<>(sequence); //shallow copy
        Collections.sort(lst, Collections.reverseOrder());
        ArrayList<Integer> ret = new ArrayList<>();
        int i = 0;
        while (n > 0 && i < lst.size()) {
            if (lst.get(i) <= n) {
                ret.add(lst.get(i));
                n -= lst.get(i);
            } else {
                i++;
            }
        }
        if (n>0){
            throw new CantDecomposeException(getName(),nBac);
        }
        return ret;
    }

    abstract protected void initializeSequence();
}
