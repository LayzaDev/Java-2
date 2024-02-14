package complemento2;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class ComplementoDe2 extends UnicastRemoteObject implements IComplementoDe2 {

    public ComplementoDe2() throws RemoteException {
        super();
    }
    
    @Override
    public int[] complemento(int[] binario) throws RemoteException {
        
        int[] complemento = null;
        
        try {
            int[] binarioInvertido = inverteBits(binario);
            complemento = somaUmBit(binarioInvertido);
        } catch(Exception e){
            e.printStackTrace();
        }
        return complemento;
    }
    
    @Override
    public int[] converteDecParaBin(int decimal) throws RemoteException { // 42 -> 1100
        
        int[] binario = new int[32];
        
        int cont = 0;
        
        while(decimal != 0){
           binario[cont] = decimal % 2;
           decimal = decimal / 2;
           cont++;
        }
        
        int[] binarioCorreto = inverteListaBin(binario);
        
        return binarioCorreto;
    }

    public int[] inverteListaBin(int[] lista) { // 1011 -> 1101
        
        int contador = 0;
        int tamanho = lista.length;
        
        int[] listaAux = new int[tamanho];
        
        for(int i = tamanho - 1; i >= 0; i--){
            listaAux[contador] = lista[i]; 
            contador++;
        }
        
        return listaAux;
    }

    public int[] inverteBits(int[] bits){ // 1101 -> 0010  
        for(int i = 0; i < bits.length; i++){
            switch (bits[i]){
                case 0:
                    bits[i] = 1;
                    break;
                case 1:
                    bits[i] = 0;
                    break;
                default:
                    System.out.println("Erro: Numero invalido!");
                    break;
            }
        }
        return bits;
    }

    public int[] somaUmBit(int[] binarioInvertido) {
        
        int tamanho = binarioInvertido.length - 1;
        
        int ultimoBit = binarioInvertido[tamanho];
        
        if(ultimoBit == 0){
            binarioInvertido[tamanho] += 1;
            return binarioInvertido;
        }
        
        boolean adicionaUm = true;
        ultimoBit = tamanho;

        while (adicionaUm && ultimoBit != 0) {

            binarioInvertido[ultimoBit] += 1; // Somando um no ultimo bit

            if (binarioInvertido[ultimoBit] == 2) {
                binarioInvertido[ultimoBit] = 0;
                adicionaUm = true;
            } else {
                adicionaUm = false;
            }

            ultimoBit--; // deslocando ultimo bit para a esquerda
        }

        return binarioInvertido;
    }

    @Override
    public void imprimeResultado(int[] binario) throws RemoteException {
        for(int i = 0; i < binario.length; i++){
            System.out.print(binario[i] + "");
        }
        System.out.println("");
    }
}