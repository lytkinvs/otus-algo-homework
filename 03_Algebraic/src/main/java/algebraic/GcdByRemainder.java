package algebraic;

public class GcdByRemainder implements IGcd {
    private long a;
    private long b;

    public GcdByRemainder(long a, long b) {
        this.a = a;
        this.b = b;
    }

    public Long calculate() {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        return a;
    }
}
