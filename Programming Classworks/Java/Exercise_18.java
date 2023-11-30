import java.util.Scanner;

abstract class Clerk {
	String name;
	double rate;
	double hours;
	double salary;

	Clerk(String n, double r, double h) {
		name = n;
		rate = r;
		hours = h;
	}

	abstract double salary();
}

class PartTime extends Clerk {
	// TO DO
}

class FullTime extends Clerk {
	// TO DO
}

public class JPD06 {
	public static void main(String argv[]) {
		String input = null;
		try {
			Scanner sc = new Scanner(System.in);
			input = sc.nextLine();
			sc.close();
		} catch (Exception ex) {
			System.out.print("error");
			return;
		}
        	
		 // TO DO

	}

}