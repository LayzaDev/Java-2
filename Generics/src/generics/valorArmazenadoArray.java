package generics;

public class valorArmazenadoArray {
    public static void main(String args[]){
        
        Integer[] array = {4, 3, 5, 8, 6, 7, 1};
        
        verificaValor(array, 6);
 
    }
    
    public static <T extends Comparable<T>> T verificaValor(T[] array, T valor){
        
        if(array == null || array.length == 0){
            
            return null;
            
        } else {
            
            for(T elements : array){
                if(elements.equals(valor)){
                    System.out.println(valor + " está armazenado no array");
                }
            }
            
            for(int i = 0; i < array.length; i++){
                System.out.print(array[i] + ",");
            }
            
            System.out.println(" ");
        }
        return valor;
    }
}
