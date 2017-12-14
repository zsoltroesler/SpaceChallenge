/**
 *  Item class that includes a String name and an int weight that will represent an item to be carried by the rockets
 */
public class Item {

    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName(){
        return name;
    }

    public int getWeight(){
        return weight;
    }
}
