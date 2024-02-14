package lebre;

import java.util.Random;

public class Lebre implements Runnable {
    
    private String nome;
    private int contSalto = 0, distTotal = 20, distPuloMin = 1, distPuloMax = 3;
    private float distPercorrida = 0;
    
    Monitoracao m;

    public Lebre(String n, Monitoracao m) {
        this.nome = n;
        this.distPercorrida = 0;
        this.m = m;
    }
    
    @Override
    public void run() {

        Random random = new Random();
        
        synchronized(this){
            while (distPercorrida < 20) {
                
                float salto = random.nextInt(distPuloMax) + distPuloMin;

                distPercorrida += salto;

                contSalto++;

                System.out.println(nome
                        + "\n     Salto: " + salto + " m"
                        + "\n     Distância percorrida: " + distPercorrida + " ");
                
                if(distPercorrida >= 20) {
                    System.out.println("*******" + nome + " " + "Chegou!! ******");
                    m.decThreads();
                }
                m.monitorar();
            }
        }
    }
}
