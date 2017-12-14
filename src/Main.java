import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/**
 * Create a Main class with the main method and start running the simulation:
 * Create a Simulation object
 * Load Items for Phase-1 and Phase-2
 * Load a fleet of U1 rockets for Phase-1 and then for Phase-2
 * Run the simulation using the fleet of U1 rockets and display the total budget required.
 * Repeat the same for U2 rockets and display the total budget for that.
 */
public class Main {

    public static void main(String[] args) {

        // Create a Simulation object
        Simulation simulation = new Simulation();

        File filePhase1 = new File ("phase-1.txt");
        File filePhase2 = new File ("phase-2.txt");

        Scanner scannerPhase1 = null;
        Scanner scannerPhase2 = null;

        ArrayList<Item> itemPhase1;
        ArrayList<Item> itemPhase2;

        ArrayList<Rocket> rocketU1;
        ArrayList<Rocket> rocketU2;

        // Set up scanners for item lists
        try {
          scannerPhase1 = new Scanner(filePhase1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            scannerPhase2 = new Scanner(filePhase2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Load Items for Phase-1
        itemPhase1 = simulation.loadItems(scannerPhase1);

        // Load Items for Phase-2
        itemPhase2 = simulation.loadItems(scannerPhase2);

        // Simulation of U1
        // Load a fleet of U1 rockets for Phase-1
        System.out.println("Start of Phase-1 for U1.");
        rocketU1= simulation.loadU1(itemPhase1);

        // Run the simulation of U1 for Phase-1
        simulation.runSimulation(rocketU1);
        System.out.println("End of Phase-1 for U1.\n");

        // Load a fleet of U1 rockets for Phase-2
        System.out.println("Start of Phase-2 for U1.");
        rocketU1= simulation.loadU1(itemPhase2);

        // Run the simulation of U1 for Phase-2
        simulation.runSimulation(rocketU1);
        System.out.println("End of Phase-2 for U1.\n");

        // Simulation of U2
        // Load a fleet of U2 rockets for Phase-1
        System.out.println("Start of Phase-1 for U2.");
        rocketU2= simulation.loadU2(itemPhase1);

        // Run the simulation of U2 for Phase-1
        simulation.runSimulation(rocketU2);
        System.out.println("End of Phase-1 for U2.\n");

        // Load a fleet of U2 rockets for Phase-2
        System.out.println("Start of Phase-2 for U2.");
        rocketU2= simulation.loadU2(itemPhase2);

        // Run the simulation of U2 for Phase-2
        simulation.runSimulation(rocketU2);
        System.out.println("End of Phase-2 for U2.\n");
    }
}
