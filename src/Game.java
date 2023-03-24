import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);
    private static String s;
    private static Player player = null;
    private static Merchant merchant = new Merchant(1000, 10, 10, 20);
    private static Monster[] monsters = {new Monster("Skeleton", 110, 30, 8, 3, 50),
            new Monster("Goblin", 130, 40, 12, 4, 90)};

    public void start() {
        System.out.println("Введите ваше имя.");
        while (true) {
            s = scanner.nextLine();
            if (s.matches("\\w+")) {
                player = new Player(s, 100, 0, 10, 5, 10, 0);
                break;
            } else System.out.println("Недопустимые символы в имени. попробуйте ещё раз.");
        }
        printNavigation();
        command(scanner.nextLine());


    }

    private static void command(String s) {
        switch (s) {
            case "1":
                trade();
            case "2":
                fight();
            case "3":
                System.exit(1);
            case "нет":
                printNavigation();
                command(scanner.nextLine());
        }
    }

    private static void printNavigation() {
        System.out.println("""
                Куда вы хотите пойти?
                1. К торговцу.
                2. В тёмный лес.
                3. На выход.
                """);
    }

    private static void fight() {
        Monster monster = monsters[(int) (Math.random() * 2)];
        Thread thread = new Battle(player, monster);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Желаете продолжить поход? Нет - вернуться в город. (да/нет)");

        do {
            s = scanner.nextLine();
        } while (!s.equals("да") && !s.equals("нет"));
        if (s.equals("да")) command("2");
        command(s);
    }

    private static void trade() {
        merchant.trade(player);
        System.out.println("Желаете продолжить торговлю? Нет - вернуться в город. (да/нет)");
        do {
            s = scanner.nextLine();
        } while (!s.equals("да") && !s.equals("нет"));
        if (s.equals("да")) command("1");
        command(s);
    }
}
