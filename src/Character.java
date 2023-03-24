public abstract class Character {
    private final String name;
    private int health;
    private int experience;
    private int strength;
    private int agility;
    private int gold;

    public Character(String name, int health, int experience, int strength, int agility, int gold) {
        this.name = name;
        this.health = health;
        this.experience = experience;
        this.strength = strength;
        this.agility = agility;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public  int attack() {
        boolean criticalHit = Math.random() < 0.05; // вероятность критического удара 5%
        int attackStrength;
        if (getAgility() * 3 > (int) (Math.random() * 100)) attackStrength = getStrength();
        else attackStrength = 0;
        if (attackStrength != 0) {
            if (criticalHit) attackStrength *= 2;
        }
        return attackStrength;
    }

}
