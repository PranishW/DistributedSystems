import java.util.Scanner;
public class Bully {
    int coordinator,max_processes;
    boolean[] processes;
    public Bully(int max)
    {
        max_processes = max;
        processes = new boolean[max_processes];
        for(int i=0;i<max_processes;i++)
        {
            processes[i]=true;
            System.out.println("process "+(i+1)+" Created");
        }
        coordinator = max_processes;
        System.out.println("Process "+coordinator+" is the Coordinator");
    }
    public void displayProcesses()
    {
        for(int i = 0; i < max_processes; i++) {
            if(processes[i]) 
                System.out.println("P" + (i+1) + " is up.");
            else
                System.out.println("P" + (i+1) + " is down.");
        }   
        System.out.println("P" + (coordinator) + " is the coordinator");
    }
    public void upProcess(int process_id)
    {
        if(!processes[process_id-1]) {
            processes[process_id-1] = true;
            System.out.println("Process P" + (process_id) + " is up.");
        } else {
            System.out.println("Process P" + (process_id) + " is already up.");
        }
    }
    public void downProcess(int process_id)
    {
        if(processes[process_id-1]) {
            processes[process_id-1] = false;
            System.out.println("Process P" + (process_id) + " is down.");
        } else {
            System.out.println("Process P" + (process_id) + " is already down.");
        }
    }
    public void ElectionAlgorithm(int process_id)
    {
           boolean KeepGoing = true;
           coordinator=process_id;
           for(int i=process_id;i < max_processes && KeepGoing;i++)
           {
               System.out.println("Election message sent from process " + process_id + " to process " + (i+1));
               if(processes[i])
               {
                   KeepGoing = false;
                   ElectionAlgorithm(i+1);
               }
           }
    }
    public static void main(String[] args)
    {
        int max_processes,process_id,choice;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no of processes :- ");
        max_processes = sc.nextInt();
        Bully bully = new Bully(max_processes);
        while(true) {
            System.out.println("Bully Algorithm");
            System.out.println("1. Display processes");
            System.out.println("2. Up a process");
            System.out.println("3. Down a process");
            System.out.println("4. Run election algorithm");
            System.out.println("5. Exit Program");
            System.out.print("Enter your choice:- ");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    bully.displayProcesses();
                    break;
                case 2:
                    System.out.print("Enter the process number to up:- ");
                    process_id = sc.nextInt();
                    bully.upProcess(process_id);
                    break;
                case 3:
                    System.out.print("Enter the process number to down:- ");
                    process_id = sc.nextInt();
                    bully.downProcess(process_id);
                    break;
                case 4:
                    System.out.print("Enter the process number which will perform election:- ");
                    process_id = sc.nextInt();
                    bully.ElectionAlgorithm(process_id);
                    bully.displayProcesses();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error in choice. Please try again.");
                    break; 
            }
        }
    }
}
