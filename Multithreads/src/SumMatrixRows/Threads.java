package SumMatrixRows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threads {
    public static void main(String[] args) {
      
        int matriz[][] = new int[5][5];
        
        preencheMatriz(matriz);
        imprimeMatriz(matriz);
        
        MatrizThread line1 = new MatrizThread("1", matriz[0]);
        MatrizThread line2 = new MatrizThread("2", matriz[1]);
        MatrizThread line3= new MatrizThread("3", matriz[2]);
        MatrizThread line4 = new MatrizThread("4", matriz[3]);
        MatrizThread line5 = new MatrizThread("5", matriz[4]);
        
        ExecutorService threadExecutor = Executors.newFixedThreadPool(5);
        threadExecutor.execute(line1);
        threadExecutor.execute(line2);
        threadExecutor.execute(line3);
        threadExecutor.execute(line4);
        threadExecutor.execute(line5);
        
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
        
        System.out.println("\nORIGINAL");
        for(int i = 0; i < matriz.length; i++){
            System.out.println("");
            for(int j = 0; j < matriz[i].length; j++){
                System.out.print(matriz[i][j] + " ");
            }
        }   
        System.out.println("\n");
    }
}
