package sequences;

public class Integers extends Sequence {

    public Integers(){
        super("Integers");
        initializeSequence();
    }

    @Override
    protected void initializeSequence() {
        for (int i = 1; i <= max; i++) {
            sequence.add(i);
        }
    }
}
