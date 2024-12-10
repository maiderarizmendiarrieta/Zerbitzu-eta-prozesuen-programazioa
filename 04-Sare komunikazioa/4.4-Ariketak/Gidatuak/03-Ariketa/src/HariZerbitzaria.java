import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HariZerbitzaria extends Thread {
    private final Socket clientSocket;

    public HariZerbitzaria(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            int secretNumber = (int) (Math.random() * 100) + 1;
            int attempts = 0;
            boolean guessed = false;

            out.println(
                    "Zerbitzariari konektatuta zaude! 1etik 100era dagoen zenbaki bat asmatu beharko duzu. 6 aukera dituzu!");

            while (attempts < 6) {
                out.println("Sartu zure asmakizuna:");
                String guessStr = in.readLine();

                if (guessStr == null)
                    break;

                try {
                    int guess = Integer.parseInt(guessStr);
                    attempts++;

                    if (guess == secretNumber) {
                        out.println("ZORIONAK! Asmatu duzu zenbakia " + secretNumber + " zen.");
                        guessed = true;
                        break;
                    } else if (guess < secretNumber) {
                        out.println("ZENBAKI HANDIAGOA da.");
                    } else {
                        out.println("ZENBAKI TXIKIAGOA da.");
                    }

                    out.println("Geldiratu dituzun saiakerak: " + attempts + "/6");
                } catch (NumberFormatException e) {
                    out.println("Sartutakoa ez da zenbaki balioduna. Saiatu berriro.");
                }
            }

            if (!guessed) {
                out.println("TAMALDUGARRIA! Saiakerak agortu dituzu. Zenbakia " + secretNumber + " zen.");
            }

            out.println("Berriro jokatu nahi duzu? (BAI/EZ)");
            String response = in.readLine();
            if ("BAI".equalsIgnoreCase(response)) {
                run(); // Berriro hasten du jokoa
            } else {
                out.println("Agur eta eskerrik asko jolasteagatik!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
