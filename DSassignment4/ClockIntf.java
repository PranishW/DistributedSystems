import java.rmi.*;
import java.time.LocalTime;
public interface ClockIntf extends Remote{
    public LocalTime getTime() throws RemoteException;
    public void AdjustClock(LocalTime timer,long avgdiff) throws RemoteException;
}
