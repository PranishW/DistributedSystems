
import java.util.Scanner;
import mpi.*;
public class ArrayMul {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MPI.Init(args);
		int rank = MPI.COMM_WORLD.Rank(),size = MPI.COMM_WORLD.Size();
		int unitsize=5,root=0;
		int[] send_buffer = new int[unitsize*size];
		int[] recv_buffer = new int[unitsize];
		int[] new_recv_buffer = new int[size];
		if(root==rank)
		{
			Scanner sc = new Scanner(System.in);
			for(int i=0;i<unitsize*size;i++)
			{
				System.out.print("Enter Element "+(i+1)+" :- ");
				send_buffer[i] = sc.nextInt();
			}
		}
		MPI.COMM_WORLD.Scatter(send_buffer,0,unitsize,MPI.INT,recv_buffer,0,unitsize,MPI.INT,root);
		for(int i=1;i<unitsize;i++)
			recv_buffer[0]*=recv_buffer[i];
		System.out.println("Multiplication at process "+rank+" is "+recv_buffer[0]);
		MPI.COMM_WORLD.Gather(recv_buffer,0,1,MPI.INT,new_recv_buffer,0,1,MPI.INT,root);
		if(root==rank)
		{
			long total_mul = 1;
			for(int i=0;i<size;i++)
				total_mul*=new_recv_buffer[i];
			System.out.println("Multiplication of all array elements is :- "+total_mul);
		}
		MPI.Finalize();
	}

}

