package algebraic;

import java.math.BigInteger;

public class FibonacciByIteration implements IFibonacci {
    private int n;

    public FibonacciByIteration(int n) {
        this.n = n;
    }

    @Override
    public BigInteger calculate() {
        if (n == 1) return BigInteger.valueOf(1);
        if (n == 2) return BigInteger.valueOf(1);

        BigInteger x1 = BigInteger.valueOf(1);
        BigInteger x2 = BigInteger.valueOf(2);
        for(int x = 2; x < n - 1; x++) {
            x2 = x1.add(x2);
            x1 = x2.subtract(x1);
        }

        return x2;
    }
}
