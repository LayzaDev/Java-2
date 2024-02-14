package lebre;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        
        Monitoracao m = new Monitoracao(5);    
        
        Lebre L1 = new Lebre("Lebre 1", m);
        Lebre L2 = new Lebre("Lebre 2", m);
        Lebre L3 = new Lebre("Lebre 3", m);
        Lebre L4 = new Lebre("Lebre 4", m);
        Lebre L5 = new Lebre("Lebre 5", m);
        
        ExecutorService threadExecutor = Executors.newFixedThreadPool(5);
        
        threadExecutor.execute(L1);
        threadExecutor.execute(L2);
        threadExecutor.execute(L3);
        threadExecutor.execute(L4);
        threadExecutor.execute(L5);
        
        threadExecutor.shutdown();
    }
}
