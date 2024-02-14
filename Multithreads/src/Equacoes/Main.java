package Equacoes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String args[]){
       
        List<double[]> elements = new ArrayList<>();
        elements.add(new double[]{-1, 4, -3});
        elements.add(new double[]{-1, 50, 15000});
        elements.add(new double[]{6, 4, 5});
        elements.add(new double[]{1, 0, -9});
        elements.add(new double[]{3, 3, 0});
        elements.add(new double[]{2, 3, 5});
        elements.add(new double[]{-4, 2, -4});
        elements.add(new double[]{1, -5, 6});
        elements.add(new double[]{1, -4, 3});
        elements.add(new double[]{-1, 2, 4});
        elements.add(new double[]{-3, 0, 0});
        elements.add(new double[]{0, 4, -10});

        ExecutorService threadExecutor = Executors.newFixedThreadPool(3);
        Equacoes equacao = new Equacoes();
        
        for (double[] eq : elements) {
            Equacoes.calculaRaizes(eq[0], eq[1], eq[2]);
            threadExecutor.execute(equacao);
        }
        
        threadExecutor.shutdown();
    }
}
