import java.util.Random;
import java.util.Scanner;

class Model {
    Toy toy;
    protected final ShopWarehouse sw = new ShopWarehouse();
    private final Scanner sc = new Scanner(System.in, "cp866");
    protected final GivingToys gv = new GivingToys();

    void addToys(String idInfo, String titleInfo, String countInfo, String dropChanceInfo) {
        int id;
        String title;
        int count;
        int dropChance;
        
        do {
            System.out.print("\033[H\033[2J");
            if(sw.toys.size() > 0) sw.showToys();
            System.out.println("Заполните данные о товаре:");

            System.out.print(idInfo + ": ");
            id = uniqueID(checkingNumber(idInfo));

            System.out.print(titleInfo + ": ");
            title = sc.nextLine();

            System.out.print(countInfo + ": ");
            count = checkingNumber(countInfo);

            System.out.print(dropChanceInfo + ": ");
            dropChance = checkingDropChance(dropChanceInfo);

            sw.toys.add(new Toy(id, title, count, dropChance));
            System.out.print("\nДобавить ещё игрушки? (д/н): ");
        } while (!sc.nextLine().equalsIgnoreCase("н"));
    }

    void changeDropChance(String idInfo, String dropChanceInfo) {
        if (sw.toys.size() == 0) {
            sw.showAllToys();
        } else {
            do {
                System.out.print("\033[H\033[2J");
                sw.showToys();
                System.out.print("Введите Id Игрушки чтобы изменить шанс выпадения: ");
                int index = findIdToys(checkingNumber(idInfo));
                if (index == (-1)) {
                    System.out.println("Игрушка с таким Id не найдена!");
                    System.out.println("Нажмите ENTER, чтобы продолжить или введите \"н\", чтобы выйти.");
                } else {
                    toy = sw.toys.get(index);
                    System.out.printf("Введите новый шанс выпадения для игрушки \"%s\" (id: %s): ", toy.title, toy.id);
                    toy.dropСhance = checkingDropChance(dropChanceInfo);
                    System.out.print("Изменить шанс для другой игрушки? (д/н): ");
                }
            } while (!sc.nextLine().equalsIgnoreCase("н"));
        }
    }

    void lottery() {
        Random rd = new Random();
        int num;
        do {
            int size = sw.toys.size();
            if (size == 0) {
                break;
            }
            int id = (int) (rd.nextInt(size));
            toy = sw.toys.get(id);
            System.out.print("\033[H\033[2J");
            for (int i = 0; i < 1; i++) {
                num = (int) (Math.random() * 100) + 1;
                if (num <= toy.dropСhance && num >= 1) {
                    System.out.println("Вы выйграли игрушку " + toy.title);
                    System.out.println("Осталось " + (--toy.count) + " " + toy.title);
                    gv.addWonToys(toy);
                } else {
                    System.out.println("Вы не выйграли игрушку ");
                    System.out.println("Осталось " + toy.count + " " + toy.title);
                }
            }
            if (toy.count > 0) {
                System.out.print("Хотите испытать удачу снова? (д/н): ");
            } else {
                System.out.println(toy.title + " закончились(");
                sw.toys.remove(id);
                System.out.print("Продолжить? (д/н): ");
            }
        } while (!sc.nextLine().equalsIgnoreCase("н"));
    }

    int checkingNumber(String info) {
        int num;
        while (true) {
            String input = sc.nextLine();
            try {
                num = Integer.parseInt(input);
                return num;
            } catch (NumberFormatException ex) {
               
                System.out.printf("Пожалуйста введите %s ЧИСЛОМ: ", info);
            }
        }

    }

    int findIdToys(int id) {
        int index = -1;
        for (int i = 0; i < sw.toys.size(); i++) {
            if (id == sw.toys.get(i).id) {
                index = i;
                break;
            }
        }
        return index;
    }

    int uniqueID(int id) {
        int step = 0;
        do {
            for (int i = 0; i < sw.toys.size(); i++) {
                if (id == sw.toys.get(i).id) {
                    System.out.print("Играшка с таким Id уже есть!\n\nВведите другой Id: ");
                    id = checkingNumber("Id");
                    step--;
                    break;
                }
            }
            step++;
        } while (step < 1);
        return id;
    }

    int checkingDropChance(String info) {
        int num;
        while (true) {
            num = checkingNumber(info);
            if (num >= 0 && num <= 100) {
                return num;
            } else {
                    System.out.println("Шанс выпадения игрушки находиться в промежутке от 0 до 100!");
                    System.out.print("Повторите ввод шанса для выпадения: ");
            }
        }
        
    }

}