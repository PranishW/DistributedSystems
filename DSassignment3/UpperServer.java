import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.PortableServer.*;
import UpperModule.*;
public class UpperServer {
    public static void main(String[] args)
    {
        try
        {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();
            ServerImpl rvr = new ServerImpl();
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(rvr);
            UpperIntf h_ref = UpperModule.UpperIntfHelper.narrow(ref);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            String name="Upper";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path,h_ref);
            System.out.println("Uppercase Server running");
            orb.run();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
