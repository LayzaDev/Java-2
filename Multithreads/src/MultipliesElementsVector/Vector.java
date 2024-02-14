package MultipliesElementsVector;

import java.util.Random;

public class Vector implements Runnable{

    private int min, max;
    private int[] vector = new int[1000];
    
    Random generator = new Random();
    
    private int escalar = generator.nextInt(10);
    
    public Vector(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public void run() {
        for(int i = min; i < max; i++){
            vector[i] = i * escalar;
        }
        
        System.out.println("Thread(" + min + "," + max + ")");
        
        for(int i = min; i < max; i++){
            System.out.println(vector[i]);
        }
        
        System.out.println("");
    }
}
