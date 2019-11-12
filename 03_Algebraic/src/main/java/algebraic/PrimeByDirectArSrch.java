package algebraic;

import storage.VectorArray;

public class PrimeByDirectArSrch implements IPrime {
    private int n;
    private VectorArray<Integer> primes;

    public PrimeByDirectArSrch(int n) {
        this.n = n;
        this.primes = new VectorArray<>(n + 1);
        primes.add(2);
    }

    @Override
    public Integer calculate() {

        for (int i = 2; i <= n; i++) {
            isPrime(i);
        }
        return primes.size();
    }

    private boolean isPrime(int x) {
        if (x == 2) return true;
        for (int i = 0; primes.get(i) * primes.get(i) <= x; i++) {
            if ((x % primes.get(i) == 0)) {
                return false;
            }
        }
        primes.add(x);
        return true;
    }
}
