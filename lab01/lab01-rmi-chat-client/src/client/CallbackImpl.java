package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.TimeUnit;

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
	
	private  String userName;
	private  int delay;

	public CallbackImpl(String userName, int delay) throws  RemoteException {
		this.userName = userName;
		this.delay = delay;
	}
	
	@Override
	public String getName() throws RemoteException {
		return userName;
	}

	@Override
	public void displayMessage(String message) throws RemoteException {
		try { //lab2 6/3/2017
			TimeUnit.SECONDS.sleep(delay);
		} catch (InterruptedException ex) { } //interrupt ignored
		//This will cause the displayMessage method to pause 
		//before it prints the message.
		System.out.println(message);
	}
	
}
