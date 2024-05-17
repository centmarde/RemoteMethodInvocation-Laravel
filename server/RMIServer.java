
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer extends UnicastRemoteObject implements RMIInterface {

  protected RMIServer() throws RemoteException {
    super();
  }

  public static void main(String[] args) {
    try {
      RMIServer server = new RMIServer();
      RMIInterface stub = (RMIInterface) server;

      Registry registry = LocateRegistry.createRegistry(1099);
      registry.rebind("RMIInterface", stub);

      System.out.println("Server is ready...");
    } catch (RemoteException e) {
      System.err.println("Error: " + e.getMessage());
      e.printStackTrace();
    }
  }

  @Override
  public void displayInfo() throws RemoteException {
    throw new UnsupportedOperationException(
      "Unimplemented method 'displayInfo'"
    );
  }
}
