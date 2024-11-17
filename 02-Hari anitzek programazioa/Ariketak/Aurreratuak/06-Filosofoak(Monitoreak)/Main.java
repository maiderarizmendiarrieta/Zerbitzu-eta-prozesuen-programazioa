public class Main {
    public static void main(String[] args) {
        Zotza zotza1 = new Zotza(1);
        Zotza zotza2 = new Zotza(2);
        Zotza zotza3 = new Zotza(3);
        Zotza zotza4 = new Zotza(4);
        Zotza zotza5 = new Zotza(5);
        FilosofoThread f1 = new FilosofoThread(1, zotza1, zotza2);
        FilosofoThread f2 = new FilosofoThread(2, zotza2, zotza3);
        FilosofoThread f3 = new FilosofoThread(3, zotza3, zotza4);
        FilosofoThread f4 = new FilosofoThread(4, zotza4, zotza5);
        FilosofoThread f5 = new FilosofoThread(5, zotza5, zotza1);

        f1.start();
        f2.start();
        f3.start();
        f4.start();
        f5.start();
    }
    
}
