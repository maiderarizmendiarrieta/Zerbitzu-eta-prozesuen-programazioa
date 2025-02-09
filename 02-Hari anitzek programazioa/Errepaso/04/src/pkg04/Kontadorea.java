
package pkg04;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author maider
 */
public class Kontadorea {
    private final AtomicInteger counter = new AtomicInteger(0);
    
    public int gehitu() {
        return counter.incrementAndGet();
    } 
    
    public int getBalorea() {
        return counter.get();
    }
}
