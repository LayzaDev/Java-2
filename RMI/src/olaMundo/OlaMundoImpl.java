package rmi;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class OlaMundoImpl extends UnicastRemoteObject implements I_OlaMundo {
    public OlaMundoImpl() throws RemoteException {
        super();
    };
    
    public String ola(){
        return "===== Olá mundo! =====";
    }
}

