public class Rocket implements SpaceShip {

    public int rocketCost;
    public int currentRocketWeight;
    public int rocketWeight;
    public int maxRocketWeight;
    public int cargoLimit;
    public double chanceOfExplosion;
    public double chanceOfCrash;

    public Rocket() {
        currentRocketWeight = rocketWeight;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public final void carry(Item item) {
        currentRocketWeight += item.getWeight();
        System.out.println(String.format("Current rocket weight is: %d", currentRocketWeight));
    }

    @Override
    public final boolean canCarry(Item item) {
        if(currentRocketWeight + item.getWeight() > maxRocketWeight) {
            System.out.println("Weight of rocket reached its limit. You need another one.");
            return false;
        } else return true;
    }
}
