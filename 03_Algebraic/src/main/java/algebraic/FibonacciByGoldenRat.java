package algebraic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class FibonacciByGoldenRat implements IFibonacci {
    private int n;
    private static final double Fi = (1 + Math.sqrt(5)) / 2;

    public FibonacciByGoldenRat(int n) {
        this.n = n;
    }

    @Override
    public BigInteger calculate() {

        var fiInPowerOfN = new PowerByPowerOf2(Fi, n).calculate();

        MathContext mc = new MathContext(20, RoundingMode.HALF_DOWN);
        var result = fiInPowerOfN.divide(BigDecimal.valueOf(Math.sqrt(5)), mc);

        return result.toBigInteger();
    }


}
