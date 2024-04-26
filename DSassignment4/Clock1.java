import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.time.LocalTime;
public class Clock1 {
    public static void main(String[] args)
    {
        try
        {
            ServerImpl s1 = new ServerImpl(LocalTime.parse("07:05:00", AppConstants.formatter));
            Registry reg1 = LocateRegistry.createRegistry(AppConstants.port1);
            reg1.rebind(ServerImpl.class.getSimpleName(),s1);
            System.out.println("Server 1 running on "+AppConstants.port1);
        }
        catch(Exception e)
        {
            System.out.println("Clock 1 Exception"+e);
        }
    }
}
