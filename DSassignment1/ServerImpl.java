package dsassignment1;
import java.rmi.*;
import java.rmi.server.*;

public class ServerImpl extends UnicastRemoteObject implements ServerInterface{
    public ServerImpl() throws RemoteException {
        super();
    }
    @Override
    public double addition(double num1, double num2) throws RemoteException {
        return num1+num2;
    }
}
