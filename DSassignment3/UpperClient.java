import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.PortableServer.*;
import UpperModule.*;
import java.util.Scanner;
public class UpperClient {
    public static void main(String[] args)
    {
        try 
        {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            String name="Upper";
            UpperIntf obj = UpperIntfHelper.narrow(ncRef.resolve_str(name));
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter string :- ");
            String str = sc.nextLine();
            System.out.println("Uppercase String of string"+str+" is "+obj.upperstring(str));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
