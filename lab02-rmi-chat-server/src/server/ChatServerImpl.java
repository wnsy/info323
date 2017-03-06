package server;

import client.IClientCallback;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author wanwa973
 */
public class ChatServerImpl extends UnicastRemoteObject 
		  implements IChatServer {
		private ArrayList<IClientCallback> registerList = new ArrayList<>(); 

		
	public ChatServerImpl() throws RemoteException {
	}
	
	@Override
	public void register(IClientCallback callback) throws RemoteException {
		registerList.add(callback);
	}

	@Override
	public void sendMessage(IClientCallback sender, String message) 
			  throws RemoteException {
		System.out.println("test1" + sender + message);
		
		String concat = sender.getName() + ": " + message;
		
		for (IClientCallback cb : registerList) {
			cb.displayMessage(concat);
		}
	}
	
}
