package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote interface for the client side of the chat system.
 */
public interface IClientCallback extends Remote {

	/**
	 * Gets the user's nickname.
	 *
	 * @return The user's name.
	 * @throws RemoteException
	 */
	String getName() throws RemoteException;

	/**
	 * Sends a message to the client so that it can be displayed to the user.
	 *
	 * @param message The message to display.
	 * @throws RemoteException
	 */
	void displayMessage(String message) throws RemoteException;
}
