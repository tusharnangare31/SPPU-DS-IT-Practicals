import java.rmi.*;
import java.rmi.server.*;

public class ServerImp extends UnicastRemoteObject implements ServerIntf {
    public ServerImp() throws RemoteException {
        super();
    }
    public boolean checkEqual(String s1, String s2) throws RemoteException {
        return s1.equals(s2);
    }
}