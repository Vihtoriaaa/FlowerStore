import java.util.ArrayList;

public enum FlowerColor {
    YELLOW, RED, BLUE, BLACK, WHITE;
    ArrayList<FlowerColor> flower_colors = new ArrayList<>();
    public static FlowerColor getRandomColor() {
        return values()[(int) (Math.random() * values().length)];
    }
}