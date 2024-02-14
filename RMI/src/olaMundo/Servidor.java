package rmi;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.net.MalformedURLException;

public class Servidor {
    public static void main(String[] args) {
        
        try{
           System.out.println("Iniciando...");
           
           OlaMundoImpl objOlaMundo = new OlaMundoImpl();
           int porta = 1099;

           String objNome = "rmi://localhost/"+porta+"/olamundo";
           LocateRegistry.createRegistry(porta);
           Naming.rebind(objNome, objOlaMundo);

           System.out.println("Sucesso!!");

        } catch(RemoteException | MalformedURLException e){
            e.printStackTrace();
        }
    }
}
