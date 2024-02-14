package generics;

public class MaiorValorArray {

    public static void main(String[] args) {
        Integer[] arrayInt = {5, 2, 7, 10, 6, 9, 1};
        
        System.out.println("Maior valor: " + procuraMaiorValor(arrayInt));
    }
    
    public static <E extends Comparable<E>> E procuraMaiorValor(E[] array){
        
        if(array == null || array.length == 0){
            System.out.println("Array vazio!");
            return null;
        }
        
        E maiorValor = array[0];
        
        for(int i = 1; i < array.length; i++){
            if(array[i].compareTo(maiorValor) > 0){
                maiorValor = array[i];
            }
        }
        
        return maiorValor;
    }
    

}
