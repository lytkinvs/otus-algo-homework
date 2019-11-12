package algebraic;

import java.math.BigInteger;

public class FibonacciByMatrixMul implements IFibonacci {
    private int n;

    public FibonacciByMatrixMul(int n) {
        this.n = n;
    }

    @Override
    public BigInteger calculate() {
        if (n == 1) return BigInteger.valueOf(1);
        if (n == 2) return BigInteger.valueOf(1);

        Matrix2D unit = new Matrix2D(0, 1, 1, 1);
        Matrix2D result = unit;

        int currentPower;

        for (currentPower = 1; currentPower < n / 2; currentPower *= 2) {
            result = result.multiply(result);
        }

        for (; currentPower < n; currentPower++) {
            result = result.multiply(unit);
        }

        return result.b;
    }


}
