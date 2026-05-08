import java.rmi.*;
import java.rmi.server.*;

public class ServerImp extends UnicastRemoteObject implements ServerIntf {
    public ServerImp() throws RemoteException {
        super();
    }
    public double div(double num1, double num2) throws RemoteException {
        return num1 / num2;
    }
}