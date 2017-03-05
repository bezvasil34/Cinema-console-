package ret.ytr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		/* part 1*/
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("***1");
		System.out.println("Enter radius:");
		
		
		double r=Double.parseDouble(br.readLine());
		
		
		double s=r*r*Math.PI;
		double p=2*r*Math.PI;
		
		System.out.println("Area of flower bed is: "+s+" "+"Perimetr is: "+p);
		
		
		
		/* part 2*/
		
		String name;
		int age;
		String address;
		
		System.out.println("***2");
		System.out.println("What is your name?" );
		
		name=br.readLine();
		
		System.out.println("How old are you?" );
		
		age=Integer.parseInt(br.readLine());
		
		System.out.println("Where are you live, "+name+"?");
		
		address=br.readLine();
		
	System.out.println("Information about you:");
	System.out.println("Name: "+name);
	System.out.println("Age: "+age);
	System.out.println("Address: "+address);
		
	
	
	/*part 3*/
	System.out.println("***3");
	
	System.out.println("Enter tariff c1:");
	double c1=Double.parseDouble(br.readLine());
	
	System.out.println("Enter tariff c2:");
	double c2=Double.parseDouble(br.readLine());
	
	System.out.println("Enter tariff c3:");
	double c3=Double.parseDouble(br.readLine());
	
	System.out.println("Enter call duration in seconds t1:");
	double t1=Double.parseDouble(br.readLine());
	
	System.out.println(" First talk costs:"+(c1*t1/60));
	
	System.out.println("Enter call duration in seconds t2:");
	double t2=Double.parseDouble(br.readLine());
	
	System.out.println(" First talk costs:"+(c2*t2/60));
	
	System.out.println("Enter call duration in seconds t3:");
	double t3=Double.parseDouble(br.readLine());
	
	System.out.println(" First talk costs:"+(c3*t3/60));
	
	double total=(c1*t1/60)+(c2*t2/60)+(c3*t3/60);
	
	System.out.println("All talk togather cost: "+total);
	
	
	System.out.println("Finish");
	}

	

}
