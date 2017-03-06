package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author wanwa973
 */
public class Server{
	
	public static void main(String[] args) throws RemoteException {
		ChatServerImpl serverObject = new ChatServerImpl();
		
		//creates an RMI registry
		Registry registry = LocateRegistry.createRegistry(1099);
		
		//put a reference to server object in the RMI registry
		registry.rebind("chat", serverObject);
		System.out.println("Test: server is ready");

	}
}
