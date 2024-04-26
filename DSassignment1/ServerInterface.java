package dsassignment1;
import java.rmi.*;

public interface ServerInterface extends Remote{
    double addition(double num1,double num2) throws RemoteException;
}
