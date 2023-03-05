import java.util.Scanner;

class Controller {
    private final Scanner sc = new Scanner(System.in, "cp866");
    private final View v = new View();
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
        System.out.println(v.mainMenu[7]);
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
                m.delToy(v.toysInfomashion[0]);
                menu();
                break;
            case "4":
                changeMenu();
            case "5":
                System.out.print("\033[H\033[2J");
                m.lottery();
                menu();
                break;
            case "6":
                System.out.print("\033[H\033[2J");
                m.gv.writeToFileWonToys();
                System.out.println("Нажмите ENTER, чтобы продолжить...");
                sc.nextLine();
                menu();
                break;
            case "7":
                System.out.print("\033[H\033[2J");
                m.gv.giveWonToys();
                ;
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

    void changeMenu() {
        System.out.println("\tМеню изменения информации");
        System.out.print("\033[H\033[2J");
        System.out.println(v.chacgeMenu[0]);
        System.out.println(v.chacgeMenu[1]);
        System.out.println(v.chacgeMenu[2]);
        System.out.println(v.chacgeMenu[3]);
        System.out.println(v.chacgeMenu[4]);
        System.out.print("Выберите опцию: ");
        switch (sc.nextLine()) {
            case "1":
                System.out.print("\033[H\033[2J");
                m.changeId(v.toysInfomashion[0]);
                changeMenu();
                break;
            case "2":
                System.out.print("\033[H\033[2J");
                m.changeTitle(v.toysInfomashion[0]);
                changeMenu();
                break;
            case "3":
                System.out.print("\033[H\033[2J");
                m.changeCount(v.toysInfomashion[0], v.toysInfomashion[2]);
                changeMenu();
                break;
            case "4":
                System.out.print("\033[H\033[2J");
                m.changeDropChance(v.toysInfomashion[0], v.toysInfomashion[3]);
                changeMenu();
                break;
            case "0":
                menu();
                break;
        }

    }
}
