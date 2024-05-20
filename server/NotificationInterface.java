import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NotificationInterface extends Remote {
    void notify(String message) throws RemoteException;
}
