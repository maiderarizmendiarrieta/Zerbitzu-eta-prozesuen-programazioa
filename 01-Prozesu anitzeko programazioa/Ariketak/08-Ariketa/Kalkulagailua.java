import java.lang.ProcessHandle.Info;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

public class Kalkulagailua {
    public static void main(String[] args) {
        
        
        try {
            // Prozesua sortu
            Process p = new ProcessBuilder("calc.exe").start();
            System.out.println("Prozesua SORTU eta JAURTI da.");
    
            // Handlerrak
            ProcessHandle ph = p.toHandle();
            System.out.println("-- process handle --");
            System.out.println("PID: " + ph.pid());
            System.out.println("isAlive: " + ph.isAlive());

            // Prozesuaren informazioa
            Info info = ph.info();
            System.out.println("-- process info --");
            Optional<String> command = info.command();
            Optional<Instant> startInstant = info.startInstant();
            Optional<Duration> cpuDuration = info.totalCpuDuration();
            Optional<String> user = info.user();

            System.out.println("Command: " + command);
            System.out.println("StartInstant: " + startInstant);
            System.out.println("CpuDuration: " + (cpuDuration.isPresent() ? cpuDuration.get().toMillis() + " millis" : "N/A"));
            System.out.println("User: " + user.orElse("N/A"));
            
			// Prozesua amaitu
            System.out.println("-- destroying --");
			Thread.sleep(10000);
			p.destroy();
			if(p.isAlive()){
				p.destroyForcibly();
			}
            System.out.println("isAlive: " + ph.isAlive());
			System.out.println("Prozesua AMAITU da");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
