import java.rmi.*;

public interface ServerIntf extends Remote {
    public double cube(double num) throws RemoteException;
}