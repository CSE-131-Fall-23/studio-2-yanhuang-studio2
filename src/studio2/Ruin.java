package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the start amount: ");
		int sta = in.nextInt();
		System.out.println("Enter the chance of winning: ");
		double winc = in.nextDouble();
		System.out.println("Enter the win limit: ");
		int winl = in.nextInt();
		System.out.println("Enter the total number of simulations: ");
		int tots = in.nextInt();
		
		int loss  = 0, i;
		double expr, alpha;
		alpha = (1-winc) / winc;
		if(winc == 0.5) expr = 1.0 - 1.0 * sta / winl;
		else expr = ( Math.pow(alpha,sta) - Math.pow(alpha,winl) ) / ( 1 - Math.pow(alpha, winl) );

		for(i = 1; i <= tots; i++) {
			int amt = sta, num = 0;
		    double prob;
		    
		    while (amt > 0 && amt < winl) {
		        num += 1;
		        prob = Math.random();
		        if(prob >= winc) amt -= 1;
		        else amt += 1;
		    }
		    
		    if(amt == 0) {
		    	loss += 1;
		        System.out.print("Simulation " + i + ": " + num + " LOSE\n");
		    }
		    else if(amt == winl) System.out.print("Simulation " + i + ": " + num + " WIN\n");
		}
		System.out.print("Losses: " + loss + " Simulations: " + (i-1) + "\n");
		double ruir = 1.0 * loss / i;
		System.out.print("Ruin Rate from Simulation: " + ruir + " Expected Ruin Rate: " + expr);
	}

}
