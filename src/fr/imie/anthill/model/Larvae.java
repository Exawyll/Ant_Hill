package fr.imie.anthill.model;

public class Larvae extends Ant	{
			
	static int maxAge = 10;
	private int futurType;
	
	public Larvae(int id, int age, int futurType) {
		super(id, age);
		// TODO Auto-generated constructor stub
		this.futurType = futurType;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getFuturType() {
		return futurType;
	}

	public void setFuturType(int futurType) {
		this.futurType = futurType;
	}
	
	
}
