package algebraic;

import java.math.BigDecimal;

public class PowerByPowerOf2 implements IPower {
    private int power;
    private double n;

    public PowerByPowerOf2(double n, int power) {
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

        BigDecimal result = BigDecimal.valueOf(1);
        int powCounter = 0;

        while (power > 0) {
            if (power % 2 == 1) {
                BigDecimal tmp = BigDecimal.valueOf(n);
                for (var currentPower = 0; currentPower < powCounter; currentPower++) {
                    tmp = tmp.multiply(tmp);
                }
                result = result.multiply(tmp);
            }
            powCounter += 1;
            power = power / 2;
        }

        return result;
    }
}
