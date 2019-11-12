package algebraic;

import storage.SingleArray;
import storage.VectorArray;

public class PrimeByDirectSearch implements IPrime {
    private int n;

    public PrimeByDirectSearch(int n) {
        this.n = n;
    }

    @Override
    public Integer calculate() {

        VectorArray<Integer> array = new VectorArray<>(n + 1);
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                array.add(i);
            }
        }
        return array.size();
    }

    private boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if ((x % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
