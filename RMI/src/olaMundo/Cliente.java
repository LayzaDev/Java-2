package rmi;

import java.rmi.*;
import java.net.MalformedURLException;

public class Cliente {
    public static void main(String args[]) {
        
        int porta = 1099;
        
        try {
            System.out.println("Conectando com RMI...");
            I_OlaMundo objOlaMundo = (I_OlaMundo) Naming.lookup("rmi://localhost/" + porta + "/olamundo");
            System.out.println(objOlaMundo.ola());
            System.out.println("Conectado com sucesso!");
        } catch(MalformedURLException | RemoteException | NotBoundException e){
            e.printStackTrace();
        }
    }
}
