package complemento2;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.*;

public class Servidor {
    public static void main(String[] args) throws MalformedURLException{
        
        int porta = 1099;
        
        try {
            
            System.out.println("Iniciando Servidor");
            IComplementoDe2 objComplemento = new ComplementoDe2();
            
            String objNome = "rmi://localhost/"+porta+"/complemento";
            LocateRegistry.createRegistry(porta);
            
            Naming.rebind(objNome, objComplemento);
            System.out.println("Servidor pronto!");
            
        } catch(RemoteException e){
            e.printStackTrace();
        }
    }
}
