package sequences;

public class Primes extends Sequence {

    public Primes(){
        super("Primes");
        initializeSequence();
    }

    @Override
    protected void initializeSequence() {
        for (int i = 1; i <= max; i++) {
            if (isPrime(i)) {
                sequence.add(i);
            }
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
