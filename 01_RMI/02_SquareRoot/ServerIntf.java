import java.rmi.*;

public interface ServerIntf extends Remote {
    public double sqrt(double num) throws RemoteException;
}