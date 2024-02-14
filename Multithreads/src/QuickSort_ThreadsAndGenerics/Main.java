package quick_sort;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        
        try {
            
            Integer[] listInteger = {99, -10, 94, 93, -20, 30, 1, 3, -39, 23, 50, 49};
            Double[] listDouble = {2.5, 1.56, 45.26, -20.00, 27.89, 3.64, -39.75};
            Character[] listChar = {'Z', 'W', 'Y', 'M', 'K', 'L', 'I', 'C', 'B', 'F', 'A'};
            String[] listString = {"Maça", "Banana", "Uva", "Goiaba", "Morango", "Cereja"};
            
            System.out.println("\n------------------------------ QUICK SORT ------------------------------");
            
            executeQuickSort(listInteger);
            executeQuickSort(listDouble);
            executeQuickSort(listChar);
            executeQuickSort(listString);
            
        } catch (NullPointerException e) {
            System.out.println("Erro: O array está nulo.");
        } catch (Exception ex) {
            System.out.println("Erro desconhecido: " + ex.getMessage());
        }
    }
    
    private static <E extends Comparable<E>> void executeQuickSort(E[] lista) throws InterruptedException {
        
        QuickSort<E> quickSort = new QuickSort<>(lista, 0, lista.length - 1, "Thread Principal");
        
        quickSort.imprimeListaDesordenada(lista);

        quickSort.start();
        quickSort.join();
        
        quickSort.imprimeListaOrdenada(lista);
    }
}
