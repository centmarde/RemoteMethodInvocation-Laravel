import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerNotificationImpl extends UnicastRemoteObject implements NotificationInterface {

    protected ServerNotificationImpl() throws RemoteException {
        super();
    }

    @Override
    public void notify(String message) throws RemoteException {
        System.out.println("Notification from server: " + message);
    }
}
