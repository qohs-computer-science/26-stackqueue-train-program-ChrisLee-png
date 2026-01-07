/*
 * TODO: Christopher Lee
 * TODO: 1/6/26
 * TODO: Pd:6
 * TODO: Program Description
 */
import java.util.Scanner;
import java.io.File;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class MyProgram {
	public static int val = 0;
	public static void main(String[] args) {

		int limitTrackA = 100000, limitTrackB = 100000, limitTrackC = 100000;
	
		Scanner x = new Scanner(System.in);
		Queue<Train> nick0 = new LinkedList<Train>();
		try{
			File f = new File("HelloWorldProject/src/data.txt");
			x = new Scanner (f);
			while(x.hasNext()){
				String med = x.nextLine();
				if(med.indexOf("CAR")!=-1){
					nick0.add(new Train(med, x.nextLine(), x.nextLine(), x.nextLine(), x.nextInt(), x.nextInt()));
					x.nextLine();
				}
				else{
					nick0.add(new Train(med, x.nextLine()));
				}
			}
		}
		catch(Exception e)
		{
			//System.out.println(e.getMessage());
		}
		
		Queue<Train> leo1 = new LinkedList<Train>();

		Queue<Train> A = new LinkedList<Train>();
		int aWeight =0;
		Queue<Train> B = new LinkedList<Train>();
		int bWeight =0;
		Queue<Train> C = new LinkedList<Train>();
		int cWeight =0;
		Queue<Train> D = new LinkedList<Train>();
		int dWeight =0;

		System.out.println(nick0.remove());
		System.out.println(nick0.remove());
		//System.out.println(nick0.remove());
	}
}
