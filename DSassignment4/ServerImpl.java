import java.rmi.*;
import java.rmi.server.*;
import java.time.LocalTime;
public class ServerImpl extends UnicastRemoteObject implements ClockIntf
{
    LocalTime currTime;
    public ServerImpl(LocalTime currTime) throws RemoteException 
    {
        this.currTime = currTime;
    }
    @Override
    public LocalTime getTime() throws RemoteException {
        return currTime;
    }
        

    @Override
    public void AdjustClock(LocalTime timer, long avgdiff) throws RemoteException 
    {
        long timernano = timer.toNanoOfDay();
        long newtimer = timernano + avgdiff;
        LocalTime newLocalTime = LocalTime.ofNanoOfDay(newtimer);
        System.out.println("Updated time "+AppConstants.formatter.format(newLocalTime));
        currTime = newLocalTime;
    }
    
}
