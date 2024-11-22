package sequences;

import java.util.ArrayList;

abstract public class Sequence {
    protected int max=1000;
    protected String name;
    protected ArrayList<Integer> sequence=new ArrayList<>();

    public Sequence(String name){
       this.name=name;
    }

    public void setMax(int max){
        this.max=max;
        sequence.clear();
        initializeSequence();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getSequence() {
        return sequence;
    }

    abstract protected void initializeSequence();
}
