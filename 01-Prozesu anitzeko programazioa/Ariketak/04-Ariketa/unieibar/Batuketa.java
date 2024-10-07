package unieibar;

import java.util.Scanner;

public class Batuketa {
    public static void main(String[] args) {
        int n1, n2, batura;
        Scanner in = new Scanner(System.in);
        System.out.println("Sartu zenbaki bat: ");
        n1 = in.nextInt();
        System.out.println("Sartu beste zenbaki bat: ");
        n2 = in.nextInt();
        in.close();

        batura = n1 + n2;
        System.out.println(n1 + " + " + n2 + " = " + batura);

    }
}