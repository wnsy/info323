package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author wanwa973
 * 
 * "This is the callback class that the server will use to interact with the 
 * client. The server needs to be able to get the user's name from the client, 
 * and also needs to be able to send the client messages to be displayed to the
 * user"--lab book 1
 */
public class CallbackImpl extends UnicastRemoteObject 
		  implements IClientCallback {
	private static String userName;

	public CallbackImpl(String userName) throws  RemoteException {
		this.userName = userName;
	}
	
	@Override
	public String getName() throws RemoteException {
		return userName;
	}

	@Override
	public void displayMessage(String message) throws RemoteException {
		System.out.println(message);
	}
	
}
