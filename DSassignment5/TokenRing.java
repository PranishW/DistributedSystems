import java.util.Scanner;
public class TokenRing {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no of nodes :- ");
        int n = sc.nextInt();
        int token=0;
        while(true)
        {
            System.out.print("Enter Sender :- ");
            int s = sc.nextInt();
            System.out.print("Enter Reciever :- ");
            int r = sc.nextInt();
            System.out.print("Enter Data :- ");
            int data = sc.nextInt();
            for(int i=token;i!=s;i=(i+1)%n)
                System.out.print(+i+" -> ");
            System.out.println(s);
            System.out.println("Sender "+s+" Sending Data "+data);
            for(int i=s;i!=r;i=(i+1)%n)
                System.out.println("Data "+data+" forwarded by "+i);
            System.out.println("Data "+data+" Recieved by Reciever "+r);
            token = s;
        }
    }
    
}
