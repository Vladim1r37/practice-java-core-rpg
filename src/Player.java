public class Player extends Character {
    int potionCount;
    int potionPower;

    public Player(String name, int health, int experience, int strength, int agility, int gold, int potionCount) {
        super(name, health, experience, strength, agility, gold);
        this.potionCount = potionCount;
    }

    public int getPotionCount() {
        return potionCount;
    }

    public void setPotionCount(int potionCount) {
        this.potionCount = potionCount;
    }

    public int getPotionPower() {
        return potionPower;
    }

    public void setPotionPower(int potionPower) {
        this.potionPower = potionPower;
    }
}
