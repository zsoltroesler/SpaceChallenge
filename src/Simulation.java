import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Simulation class that is responsible for reading item data and filling up the rockets
 */
public class Simulation {

    private ArrayList<Item> itemList;
    private ArrayList<Rocket> fleetOfU1;
    private ArrayList<Rocket> fleetOfU2;
    private int totalCost;

    /**
     * This method loads all items from a text file and returns an ArrayList of Items
     * @param scanner
     * @return Arraylist of items
     */
    public ArrayList<Item> loadItems(Scanner scanner) {
        itemList = new ArrayList<>();

        // Split the lines in a file at "=" for item name and item weight
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] itemNameWeight = line.split("=");
            String itemName = itemNameWeight[0].trim();
            int itemWeight = Integer.parseInt(itemNameWeight[1].trim());
            Item item = new Item(itemName, itemWeight);
            itemList.add(item);
        }
        scanner.close();
        return itemList;
    }

    /**
     * This method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets. It first tries
     * to fill up 1 rocket with as many items as possible before creating a new rocket object and filling that one
     * until all items are loaded. The method then returns the ArrayList of those U1 rockets that are fully loaded.
     * @param itemList
     * @return ArrayList of U1 rockets
     */
    public ArrayList<Rocket> loadU1(ArrayList<Item> itemList) {
        fleetOfU1 = new ArrayList<>();
        Rocket u1 = new U1();
        for (Item item : itemList) {
            if (!u1.canCarry(item)) {
                fleetOfU1.add(u1);
                u1 = new U1();
                System.out.println("Number of U1 rockets used: " + fleetOfU1.size() + "\n");
            }
            u1.carry(item);
        }
        // The last not fully loaded rocket
        fleetOfU1.add(u1);

        System.out.println("Number of U1 rockets used: " + fleetOfU1.size() + "\n");
        return fleetOfU1;
    }

    /**
     * This method takes the ArrayList of Items returned from loadItems and starts creating U2 rockets. It first tries
     * to fill up 1 rocket with as many items as possible before creating a new rocket object and filling that one
     * until all items are loaded. The method then returns the ArrayList of those U1 rockets that are fully loaded.
     * @param itemList
     * @return ArrayList of U2 rockets
     */
    public ArrayList<Rocket> loadU2(ArrayList<Item> itemList) {
        fleetOfU2 = new ArrayList<>();
        Rocket u2 = new U2();
        for (Item item : itemList) {
            if (!u2.canCarry(item)) {
                fleetOfU2.add(u2);
                u2 = new U2();
                System.out.println("Number of U2 rockets used: " + fleetOfU2.size() + "\n");
            }
            u2.carry(item);
        }
        // The last not fully loaded rocket
        fleetOfU2.add(u2);

        System.out.println("Number of U2 rockets used: " + fleetOfU2.size() + "\n");
        return fleetOfU2;
    }

    /**
     * This method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in
     * the ArrayList. Every time a rocket explodes or crashes (i.e if launch or land return false) it will have to send
     * that rocket again. All while keeping track of the total cost required to send each rocket safely to Mars.
     * runSimulation then returns the total cost required to send all rockets (including the crashed ones).
     * @param fleet
     * @return totalCost
     */
    public int runSimulation(ArrayList<Rocket> fleet) {
        totalCost = 0;
        int rocketNumber = 0;
        int failedRocketNumber = 0;
        int sentRocketNumber;

        System.out.println("Simulation starts:");

        for (Rocket rocket : fleet) {
            totalCost += rocket.rocketCost;
            rocketNumber++;

            // if the rocket is exploded when it launches or when it lands, send rocket again
            if (!rocket.launch() || !rocket.land() ){
                System.out.println("Rocket " + rocketNumber + " failed. New rocket sent.");
                totalCost += rocket.rocketCost;
                rocket.launch();
                failedRocketNumber ++;
            }
            System.out.println("Rocket " + rocketNumber + " arrived safely.");
        }

        sentRocketNumber = rocketNumber + failedRocketNumber;
        System.out.println(rocketNumber + " rockets safely arrived out of " + sentRocketNumber + ".");
        System.out.println("Total cost of the mission was: $" + totalCost + " million.");
        return totalCost;
    }
}

