package complemento2;

import java.rmi.*;

public interface IComplementoDe2 extends Remote {
    public int[] converteDecParaBin(int decimal) throws RemoteException;
    public int[] complemento(int[] binary) throws RemoteException;
    public void imprimeResultado(int[] number) throws RemoteException;
}
