import java.rmi.*;

public interface ServerIntf extends Remote {
    public boolean checkEqual(String s1, String s2) throws RemoteException;
}