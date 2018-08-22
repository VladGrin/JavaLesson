package javalesson.rmi_jndi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) throws NamingException, RemoteException, AlreadyBoundException, MalformedURLException {
        Context context = new InitialContext();
        context.bind("rmi_jndi://localhost:1099/imath", new IMathImpl());
//        context.bind("rmi_jndi:imath", new IMathImpl());  //rebind
//        Naming.bind("imath", new IMathImpl());

    }
}

interface IMath extends Remote {
    int add(int a, int b) throws RemoteException;
}

class IMathImpl extends UnicastRemoteObject implements IMath{

    protected IMathImpl() throws RemoteException {
    }

    @Override
    public int add(int a, int b) {
        return 0;
    }
}