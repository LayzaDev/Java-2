package lebre;

public class Monitoracao {
    
    private int contSaltos = 0;
    private int totalThreads = 5;
    
    public Monitoracao(int totalThreads){
        this.totalThreads = totalThreads;
    }
    
    // Quando a thread chegar no 20 irá diminuir o total de pulos, então temos que decrementar o total de threads
    public void decThreads(){
        this.totalThreads--;
    }
    
    synchronized public void monitorar(){

        if((contSaltos + 1) == totalThreads){
            contSaltos = 0;
            notifyAll();
        } else {
            try {
                contSaltos++;
                wait();
            } catch(Exception error){
                error.printStackTrace();
            }
        }
    }
}
