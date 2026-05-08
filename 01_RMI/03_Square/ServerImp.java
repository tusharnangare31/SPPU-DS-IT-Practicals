import java.rmi.*;
import java.rmi.server.*;

public class ServerImp extends UnicastRemoteObject implements ServerIntf {
    public ServerImp() throws RemoteException {
        super();
    }
    public double square(double num) throws RemoteException {
        return num * num;
    }
}