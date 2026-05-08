import java.rmi.*;
import java.rmi.registry.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Start RMI registry on 1099 if not already started
            try {
                LocateRegistry.createRegistry(1099);
            } catch (Exception e) {
                System.out.println("RMI registry already running...");
            }
            ServerImp serverImp = new ServerImp();
            Naming.rebind("Server", serverImp);
            System.out.println("Server is ready...");
        } catch (Exception e) {
            System.out.println("Exception Occurred At Server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}