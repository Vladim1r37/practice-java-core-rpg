import java.util.Scanner;

public class Merchant {
    int gold;
    int potionCount;
    int potionPrice;
    int potionPower;

    public Merchant(int gold, int potionCount, int potionPrice, int potionPower) {
        this.gold = gold;
        this.potionCount = potionCount;
        this.potionPrice = potionPrice;
        this.potionPower = potionPower;
    }

    public void trade(Player player) {
        System.out.println("Здравствуйте, " + player.getName());
        System.out.println("Сколько бутылок лекарственного зелья вы хотите купить?");
        Scanner scanner = new Scanner(System.in);
        int buyCount = 0;
        String s = scanner.nextLine();
        while (buyCount == 0) {
            if (s.matches("\\d+")) buyCount = Integer.parseInt(s);
            else System.out.println("Вы ввели неправильное значение.");
        }
        if (player.getGold() >= buyCount * potionPrice) {
            if (potionCount >= buyCount) {
                player.setGold(player.getGold() - (buyCount * potionPrice));
                player.setPotionCount(player.getPotionCount() + buyCount);
                player.setPotionPower(potionPower);
                potionCount -= buyCount;
                System.out.println("Вы купили " + buyCount + " бутылок зелья.");
            }
        } else System.out.println("У вас не хватает золота.");
    }
}
