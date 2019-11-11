import storage.*;

class Program {
    public static void main(String args[]) {

        IArray<String> singleArray = new SingleArray<>();

        IArray<String> vectorArray = new VectorArray<>(1000);

        IArray<String> factorArray = new FactorArray<>();

        IArray<String> matrixArray = new MatrixArray<>(1000);

        IArray<String> linkedArray = new LinkedArray<>();


        addValues(linkedArray, 10000);
        addValues(matrixArray, 10000);
        addValues(factorArray, 10000);
        addValues(vectorArray, 10000);

//
//        getValues(linkedArray, 100000);
//        getValues(matrixArray, 100000);
//        getValues(factorArray, 100000);
//        getValues(vectorArray, 100000);

//        testStack();
//        testQueue();

    }

    private static void addValues(IArray<String> array, int count) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            array.add(i + "");
        }

        long duration = System.currentTimeMillis() - start;

        System.out.println(
            "Add " + array +
                " " + count +
                " " + duration + " ms"
        );
    }

    private static void getValues(IArray<String> array, int count) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            array.get(i);
        }

        long duration = System.currentTimeMillis() - start;

        System.out.println(
            "Get " + array +
                " " + count +
                " " + duration + " ms"
        );
    }

    private static void testStack() {
        Stack stack = new Stack<String>();

        stack.push("Mix");
        stack.push("Vova");
        stack.push("Qix");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void testQueue() {
        Queue<String> queue = new Queue<>();

        queue.enqueue("Mix");
        queue.enqueue("Vova");
        queue.enqueue("Qix");

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
