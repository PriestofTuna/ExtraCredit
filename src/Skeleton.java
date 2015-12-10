/**
 * 
 * @author lytte
 *
 *General details: Every public class goes in the oder of "HP, ATK, Energy"
 */
public class Skeleton {
	

	private int hp = 50;
	private int atk = 5;
	private int def = 1;
	private static String name = "Papyrus";
	public Skeleton(int hp, int atk, int def, String name) {
		super();
		this.hp = hp;
		this.atk = atk;
		this.def = def;
	}
	
	public Skeleton(){
		
	}
	
	public void setHp(int hp) {
		this.hp = 50-hp;
	}
	public int getHp() {
		return hp;
	}
	
	public void setAtk(int atk) {
		this.atk = 30;
	}
	public int getAtk() {
		return atk;
	}
	public void setDef(int def) {
		this.def = 5;
	}
	@Override
	public String toString() {
		return name +"Skeleton hp=" + hp;
	}

	public int getDef() {
		return def;
	}

	public void damage(int atk2) {
		this.hp -= atk2;
	}

	public void attack(Player player) {
		player.damage(this.atk);
		
	}
	public void defend(Player player) {
		damage(player.getAtk()-this.def);
		player.damage(this.def);
	}

	
}
