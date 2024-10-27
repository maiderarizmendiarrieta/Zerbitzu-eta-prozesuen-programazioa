
public class FibonacciThread extends Thread {
    private int n;
    private static final Object mutex = new Object();

    public FibonacciThread(int n) {
        this.n = n;
    }

    public void run() {
        synchronized(mutex) { 
            int n1 = 0;
            int n2 = 1;
            
            for (int i = 0; i < n; i++) {
                int n3 = n1 + n2;
                System.out.print(n3 + " ");
    
                n1 = n2;
                n2 = n3;

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }
}