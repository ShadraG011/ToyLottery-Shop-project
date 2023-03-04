import java.util.Scanner;

class Controller {
    private final Scanner sc = new Scanner(System.in, "cp866");
    private  final View v = new View();
    private final Model m = new Model();

    void menu() {
        System.out.print("\033[H\033[2J");
        System.out.println("\tГлавное меню");
        System.out.println(v.mainMenu[0]);
        System.out.println(v.mainMenu[1]);
        System.out.println(v.mainMenu[2]);
        System.out.println(v.mainMenu[3]);
        System.out.println(v.mainMenu[4]);
        System.out.println(v.mainMenu[5]);
        System.out.println(v.mainMenu[6]);
        System.out.print("Выберите опцию: ");
        switch (sc.nextLine()) {
            case "1":
                System.out.print("\033[H\033[2J");
                m.sw.showAllToys();
                menu();
                break;
            case "2":
                m.addToys(v.toysInfomashion[0], v.toysInfomashion[1], v.toysInfomashion[2], v.toysInfomashion[3]);
                menu();
                break;
            case "3":
                System.out.print("\033[H\033[2J");
                m.changeDropChance(v.toysInfomashion[0], v.toysInfomashion[3]);
                menu();
                break;
            case "4":
                System.out.print("\033[H\033[2J");
                m.lottery();
                menu();
                break;
            case "5":
                System.out.print("\033[H\033[2J");
                m.gv.writeToFileWonToys();
                System.out.println("Нажмите ENTER, чтобы продолжить...");
                sc.nextLine();
                menu();
                break;
            case "6":
                System.out.print("\033[H\033[2J");
                m.gv.giveWonToys();;
                System.out.println("Нажмите ENTER, чтобы продолжить...");
                sc.nextLine();
                menu();
                break;
            case "0":
                System.out.print("\033[H\033[2J");
                System.out.println("Спасибо за использование приложения!");
                break;
        }
    }
}
