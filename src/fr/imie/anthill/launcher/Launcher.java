package fr.imie.anthill.launcher;

import java.util.Scanner;

import fr.imie.anthill.model.AntHill;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int queens;
		int male;
		int larvae;
		int worker;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome in the building of Ant Hill");
		System.out.println("An Ant Hill is composed of Queens, Workers, Males and Larvae");
		System.out.println("You will have to chose how many of each do you want ?");
		
		System.out.println("Queens :");
		queens = sc.nextInt();
		
		System.out.println("Males :");
		male = sc.nextInt();
		
		System.out.println("Larvae :");
		larvae = sc.nextInt();
		
		System.out.println("Worker :");
		worker = sc.nextInt();
		
		AntHill myAntHill = new AntHill(queens, male, larvae, worker);
		
		sc.close();
		
		while (true) {
			System.out.println(myAntHill);
			myAntHill.nextDay(); 
		}
		
	}

}
