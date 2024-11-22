package sequences;

public class Squares extends Sequence {

    public Squares() {
        super("Squares");
        initializeSequence();
    }

    @Override
    protected void initializeSequence() {
        for (int i = 1; i * i <= max; i++) {
            sequence.add(i * i);
        }
    }
}
