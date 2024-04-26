import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.time.LocalTime;
public class Clock2 {
    public static void main(String[] args)
    {
        try
        {
            ServerImpl s2 = new ServerImpl(LocalTime.parse("07:02:50", AppConstants.formatter));
            Registry reg2 = LocateRegistry.createRegistry(AppConstants.port2);
            reg2.rebind(ServerImpl.class.getSimpleName(), s2);
            System.out.println("Server 2 running on "+AppConstants.port2);
        }
        catch(Exception e)
        {
            System.out.println("Clock 2 Exception"+e);
        }
    }
}
