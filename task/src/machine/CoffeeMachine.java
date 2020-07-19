package machine;
import java.util.Scanner;
public class CoffeeMachine {
    static int money = 550;
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;

    static int waterNeeded;
    static int milkNeeded;
    static int beansNeeded;

    static boolean enoughResources;

    public static void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public static void buy(String variety) {
        switch (variety) {
            case "1":
                water -= 250;
                beans -= 16;
                cups -= 1;
                money += 4;
                break;
            case "2":
                water -= 350;
                milk -= 75;
                beans -= 20;
                cups -= 1;
                money += 7;
                break;
            case "3":
                water -= 200;
                milk -= 100;
                beans -= 12;
                cups -= 1;
                money += 6;
                break;
            default:
                break;
        }
    }

    public static void checkResources(String variety) {
        if ((variety.equals("1"))) {
            waterNeeded = 250;
            milkNeeded = 0;
            beansNeeded = 16;
        } else if (variety.equals("2")) {
            waterNeeded = 350;
            milkNeeded = 75;
            beansNeeded = 20;
        } else {
            waterNeeded = 200;
            milkNeeded = 100;
            beansNeeded = 12;
        }

        if (water >= waterNeeded && milk >= milkNeeded && beans >= beansNeeded && cups > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            enoughResources = true;
        } else if (water < waterNeeded) {
            System.out.println("Sorry, not enough water!");
            enoughResources = false;
        } else if (milk < milkNeeded) {
            System.out.println("Sorry, not enough milk");
            enoughResources = false;
        } else if (beans < beansNeeded) {
            System.out.println("Sorry, not enough coffee beans");
            enoughResources = false;
        } else {
            System.out.println("Sorry, not enough cups");
            enoughResources = false;
        }
    }

    public static void fill(int waterRefill, int milkRefill, int beansRefill, int cupsRefill) {
        water += waterRefill;
        milk += milkRefill;
        beans += beansRefill;
        cups += cupsRefill;
    }

    public static void take() {
        System.out.println("I gave you " + money);
        money = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            if (action.equals("exit")){
                return;
            } else {
                switch (action) {
                 case "buy":
                     System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                     String variety = scanner.next();
                     checkResources(variety);
                     if (enoughResources) {
                        buy(variety);
                    }
                     break;
                 case "fill":
                     System.out.println("Write how many ml of water do you want to add:");
                     int waterRefill = scanner.nextInt();
                     System.out.println("Write how many ml of milk do you want to add:");
                     int milkRefill = scanner.nextInt();
                     System.out.println("Write how many mgrams of coffee beans do you want to add:");
                     int beansRefill = scanner.nextInt();
                     System.out.println("Write how many disposable cups do you want to add:");
                     int cupsRefill = scanner.nextInt();
                     fill(waterRefill, milkRefill, beansRefill, cupsRefill);
                     break;
                 case "take":
                     take();
                     break;
                 default:
                     printState();
                     break;
             }
            }
        }
    }
}
