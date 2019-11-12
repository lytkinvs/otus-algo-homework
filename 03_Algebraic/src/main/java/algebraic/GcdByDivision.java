package algebraic;

public class GcdByDivision implements IGcd {
    private long a;
    private long b;

    public GcdByDivision(long a, long b) {
        this.a = a;
        this.b = b;
    }

    public Long calculate() {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
}
