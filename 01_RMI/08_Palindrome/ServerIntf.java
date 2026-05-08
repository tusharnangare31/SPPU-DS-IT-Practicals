import java.rmi.*;

public interface ServerIntf extends Remote {
    public boolean palindrome(String s) throws RemoteException;
}