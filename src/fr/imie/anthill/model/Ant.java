package fr.imie.anthill.model;

public abstract class Ant {

	public int id;
	protected int age;
	
	public Ant(int id, int age) {
		this.id = id;
		this.age = age;
	}
	
	public int antGetOlder() {
		age++;
		return age;
	}
	
	public abstract boolean isDead();
	
}
