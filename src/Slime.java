
public class Slime {

	private int hp;
	private int atk;
	private int ene;
	private int def;
	public Slime(int hp, int atk, int ene, int def) {
		super();
		this.hp = hp;
		this.atk = atk;
		this.ene = ene;
		this.def = def;
		//hp(80), atk(10), ene(3), def(10)
	}
	public void setHp(int hp) {
		this.hp = 80;
	}
	public int getHp() {
		return hp;
	}
	public void setAtk(int atk) {
		this.atk = 10;
	}
	public int getAtk() {
		return atk;
	}
	public void setEne(int ene) {
		this.ene = 3;
	}
	public int getEne() {
		return ene;
	}
	public void setDef(int def) {
		this.def = 10;
	}
	public int getDef() {
		return def;
	}
}


