import UpperModule.UpperIntfPOA;
public class ServerImpl extends UpperIntfPOA{
    ServerImpl() {
        super();
        System.out.println("Upper Object Created");
    }
    public String upperstring(String str)
    {
        return str.toUpperCase();
    }
}
