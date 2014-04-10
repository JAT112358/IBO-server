package remote;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import dao.DAO;
 
public class Server extends UnicastRemoteObject implements IServer {
	
	private static final long 			serialVersionUID = 4448382946824924906L;
	
	private DAO							dao;
	
	protected Server() throws RemoteException {
		dao = new DAO();
	}
	
	public static void main(String[] args) {
		if (args.length != 3) {
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IServer server = new Server();		
			Naming.rebind(name, server);
			System.out.println("* Server '" + name + "' active and waiting...");		
		} catch (Exception e) {
			System.err.println("$ Tralala Server exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}