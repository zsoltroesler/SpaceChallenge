import java.util.Random;

public class U1 extends Rocket {

    public U1(){
        rocketCost = 100; // 100 million
        rocketWeight = 10000; // Rocket weight 10 tonnes without cargo
        maxRocketWeight = 18000; // Max weight cargo included
        currentRocketWeight = rocketWeight;
        cargoLimit = maxRocketWeight - rocketWeight;
    }

    /**
     * Calculate the corresponding chance of exploding in launch
     */
    @Override
    public boolean launch() {
         // Chance of launch explosion = 5% * (cargo carried / cargo limit)
        chanceOfExplosion = 0.05 * ((double) currentRocketWeight / (double) cargoLimit);
        double randomChance = getRandom();
        if (chanceOfExplosion >= randomChance){
            return false;
        } return true;
    }

    /**
     * Calculate the corresponding chance of crashing in landing
     */
    @Override
    public boolean land(){
        // Chance of landing crash = 1% * (cargo carried / cargo limit)
        chanceOfCrash = 0.01 * ((double) currentRocketWeight / (double) cargoLimit);
        double randomChance = getRandom();
        if (chanceOfCrash >= randomChance){
            return false;
        } return true;
    }

    /**
     * Helper method to get a random number
     */
    private double getRandom(){
        Random random = new Random();
        return random.nextDouble();
    }
}
