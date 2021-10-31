package flowers;

public enum FlowerType {
    ROSE, TULIP, CHAMOMILE;
    public static FlowerType getRandomType() {
        return values()[(int) (Math.random() * values().length)];
    }
}
