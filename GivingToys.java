import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class GivingToys {
    private final ShopWarehouse sw = new ShopWarehouse();
    private final Scanner sc = new Scanner(System.in, "cp866");
    private final File file = new File(
            "C:/Users/vgard/OneDrive/Рабочий стол/РАЗРАБОТКА/Java/ToysLottery/WinToys/Toys.txt");

    void addWonToys(Toy toy) {
        sw.wonToys.add(toy);
    }

    void giveWonToys() {
        if (file.length() != 0) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                String text = "";
                String line = reader.readLine();
                while (line != null) {
                    text += line + "\n";
                    line = reader.readLine();
                }
                System.out.print(text + "Хотите выдать игрушки? (д/н): ");
                if (!sc.nextLine().equalsIgnoreCase("н")) {
                    System.out.println("Игрушки выданы!");
                    new FileWriter(
                            "C:/Users/vgard/OneDrive/Рабочий стол/РАЗРАБОТКА/Java/ToysLottery/WinToys/Toys.txt",
                            false).close();
                } else {
                    System.out.println("Не забудте выдать игрушки в следующий раз!");
                }
                reader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (file.length() == 0 && sw.wonToys.size() == 0){
            System.out.println(
                    "Список выйгранных игрушек пуст, сначала проведите лотерею и \"Заполните список призов\" в главном меню");
        } else if (file.length() == 0 && sw.wonToys.size() > 0){
            System.out.println(
                    "Список выйгранных игрушек пуст, сначала \"Заполните список призов\" в главном меню");
        }

    }

    void writeToFileWonToys() {
        if (sw.wonToys.size() > 0 && file.length() == 0) {
            try (FileWriter writer = new FileWriter(
                    "C:/Users/vgard/OneDrive/Рабочий стол/РАЗРАБОТКА/Java/ToysLottery/WinToys/Toys.txt",
                    false)) {

                String text = "Игрушки для выдачи:\n";
                while (sw.wonToys.peek() != null) {
                    var tmpToy = sw.wonToys.removeFirst();
                    text += String.format("Id: %d | Название: %s\n", tmpToy.id, tmpToy.title);
                }
                System.out.println(text);
                writer.write(text);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else if(sw.wonToys.size() > 0 && file.length() != 0){
            System.out.println("Перед заполнением нового списка выдайте предыдущие игрушки!\n");
            giveWonToys();
        } else if ( file.length() != 0){
            System.out.println("Список призов уже заполнен.\n");
            giveWonToys();
        } else{
            giveWonToys();
        }
    }
}