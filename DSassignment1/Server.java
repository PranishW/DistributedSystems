
package dsassignment1;
import java.rmi.*;
public class Server {
    public static void main(String[] args)
    {
        try
        {
            ServerImpl addserv = new ServerImpl();
            Naming.rebind("Server", addserv);
            System.out.println("Server running");
        }
        catch(Exception e)
        {
            System.out.println("Server exception "+e);
            System.exit(0);
        }
    }
    
}
