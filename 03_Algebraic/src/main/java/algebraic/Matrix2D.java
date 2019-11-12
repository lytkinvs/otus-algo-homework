package algebraic;

import java.math.BigInteger;

public class Matrix2D {
    public BigInteger a;
    public BigInteger b;
    public BigInteger c;
    public BigInteger d;

    public Matrix2D(int a, int b, int c, int d) {
        this.a = BigInteger.valueOf(a);
        this.b = BigInteger.valueOf(b);
        this.c = BigInteger.valueOf(c);
        this.d = BigInteger.valueOf(d);
    }

    public Matrix2D(BigInteger a, BigInteger b, BigInteger c, BigInteger d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Matrix2D multiply(Matrix2D right) {
        return new Matrix2D(
            this.a.multiply(right.a).add(this.b.multiply(right.c)),
            this.a.multiply(right.b).add(this.b.multiply(right.d)),
            this.c.multiply(right.a).add(this.d.multiply(right.c)),
            this.c.multiply(right.b).add(this.d.multiply(right.d))
        );
    }

    @Override
    public String toString() {
        return String.format(a + " " + b + " " + c + " " + d);
    }
}
