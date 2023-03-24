public class Battle extends Thread {
    Player player;
    Monster monster;

    public Battle(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    @Override
    public void run() {
        int playerHealth = player.getHealth();
        int playerPotionCount = player.getPotionCount();
        int playerPotionPower = player.getPotionPower();
        int monsterHealth = monster.getHealth();
        while (playerHealth > 0 && monsterHealth > 0) {
            int damage = player.attack();
            monsterHealth -= damage;
            System.out.printf("%s наносит %d урона %s\n", player.getName(), damage, monster.getName());
            damage = monster.attack();
            System.out.printf("%s наносит %d урона %s\n", monster.getName(), damage, player.getName());
            playerHealth -= damage;
            if (playerHealth <= 0) {
                if (playerPotionCount > 0) {
                    --playerPotionCount;
                    playerHealth += playerPotionPower;
                    System.out.printf("%s выпил зелье и восстановил %d очков здоровья\n", player.getName(), playerPotionPower);
                }
            }
        }
        if (playerHealth > 0) {
            int monsterGold = monster.getGold();
            int monsterExp = monster.getExperience();
            player.setGold(player.getGold() + monsterGold);
            player.setExperience(player.getExperience() + monsterExp);
            System.out.printf("Герой победил! Получено %d золота и %d очков опыта\n", monsterGold, monsterExp);
        } else System.out.println("Герой проиграл!");
    }
}
