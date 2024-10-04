
public class Main {
    private static final int MAX = 2000;
    private static final int MAX_IN_LINE = 20;

    private static int getNumberOfDigits(int n) {
        int nd = 0;
        while (n > 0) {
            nd++;
            n = (n - n % 10) / 10;
        }
        return nd;
    }

    public static void main(String[] args) {
        System.out.println(getNumberOfDigits(1982736));
        for (int i = 1; i <= MAX; i++) {
            if (i < 10) {
                System.out.print("  ");
            } else if (i < 100) {
                System.out.print(" ");
            }
            System.out.print(i);
            if (i < MAX) {
                System.out.print(", ");
            }
            if (i % MAX_IN_LINE == 0) {
                System.out.print("\n");
            }
        }
    }
}