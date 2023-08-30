package Package;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class RaffleQueue {

    static File file = new File("ToyShop\\src\\main\\java\\Prizes.txt");
    static Random r = new Random();
    static Comparator<Toy> weigthComparator = new Comparator<>() {
        @Override
        public int compare(Toy o1, Toy o2) {
            return r.nextInt(o2.weight) - r.nextInt(o1.weight);
        }
    };
    static Queue<Toy> raffle = new PriorityQueue<>(weigthComparator);


    public static void makeQueue() {

        for (Toy toy : ShopToys.shopToys) {
            int a = toy.amount;
            while (a > 0) {
                raffle.add(toy);
                a--;
            }
        }
    }


    public static void showQueue() {

        System.out.println("Розыгрыш игрушек:");
        for (Toy toy : raffle) {
            System.out.println("Номер:" + toy.id + " Игрушка - " + toy.name + ", \"вес\": "
                    + toy.weight);
        }
    }


    public static void startRaffle() {
        
        try (PrintWriter pw = new PrintWriter(file, StandardCharsets.UTF_8)) {
            for (int i = 0; i < raffle.size() + 1; i += 0) { 
                Toy prize = raffle.poll();
                pw.print("Выигрыш - " + prize.name + " шанс выпадения - " + prize.weight + "\n");
            }
        } catch (IOException | NullPointerException e) {
            System.out.println("\nКонец розыгрыша!");
        } 
    }
}