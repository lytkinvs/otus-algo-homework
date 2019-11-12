package algebraic;

import storage.VectorArray;

public class PrimeByEratosOptimA implements IPrime {
    private int n;
    private VectorArray<Long> primes;

    public PrimeByEratosOptimA(int n) {
        this.n = n;
    }

    @Override
    public Integer calculate() {
        if (n == 2) return 1;

        primes = new VectorArray<Long>(n / 32 + 1);

        for (var i = 0; i < n / 32 + 1; i++) {
            primes.add(Long.MAX_VALUE);
        }

        for (var i = 2; i * i <= n; i++) {

            var index = i / 32;
            var arrItem = primes.get(index);
            var arrIndex = i % 32;

            var mask = 1 << arrIndex;

            if ((arrItem & mask) != 0) {
                for (var j = i * i; j <= n; j += i) {
                    var jIndex = j / 32;
                    var jItem = primes.get(jIndex);

                    var aArrIndex = j % 32;
                    var newMask = ~(1 << aArrIndex);

                    var currItem = jItem & newMask;
                    primes.set(currItem, jIndex);
                }
            }

        }


        int counter = 0;
        for (var i = 2; i <= n; i++) {
            var index = i / 32;
            var arrItem = primes.get(index);
            var arrIndex = i % 32;

            var mask = 1 << arrIndex;

            if ((arrItem & mask) != 0) {
                counter++;
            }
        }
        return counter;
    }

}

