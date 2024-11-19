public class Main {
    public static void main(String[] args) {
        Zinema z = new Zinema();

        for (int i = 0; i < 30; i++){
            Bezeroa b = new Bezeroa(i, "null", z);
            b.start();
        }
    }
}
