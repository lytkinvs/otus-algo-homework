package algebraic;

public class FibonacciByRecursion implements IFibonacci {
    private int n;

    public FibonacciByRecursion(int n) {
        this.n = n;
    }

    @Override
    public Integer calculate() {
        return fibo(n);
    }

    private int fibo(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;

        return fibo(n - 2) + fibo(n - 1);
    }

}
