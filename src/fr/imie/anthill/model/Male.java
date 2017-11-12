package fr.imie.anthill.model;

public class Male extends Ant {
	
	static int maxAge = 20;
	
	public Male(int id, int age) {
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
