package algebraic;

import storage.VectorArray;

public class PrimeByEratosSimple implements IPrime {
    private int n;
    private VectorArray<Boolean> primes;

    public PrimeByEratosSimple(int n) {
        this.n = n;
    }

    @Override
    public Integer calculate() {


        if(n == 2) return 1;
        primes = new VectorArray<Boolean>(n + 1);

        for (var i = 0; i < n; i++) {
            primes.add(true);
        }

        for (var i = 2; i * i <= n; i++) {
            if (primes.get(i)) {
                for (var j = i * i; j <= n; j+=i) {
                    primes.set(false, j);
                }
            }
        }

        int counter = 0;
        for (var i = 2; i < n; i++) {
            if(primes.get(i)) {
                counter++;
            }
        }

        return counter;
    }

}

