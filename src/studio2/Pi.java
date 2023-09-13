package studio2;

import java.util.Scanner;

public class Pi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the times of trial");
		int num = in.nextInt();
		double x,y, calpi;
		int incircle = 0, tot = 0;
		for (int i = 1; i <= num; i++) {
			x = 2 * Math.random() - 1;
			y = 2 * Math.random() - 1;
			if (x * x + y * y <= 1) incircle ++;
			tot++;
		}
		calpi = 4.0 * incircle / tot;
		System.out.print(calpi);

	}

}
