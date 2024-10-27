

public class Main {
    public static void main(String[] args) {
        FibonacciThread fT1 = new FibonacciThread(5);
        FibonacciThread fT2 = new FibonacciThread(12);

        fT1.start();
        fT2.start();
    }
}
