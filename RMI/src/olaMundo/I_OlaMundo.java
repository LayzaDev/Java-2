package rmi;

import java.rmi.*;

public interface I_OlaMundo extends Remote {
    public String ola() throws RemoteException;
}
