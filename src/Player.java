
public class Player {


	private int hp = 100;
	private int atk = 20;
	private int ene = 15;
	private static int def = 1;
	private String name = "Chara";
	private static int mhp;
	public Player() {
		
		
	}
	public void setHp(int hp) {
		this.hp = 100-hp;
	}
	public int getHp() {
		return hp;
	}
	
	public void setAtk(int atk) {
		this.atk = 20;
	}
	public int getAtk() {
		return atk;
	}
	public void setEne(int ene) {
		this.ene = 15;
	}
	public int getEne() {
		return ene;
	}
	public void setDef(int def) {
		this.def = 1;
	}
	public static int getDef() {
		return def;
	}
	public void setDef(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	//should be generic enemy type but whatevs
	public void attack(Skeleton skeleton) {
		skeleton.damage(this.atk);
		
	}
	public void defend(Skeleton skeleton) {
		damage(skeleton.getAtk()- this.def);
		skeleton.damage(this.def);
		
	}
	void damage(int i) {
		this.hp -= i;
	}
	public String toString() {
		return "Player hp=" + hp;
	}	
}
