package study05_extends;

public class Hero {
	String name;
	String power;
	int attack;
	int defense;
	public Hero(String name, String power, int attack, int defense) {
		this.name = name;
		this.power = power;
		this.attack = attack;
		this.defense = defense;
	}
	@Override
	public String toString() {
		return "IronMan [name=" + name + ", power=" + power + ", attack=" + attack + ", defense=" + defense
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}


	public void showHeroInfo() {
			System.out.println(toString());
		// TODO Auto-generated method stub
		
	}
	
	
}
