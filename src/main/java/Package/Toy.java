package Package;

public class Toy {

    protected int id;
    protected String name;
    protected int amount = 1;
    protected int weight;

    protected Toy(int id, String name, int weight) {

        this.id = id;
        this.name = name;
        this.weight = weight;
    }
}