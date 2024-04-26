
package dsassignment1;
import java.rmi.*;
public class Client {
    public static void main(String[] args)
    {
        try
        {
            String serverurl = "rmi://192.168.0.105/Server";
            ServerInterface s = (ServerInterface) Naming.lookup(serverurl);
            System.out.println("Addition of 5 and 8 is "+s.addition(5,8));
        }
        catch(Exception e)
        {
            System.out.println("Client exception "+e);
            System.exit(0);
        }
    }
}
