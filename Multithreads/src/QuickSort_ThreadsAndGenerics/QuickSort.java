package quick_sort;

public class QuickSort<E extends Comparable<E>> extends Thread {
    
    private int firstIndex, lastIndex;
    private String nameThread;
    private E[] list;
    
    public QuickSort(E[] list, int firstIndex, int lastIndex, String nameThread) {
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
        this.list = list;
        this.nameThread = nameThread;
    }
    
    @Override
    public void run(){
        
        int pivotPosition;
        
        if(firstIndex < lastIndex){
            
            pivotPosition = particiona(list, firstIndex, lastIndex, nameThread);
            
            QuickSort left = new QuickSort(list, firstIndex, pivotPosition -1, "Esquerda"); // lado esquerdo do pivô
            left.start(); // Inicia a thread esquerda
            
            QuickSort right = new QuickSort(list, pivotPosition + 1, lastIndex, "Direita");// lado direito do pivô
            right.start(); // Inicia a thread direita
            
            try { 
                left.join(); // Espera a thread left executar
                right.join(); // Retorna se já finalizou
            } catch(InterruptedException ex){
                System.out.println("Thread interrompida: " + ex.toString());
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    private int particiona(E[] list, int firstIndex, int lastIndex, String nameThread){
        
        int esq, dir;
        E pivo, aux;
        
        esq = firstIndex; 
        dir = lastIndex;
        pivo = list[firstIndex];
        
        while(esq < dir ) {
            
            while(list[esq].compareTo(pivo) <= 0 && esq < lastIndex) {
                esq++; 
            }
            
            while(list[dir].compareTo(pivo) >= 0 && dir > firstIndex) {  
                dir--;
            }
            
            if (esq < dir){
                aux = list[esq];
                list[esq] = list[dir];
                list[dir] = aux;
            }
        }
        
        list[firstIndex] = list[dir];
        list[dir] = pivo;
        
        return dir; 
    }
    
    public void imprimeListaDesordenada(E[] listaAnterior){
        
        System.out.print("\nLISTA DESORDENADA: { ");
        
        for (int i = 0; i < listaAnterior.length; i++) {
            System.out.print(listaAnterior[i] + " ");
        }
                
        System.out.println("}\n");
    }
    
    public void imprimeListaOrdenada(E[] listaOrdenada){
       
        System.out.print("LISTA ORDENADA: { ");
        
        for(int i = 0; i < listaOrdenada.length; i++){
            System.out.print(listaOrdenada[i] + " ");
        }
         System.out.println("}");
        System.out.println("\n------------------------------------------------------------------------");
    }
}
