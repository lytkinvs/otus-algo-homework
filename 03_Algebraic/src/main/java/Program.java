import algebraic.*;

class Program {

    public static void main(String args[]) {


//        IGcd gcdByDivision = new GcdByDivision(123192312, 12);
//        IGcd gcdByRemainder = new GcdByRemainder(123192312, 12);
//
//        testGcd(gcdByDivision);
//        testGcd(gcdByRemainder);

//        IPower powerByPowerOf2 = new PowerByPowerOf2(121234, 121234);
//        IPower powerByMultiply = new PowerByMultiply(121234, 121234);
//        IPower powerByUsingPW2 = new PowerByUsingPw2(121234, 121234);
//
//
//
//        testPow(powerByPowerOf2);
//        testPow(powerByUsingPW2);
//        testPow(powerByMultiply);


//        IFibonacci fibonacciByRecursion = new FibonacciByRecursion(20);
//        IFibonacci fibonacciByIteration = new FibonacciByIteration(100);
//        IFibonacci fibonacciByGoldenrat = new FibonacciByGoldenRat(100);
//        IFibonacci fibonacciByMatrixMul = new FibonacciByMatrixMul(100);
//
//
//        testFib(fibonacciByRecursion);
//        testFib(fibonacciByIteration);
//        testFib(fibonacciByGoldenrat);
//        testFib(fibonacciByMatrixMul);


        IPrime primeByDirectSearch = new PrimeByDirectSearch(1500000);
        IPrime primeByDirectArSrch = new PrimeByDirectArSrch(1500000);
        IPrime primeByEratosSimple = new PrimeByEratosSimple(1500000);
        IPrime primeByEratosOptimA = new PrimeByEratosOptimA(1500000);

        testPrm(primeByDirectSearch);
        testPrm(primeByDirectArSrch);
        testPrm(primeByEratosSimple);
        testPrm(primeByEratosOptimA);

    }

    public static void testGcd(IGcd gcd) {

        long start = System.currentTimeMillis();

        var result = gcd.calculate();

        long duration = System.currentTimeMillis() - start;

        System.out.println(
            "Calculate gcd: " + gcd +
                " " + result +
                " " + duration + " ms"
        );
    }

    public static void testPow(IPower power) {

        long start = System.currentTimeMillis();

        var result = power.calculate();

        long duration = System.currentTimeMillis() - start;

        System.out.println(
            "Calculate power: " + power +
//                " " + result +
                " " + duration + " ms"
        );
    }

    public static void testFib(IFibonacci fibo) {

        long start = System.currentTimeMillis();

        var result = fibo.calculate();

        long duration = System.currentTimeMillis() - start;

        System.out.println(
            "Calculate fibo: " + fibo +
                " " + result +
                " " + duration + " ms"
        );
    }

    public static void testPrm(IPrime prime) {

        long start = System.currentTimeMillis();

        var result = prime.calculate();

        long duration = System.currentTimeMillis() - start;

        System.out.println(
            "Calculate fibo: " + prime +
                " " + result +
                " " + duration + " ms"
        );
    }
}
