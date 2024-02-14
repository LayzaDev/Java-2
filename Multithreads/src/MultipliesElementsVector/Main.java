package MultipliesElementsVector;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args){
        
        Vector T1 = new Vector(1, 100);
        Vector T2 = new Vector(101, 200);
        Vector T3 = new Vector(201, 300);
        Vector T4 = new Vector(301, 400);
        Vector T5 = new Vector(401, 500);
        Vector T6 = new Vector(501, 600);
        Vector T7 = new Vector(601, 700);
        Vector T8 = new Vector(701, 800);
        Vector T9 = new Vector(801, 900);
        Vector T10 = new Vector(901, 1000);
        
        ExecutorService threadExecutor = Executors.newFixedThreadPool(10);
       
        threadExecutor.execute(T1);
        threadExecutor.execute(T2);
        threadExecutor.execute(T3);
        threadExecutor.execute(T4);
        threadExecutor.execute(T5);
        threadExecutor.execute(T6);
        threadExecutor.execute(T7);
        threadExecutor.execute(T8);
        threadExecutor.execute(T9);
        threadExecutor.execute(T10);
        
        threadExecutor.shutdown();
    }
}
