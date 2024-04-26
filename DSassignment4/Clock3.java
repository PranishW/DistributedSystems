import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.time.LocalTime;
public class Clock3 {
    public static void main(String[] args)
    {
        try
        {
            ServerImpl s3 = new ServerImpl(LocalTime.parse("07:02:30", AppConstants.formatter));
            Registry reg3 = LocateRegistry.createRegistry(AppConstants.port3);
            reg3.rebind(ServerImpl.class.getSimpleName(), s3);
            System.out.println("Server 3 running on "+AppConstants.port3);
        }
        catch(Exception e)
        {
            System.out.println("Clock 3 Exception"+e);
        }
    }
}
