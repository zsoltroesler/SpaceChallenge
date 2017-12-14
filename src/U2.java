import java.util.Random;

public class U2 extends Rocket {

    public U2(){
        super();
        rocketCost = 120; // 120 million
        rocketWeight = 18000; // Rocket weight 10 tonnes without cargo
        maxRocketWeight = 29000; // Max weight cargo included
        currentRocketWeight = rocketWeight;
        cargoLimit = maxRocketWeight - rocketWeight;
    }

    /**
     * Calculate the corresponding chance of exploding in lauch
     */
    @Override
    public boolean launch() {
        // Chance of launch explosion = 4% * (cargo carried / cargo limit)
        chanceOfExplosion = 0.04 * ((double) currentRocketWeight / (double) cargoLimit);
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
        // Chance of landing crash = 8% * (cargo carried / cargo limit)
        chanceOfCrash = 0.08 * ((double) currentRocketWeight / (double) cargoLimit);
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
