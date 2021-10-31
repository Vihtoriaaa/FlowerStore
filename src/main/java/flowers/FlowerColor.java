package flowers;

public enum FlowerColor {
    YELLOW, RED, BLUE, BLACK, WHITE;
    public static FlowerColor getRandomColor() {
        return values()[(int) (Math.random() * values().length)];
    }
}