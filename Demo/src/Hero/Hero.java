package Hero;

public class Hero {
    String name;
    float hp;
    float armor;
    int moveSpeed;

    float getHp(){
        return hp;
    }
    public static void main(String[] args) {
        Hero garan = new Hero();
        garan.name = "盖伦";
        garan.hp = 618.28f;
        garan.armor = 27.536f;
        garan.moveSpeed = 350;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 383;
        teemo.armor = 14;
        teemo.moveSpeed = 330;
    }
}
