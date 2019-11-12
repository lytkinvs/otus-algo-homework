package algebraic;

import java.math.BigDecimal;

public class PowerByMultiply implements IPower {

    private int power;
    private long n;

    public PowerByMultiply(long n, int power) {
        this.n = n;
        this.power = power;

        if (power < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public BigDecimal calculate() {
        if (power == 1) return BigDecimal.valueOf(n);
        if (power == 0) return BigDecimal.valueOf(1);
        int x = this.power;
        BigDecimal result = BigDecimal.valueOf(1);
        while (x > 0) {
            result = result.multiply(BigDecimal.valueOf(n));
            x--;
        }
        return result;
    }
}
