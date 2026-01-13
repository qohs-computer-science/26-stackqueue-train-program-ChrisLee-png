/*
 * Christopher Lee
 * 1/6/26
 * Pd:6
 * Program will read a text file and create train objects that will be sorted by destination into tracks 
 * Each track has a weight limit that will be emptied when reached with a print message
 * An engine with the corresponding destination will also cause a track to be emptied.
 */
import java.util.Scanner;
import java.io.File;
//import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
//import java.util.ListIterator;

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
				}//creates train objects
				else
					nick0.add(new Train(med, x.nextLine()));
			}//loops through data file
		}//reads data file
		catch(Exception e)
		{
			//System.out.println(e.getMessage());
		}//helps loop through text file
		
		Queue<Train> leo1 = new LinkedList<Train>();

		Queue<Train> A = new LinkedList<Train>();
		int aWeight =0;
		Queue<Train> B = new LinkedList<Train>();
		int bWeight =0;
		Queue<Train> C = new LinkedList<Train>();
		int cWeight =0;
		Queue<Train> D = new LinkedList<Train>();

		//System.out.println(nick0.remove());
		//System.out.println(nick0.remove());
		//System.out.println(nick0.remove());
		//printMsg(nick0);
		int i=nick0.size();

		for(int e=0;e<i;e++){
			Train jas = nick0.remove();
			if(jas.getName().indexOf("CAR")==0){
				if(jas.getMiles()>700)
					leo1.add(jas);
				else
					nick0.add(jas);
			}//checks if car needs to be inspected 
			else
					nick0.add(jas);
		}//loops through initial track everything is added to
		while(!leo1.isEmpty()){
			Train kat = leo1.remove();
			kat.setMiles(100);
			nick0.add(kat);
		}//inspects cars

		//printMsg(nick0);
		while(!nick0.isEmpty()){
			Train lim = nick0.remove();
			if(lim.getName().indexOf("ENG")==0){
				if(lim.getDestination().equals("Trenton")){
					System.out.println("\n"+lim.getName()+" leaving for Trenton with the following cars:");
					printMsg(A);
					aWeight=0;
				}else if(lim.getDestination().equals("Charlotte")){
					System.out.println("\n"+lim.getName()+" leaving for Charlotte with the following cars:");
					printMsg(B);
					bWeight=0;
				}else{
					System.out.println("\n"+lim.getName()+" leaving for Baltimore with the following cars:");
					printMsg(C);
					cWeight=0;
				}//empties track if engine if for Baltimore
			}else{
				if(lim.getDestination().equals("Trenton")){
					if((aWeight+lim.getWeight()) > limitTrackA){
						System.out.println("\nENG00000 leaving for Trenton with the following cars:");
						printMsg(A);
						aWeight=0;
					}//checks if track A has room
					A.add(lim);
					aWeight+=lim.getWeight();
				}else if(lim.getDestination().equals("Charlotte")){
					if((bWeight+lim.getWeight()) > limitTrackB){
					System.out.println("\nENG00000 leaving for Charlotte with the following cars:");
					printMsg(B);
					bWeight=0;
					}//checks if track B has room
					B.add(lim);
					bWeight+=lim.getWeight();
				}else if(lim.getDestination().equals("Baltimore")){
					if((cWeight+lim.getWeight()) > limitTrackC){
						System.out.println("\nENG00000 leaving for Baltimore with the following cars:");
						printMsg(C);
						cWeight=0;
					}//checks if track C has room
					C.add(lim);
					cWeight+=lim.getWeight();
				}else {
					D.add(lim);
				}//adds trains to D
			}//end code that runs if car is train
		}//end loop

		//System.out.println(A.remove());
		//System.out.println(aWeight);
		//System.out.println(bWeight);
		//System.out.println(cWeight);
		System.out.println("\nLeft over cars after program is done:");
		while(!A.isEmpty()){
			System.out.println("\nTrack A(Trenton) contains:");
			printMsg(A);
			aWeight=0;
		}//empties track A
		while(!B.isEmpty()){
			System.out.println("\nTrack B(Charlotte) contains():");
			printMsg(B);
			bWeight=0;
		}//empties track B
		while(!C.isEmpty()){
			System.out.println("\nTrack C(Baltimore) contains:");
			printMsg(C);
			cWeight=0;
		}//empties track C
		while(!D.isEmpty()){
			System.out.println("\nTrack D(other) contains:");
			printMsg(D);
		}//empties track D
	}//end main
	public static void printMsg(Queue<Train> e){
    	while(!e.isEmpty())
    	{
			System.out.println(e.peek().getName()+" containing "+e.peek().getProduct()+" with weight " + e.peek().getWeight());
			e.remove();
    	}//loops through list
	}//end method to empty track
}//end class
