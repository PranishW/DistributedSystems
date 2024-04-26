import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.time.LocalTime;
public class MainClock {
    public static void main(String[] args)
    {
        try
        {
            LocalTime localtime = LocalTime.parse("07:00:00", AppConstants.formatter);
            System.out.println("Current main clock time "+AppConstants.formatter.format(localtime));
            
            Registry reg1 = LocateRegistry.getRegistry(AppConstants.name1,AppConstants.port1);
            ClockIntf s1 = (ClockIntf) reg1.lookup(ServerImpl.class.getSimpleName());
            LocalTime st1 = s1.getTime();
            System.out.println("Server 1 time "+AppConstants.formatter.format(st1));
            
            Registry reg2 = LocateRegistry.getRegistry(AppConstants.name2,AppConstants.port2);
            ClockIntf s2 = (ClockIntf) reg2.lookup(ServerImpl.class.getSimpleName());
            LocalTime st2 = s2.getTime();
            System.out.println("Server 2 time "+AppConstants.formatter.format(st2));
            
            Registry reg3 = LocateRegistry.getRegistry(AppConstants.name3,AppConstants.port3);
            ClockIntf s3 = (ClockIntf) reg3.lookup(ServerImpl.class.getSimpleName());
            LocalTime st3 = s3.getTime();
            System.out.println("Server 2 time "+AppConstants.formatter.format(st3));
            
            long nlt = localtime.toNanoOfDay();
            long nst1 = st1.toNanoOfDay()-nlt,nst2 = st2.toNanoOfDay()-nlt,nst3 = st3.toNanoOfDay()-nlt;
            long avgdiff = (nst1+nst2+nst3)/4;
            
            s1.AdjustClock(localtime, avgdiff);
            s2.AdjustClock(localtime, avgdiff);
            s3.AdjustClock(localtime, avgdiff);
            localtime = localtime.plusNanos(avgdiff);
            
            System.out.println("Main Clock Time "+AppConstants.formatter.format(localtime));
            System.out.println("Clock 1 Time "+AppConstants.formatter.format(s1.getTime()));
            System.out.println("Clock 2 Time "+AppConstants.formatter.format(s2.getTime()));
            System.out.println("Clock 3 Time "+AppConstants.formatter.format(s3.getTime()));
        }
        catch(Exception e)
        {
            System.out.println("Main Clock Exception"+e);
        }
    }
}
