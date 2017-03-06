package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import server.IChatServer;

/**
 *
 * @author wanwa973
 */
public class SlowClient {

	public static void main(String[] args) throws RemoteException, 
			  NotBoundException {
		
		// get the user's username
	
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your user name: ");
		String name = scanner.nextLine();
		
		// Creates an instance of the callback class passing in the user 
		// name to the constructor
		CallbackImpl cb = new CallbackImpl(name);

		/**
		 * gets a reference to the RMI registry that contains the server object's
		 * reference 
		 */
		//get remote registry
		String remoteAddress = "127.0.0.1"; //old: localhost
		Registry registry = LocateRegistry.getRegistry(remoteAddress,1099);//1099
		
		// get a reference to the remote server object from the registry
		IChatServer server = (IChatServer) registry.lookup("chat");
		
		server.register(cb);
		System.out.println("Enter your message: ");
		while (scanner.hasNextLine()) {
			String msg = scanner.nextLine();
			server.sendMessage(cb, msg);
		}
	}
}
