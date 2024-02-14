package InvertsMatrixLines;

public class MatrizThread implements Runnable{

    private String line;
    private int[] vector;
    
    public MatrizThread(String line, int[] vector) {
        this.line = line;
        this.vector = vector;
    }
    
    @Override
    public void run() {
        
        for(int i = vector.length - 1; i >= 0 ; i--){
            System.out.print(vector[i] + " ");
        }
        System.out.println("");
    }
}
