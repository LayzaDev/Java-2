package SumMatrixRows;

public class MatrizThread implements Runnable {

    private int[] vector;
    private String line;

    public MatrizThread(String line, int[] vector) {
        this.line = line;
        this.vector = vector;
    }

    @Override
    public void run() {
        int sum = 0;
        for(int i = 0; i < vector.length; i++){
            sum += vector[i];
        }
        System.out.println("Somatório linha " + this.line + ": " + sum);
    }
    
}
