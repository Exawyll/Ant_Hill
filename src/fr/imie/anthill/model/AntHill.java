package fr.imie.anthill.model;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class AntHill {
	private ArrayList<Queen> queens = new ArrayList<Queen>();
	private ArrayList<Male> males = new ArrayList<Male>();
	private ArrayList<Larvae> larvaes = new ArrayList<Larvae>();
	private ArrayList<Worker> workers = new ArrayList<Worker>();
	private int id = 1;
	private int days = 0;
	private int nbrDeath = 0;
	private int nbrBirth = 0;

	public AntHill() {
		// TODO Auto-generated constructor stub
	}

	public AntHill(int nbrQueens, int nbrMale, int nbrLarvae, int nbrWorkers) {
		
		for (int i = 0; i < nbrQueens; i++) {
			Queen queen = new Queen(id, 10);
			queens.add(queen);
			id++;
		}
		
		for (int i = 0; i < nbrMale; i++) {
			Male male = new Male(id, 10);
			males.add(male);
			id++;
		}
		
		for (int i = 0; i < nbrLarvae; i++) {
			Random rand = new Random();
			Larvae larvae = new Larvae(id, 1, rand.nextInt(21));
			larvaes.add(larvae);
			id++;
		}
		
		for (int i = 0; i < nbrWorkers; i++) {
			Worker worker = new Worker(id, 10);
			workers.add(worker);
			id++;
		}
	}

	public void nextDay() {
		days++;
		nbrBirth = 0;
		nbrDeath = 0;
		
		ListIterator<Larvae> listLarvae = larvaes.listIterator();
		while (listLarvae.hasNext()) {
			
			Larvae myLarvae = listLarvae.next();
			
			if (myLarvae.isDead()) {
				
				if (myLarvae.getFuturType() == 1) {
					Queen queen = new Queen(id, 10);
					queens.add(queen);
					id++;
				} else if (myLarvae.getFuturType() == 2 || myLarvae.getFuturType() == 3) {	
					Male male = new Male(id, 10);
					males.add(male);
					id++;
				} else {
					Worker worker = new Worker(id, 10);
					workers.add(worker);
					id++;
				}
				listLarvae.remove();
			} else {
				myLarvae.antGetOlder();
			}
		}
		
		ListIterator<Male> listMale = males.listIterator();
		while (listMale.hasNext()) {
			
			Male myMale = listMale.next();
			if (myMale.isDead()){
				listMale.remove();
				nbrDeath++;
			} else {
				myMale.antGetOlder();
			}
		}
		
		ListIterator<Worker> listWorker = workers.listIterator();
		while (listWorker.hasNext()) {
			
			Worker myWorker = listWorker.next();
			if (myWorker.isDead()) {
				listWorker.remove();
				nbrDeath++;
			} else {
				myWorker.antGetOlder();
			}
		}
		
		ListIterator<Queen> listQueen = queens.listIterator();
		while (listQueen.hasNext()) {
			
			Queen myQueen = listQueen.next();
			if (myQueen.isDead()) {
				listQueen.remove();
				nbrDeath++;
			} else {
				if (!males.isEmpty()) {
					for (int i = 0; i < 10; i++) {
						Random rand = new Random();
						Larvae larvae = new Larvae(id, 1, rand.nextInt(21));
						larvaes.add(larvae);
						setNbrBirth(getNbrBirth() + 1);
						id++;
					}
				}
				myQueen.antGetOlder();
			}
		}
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getNbrDeath() {
		return nbrDeath;
	}

	public void setNbrDeath(int nbrDeath) {
		this.nbrDeath = nbrDeath;
	}

	public int getNbrBirth() {
		return nbrBirth;
	}

	public void setNbrBirth(int nbrBirth) {
		this.nbrBirth = nbrBirth;
	}
	
	@Override
	public String toString() {
		return "Current AntHill :\n"
				+ "Days=" + days + "\nnbrDeath=" + nbrDeath + "\nnbrBirth=" + nbrBirth + "\nQueens : " 
				+ queens.size() + "\nMales : " + males.size() + "\nWorkers : " + workers.size() + "\nLarvaes : " + larvaes.size();
	}
}
