import Package.*;

public class Main {

    public static void main(String[] args) {

        ShopToys.newToyShop();
        ShopToys.showShop();
        System.out.println("-----------------------------------------------------------------------------------");
        RaffleQueue.makeQueue();
        RaffleQueue.showQueue();
        RaffleQueue.startRaffle();
        
    }
}