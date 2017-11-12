package fr.imie.anthill.model;

public class Queen extends Ant {
	
	static int maxAge = 50;

	public Queen(int id, int age) {
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
