package complemento2;

import java.net.MalformedURLException;
import java.rmi.*;

public class Cliente {
    public static void main(String[] args) throws RemoteException, Exception {
        int porta = 1099;
        try {
            System.out.println("Conectando com RMI...");
           
            IComplementoDe2 obj = (IComplementoDe2) Naming.lookup("rmi://localhost/" + porta + "/complemento");
            
            int decimal = 44;
            
            int[] binario = obj.converteDecParaBin(decimal);
            int[] complementoDe2 = obj.complemento(binario);
            obj.imprimeResultado(complementoDe2);
            
            System.out.println("Conectado com sucesso!");

        } catch(MalformedURLException | RemoteException | NotBoundException e){
             e.printStackTrace();
        }
    }
}
