import storage.*;

class Program {
    public static void main(String args[]) {
//        IArray<String> vectorArray = new VectorArray<>(1000);
//        IArray<String> factorArray = new FactorArray<>();
//        IArray<String> matrixArray = new MatrixArray<>(500);
//        IArray<String> linkedArray = new LinkedArray<>();
//
//        addValues(linkedArray, 10000);
//        addValues(matrixArray, 10000);
//        addValues(factorArray, 10000);
//        addValues(vectorArray, 10000);
//
//        getValues(linkedArray, 10000);
//        getValues(matrixArray, 10000);
//        getValues(factorArray, 10000);
//        getValues(vectorArray, 10000);
//
//        addValuesToIndex(linkedArray, 10000);
//        addValuesToIndex(matrixArray, 10000);
//        addValuesToIndex(factorArray, 10000);
//        addValuesToIndex(vectorArray, 10000);
//
//        remove(linkedArray, 10000);
//        remove(matrixArray, 10000);
//        remove(factorArray, 10000);
//        remove(vectorArray, 10000);

//        testStack();
//        testPriorityQueue();

//        System.out.println(factorArray);
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

    private static void addValuesToIndex(IArray<String> array, int count) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            array.add(i + "", count / 2);
        }

        long duration = System.currentTimeMillis() - start;

        System.out.println(
            "Idx " + array +
                " " + count +
                " " + duration + " ms"
        );
    }

    private static void remove(IArray<String> array, int count) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++)
            array.remove(array.size() / 2);

        long duration = System.currentTimeMillis() - start;

        System.out.println(
            "Rem " + array +
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

    private static void testPriorityQueue() {
        PriorityQueue<String> queue = new PriorityQueue<>();

        queue.enqueue("Fix2", 0);
        queue.enqueue("Vova", 1);
        queue.enqueue("Qix1", 2);

        queue.enqueue("List", 2);
        queue.enqueue("Vika", 0);
        queue.enqueue("MAHA", 1);

        queue.enqueue("Tome", 2);
        queue.enqueue("Mark", 4);
        queue.enqueue("Lisa", 5);

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
