package InvertsMatrixLines;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    
    public static void main(String[] args) {
        
        int matriz[][] = new int[3][3];
        
        preencheMatriz(matriz);
        
        imprimeMatriz(matriz);
        
        MatrizThread line1 = new MatrizThread("1", matriz[0]);
        MatrizThread line2 = new MatrizThread("2", matriz[1]);
        MatrizThread line3= new MatrizThread("3", matriz[2]);
        
        
        ExecutorService threadExecutor = Executors.newFixedThreadPool(3);
        
        threadExecutor.execute(line1);
        threadExecutor.execute(line2);
        threadExecutor.execute(line3);

        
        threadExecutor.shutdown();      
    }
    
        public static void preencheMatriz(int[][] matriz){
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                matriz[i][j] = i+j;
            }  
        }
    }
    public static void imprimeMatriz(int[][] matriz){
        
        System.out.println("\nMATRIZ ORIGINAL");
        for(int i = 0; i < matriz.length; i++){
            System.out.println("");
            for(int j = 0; j < matriz[i].length; j++){
                System.out.print(matriz[i][j] + " ");
            }
        }   
        System.out.println("\n");
    }
}
