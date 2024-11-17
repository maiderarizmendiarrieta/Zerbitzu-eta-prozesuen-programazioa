public class Main {
    public static void main(String[] args) {
        Liburutegia liburutegia = new Liburutegia();

        new Langilea(liburutegia, "L1").start();
        new Langilea(liburutegia, "L2").start();

        new Ikaslea(liburutegia, "I1").start();
        new Ikaslea(liburutegia, "I2").start();
        new Ikaslea(liburutegia, "I3").start();
    }
}
