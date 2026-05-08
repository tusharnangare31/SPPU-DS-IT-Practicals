import java.rmi.*;
import java.rmi.server.*;

public class ServerImp extends UnicastRemoteObject implements ServerIntf {
    public ServerImp() throws RemoteException {
        super();
    }
    public double sqrt(double num) throws RemoteException {
        return Math.sqrt(num);
    }
}