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
import java.util.ListIterator;

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
				else
					nick0.add(new Train(med, x.nextLine()));
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

		//System.out.println(nick0.remove());
		//System.out.println(nick0.remove());
		//System.out.println(nick0.remove());
		printMsg(nick0);
		int i=nick0.size();
		//fix this
		for(int e=0;e<i;e++){
			Train jas = nick0.remove();
			if(jas.getName().indexOf("CAR")!=-1)
				if(jas.getMiles()>700)
					leo1.add(jas);
				else
					nick0.add(jas);
		}
		printMsg(nick0);
		while(!leo1.isEmpty()){
			Train kat = leo1.remove();
			kat.setMiles(100);
			nick0.add(kat);
		}
		
		while(!nick0.isEmpty()){
			Train lim = nick0.remove();
			if(lim.getDestination().equals("Trenton")){
				if((aWeight+lim.getWeight()) > limitTrackA)
					printMsg(A);
				A.add(lim);
				aWeight+=lim.getWeight();
			}else if(lim.getDestination().equals("Charlotte")){
				if((aWeight+lim.getWeight()) > limitTrackB)
					printMsg(B);
				B.add(lim);
				bWeight+=lim.getWeight();
			}else if(lim.getDestination().equals("Baltimore")){
				if((aWeight+lim.getWeight()) > limitTrackC)
					printMsg(C);
				C.add(lim);
				cWeight+=lim.getWeight();
			}else {
				D.add(lim);
				dWeight+=lim.getWeight();
			}
			System.out.println("e");
		}
		//System.out.println(A.remove());
		System.out.println(aWeight);
		System.out.println(bWeight);
		System.out.println(cWeight);
		printMsg(A);
		//printMsg(B);
		//printMsg(C);
	}
	public static void printMsg(Queue<Train> e){
    	while(!e.isEmpty())
    	{
		System.out.println(e.peek().getName()+" contains "+e.peek().getProduct());
		e.remove();
    	}//loops through list
	}
}
