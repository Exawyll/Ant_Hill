package fr.imie.anthill.model;

public class Worker extends Ant {
	
	static int maxAge = 50;
	
	public Worker(int id, int age) {
		super(id, age);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		if (age == maxAge) {
			return true;
		} else {
			return false;
		}
	}
}
