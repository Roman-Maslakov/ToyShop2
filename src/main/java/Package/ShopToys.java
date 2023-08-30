package Package;

import java.util.ArrayList;

public class ShopToys {
    
    static ArrayList<Toy> shopToys = new ArrayList<>();
    /**
     * Добавляем игрушку по уникальному номеру, если ввести уже существующие номер и
     * имя добавится плюс такая же игрушка,
     * если только номер будет совпадать игрушка добавится со свободным id,
     * добавления другой игрушки с существующим номером невозможно
     * 
     * @param id     - уникальный номер
     * @param name   - название игрушки
     * @param weight - шанс выпадения (вес)
     */
    public static void addToy(int id, String name, int weight) {

        boolean flag = true;
        for (int i = 0; i < shopToys.size(); i++) {
            if (shopToys.get(i).id == id) {
                flag = false;
                if (shopToys.get(i).name == name && shopToys.get(i).weight == weight) {
                    shopToys.get(i).amount++;
                    return;
                } else
                    addToy(id + 1, name, weight);
            }
        }
        if (flag)
            shopToys.add(new Toy(id, name, weight));
    }

    public static void changeWeight(int id, int weight) {

        for (int i = 0; i < shopToys.size(); i++)
            if (shopToys.get(i).id == id)
            shopToys.get(i).weight = weight;
        }
        
    public static void newToyShop() {

        for (int i = 0; i < 10; i++)
            addToy(1, "Конструктор", 40);
        for (int i = 0; i < 10; i++)
            addToy(1, "Кукла", 60);
        for (int i = 0; i < 10; i++)
            addToy(1, "Робот", 80);
        for (int i = 0; i < 10; i++)
            addToy(1, "Радиоуправляемая машинка", 20);
    }

    public static void showShop() {

        System.out.println("В нашем магазине:");
        for (Toy toy : shopToys) {
            System.out.println("Номер:" + toy.id + " Игрушка - " + toy.name + ", кол-во: " + toy.amount + ", \"вес\": "
                    + toy.weight);
        }
    }
}