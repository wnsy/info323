package server;

import client.IClientCallback;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Remote interface for the server side of the chat system.
 */
public interface IChatServer extends Remote {

	/**
	 * Sends a client callback to the server so that the server has a mechanism
	 * for communicating with the client.
	 *
	 * @param callback The callback to send to the server.
	 * @throws RemoteException
	 */
	void register(IClientCallback callback) throws RemoteException;

	/**
	 * Sends a message to the server to be relayed to the other clients in the
	 * system.
	 *
	 * @param sender The callback of the sending user.
	 * @param message The message to send.
	 * @throws RemoteException
	 */
	void sendMessage(IClientCallback sender, String message) throws RemoteException;
}
