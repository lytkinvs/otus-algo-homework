package algebraic;

import java.math.BigDecimal;

public class PowerByUsingPw2 implements IPower {
    private int power;
    private double n;

    public PowerByUsingPw2(double n, int power) {
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

        BigDecimal result = BigDecimal.valueOf(n);

        int currentPower;

        for (currentPower = 1; currentPower < power / 2; currentPower *= 2) {
            result = result.multiply(result);
        }

        for (; currentPower < power; currentPower++) {
            result = result.multiply(BigDecimal.valueOf(n));
        }

        return result;
    }
}
