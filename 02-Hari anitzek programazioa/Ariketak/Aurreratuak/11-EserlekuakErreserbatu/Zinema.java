import java.util.concurrent.Semaphore;

public class Zinema {
    private Bezeroa[][] eserlekuak;
    private Semaphore[][] zinemaSemaphore;
    private int eserlekuTotalak;

    public Zinema() {
        this.eserlekuak = new Bezeroa[5][10];
        this.zinemaSemaphore = new Semaphore[5][10];

        // Inicializar los semáforos
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                zinemaSemaphore[i][j] = new Semaphore(1); // Cada asiento empieza disponible
            }
        }
        this.eserlekuTotalak = 50;
    }

    public synchronized void erreserbatu(Bezeroa bezeroa, int numEspacios) {
        try {
            // Buscar un bloque contiguo disponible
            for (int f = 0; f < 5; f++) {
                for (int c = 0; c <= 10 - numEspacios; c++) { // Limitar para no salir del rango
                    if (hayEspacioDesdeHueco(f, c, numEspacios)) {
                        solicitarReserva(f, c, numEspacios, bezeroa);
                        return;
                    }
                }
            }
            System.out.println("El cliente " + bezeroa.getBezeroId() + " no puede reservar " + numEspacios + " asientos.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean hayEspacioDesdeHueco(int fila, int columna, int numEspacios) {
        // Verificar si hay espacio suficiente y todos los asientos están libres
        for (int c = columna; c < columna + numEspacios; c++) {
            if (zinemaSemaphore[fila][c].availablePermits() == 0 || this.eserlekuak[fila][c] != null) {
                return false; // Asiento ocupado o no disponible
            }
        }
        return true;
    }

    private void solicitarReserva(int fila, int columna, int numEspacios, Bezeroa bezeroa) {
        try {
            for (int c = columna; c < columna + numEspacios; c++) {
                zinemaSemaphore[fila][c].acquire(); // Bloquear el asiento
                this.eserlekuak[fila][c] = bezeroa; // Asignar cliente
                System.out.println("El cliente " + bezeroa.getBezeroId() + " ha reservado el asiento " + fila + ", " + c);
                eserlekuTotalak--; // Reducir el total de asientos disponibles
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
