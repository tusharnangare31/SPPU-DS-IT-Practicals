import java.rmi.*;

public interface ServerIntf extends Remote {
    public double square(double num) throws RemoteException;
}