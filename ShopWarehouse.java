import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

class ShopWarehouse {
    private final Scanner sc = new Scanner(System.in, "cp866");
    ArrayList<Toy> toys = new ArrayList<Toy>();
    ArrayDeque<Toy> wonToys = new ArrayDeque<Toy>();

    void showAllToys(){
        if (toys.size() != 0) {
            for (int i = 0; i < toys.size(); i++) {
                System.out.printf("Id: %d | Название: %s | количество: %d | шанс выпадения: %d\n", toys.get(i).id, toys.get(i).title, toys.get(i).count, toys.get(i).dropСhance);
            }
            System.out.println("Нажмите ENTER, чтобы продолжить...");
            sc.nextLine();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.println("Игрушек не найдено!\nДобавьте новые игрушки во вкладке \"Добавить игрушки\" в главном меню.");
            System.out.println("Нажмите ENTER, чтобы продолжить...");
            sc.nextLine();
        }
    }

    void showToys(){
        for (int i = 0; i < toys.size(); i++) {
            System.out.printf("Id: %d | Название: %s | количество: %d | шанс выпадения: %d\n", toys.get(i).id, toys.get(i).title, toys.get(i).count, toys.get(i).dropСhance);
        }
    }
}