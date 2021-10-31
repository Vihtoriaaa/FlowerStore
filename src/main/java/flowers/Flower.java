package flowers;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Flower implements Item {
    private double sepalLength;
    private FlowerColor color;
    private FlowerType flowerType;
    private double price;
    public Flower() {}

    public String getDescription(){
        return flowerType.toString();
    }
    public void setColor(FlowerColor color) {
        this.color = color;
    }
    public FlowerColor getColor(FlowerColor color) {
        return this.color;
    }
    public Flower(FlowerType flowerType) {
        this.flowerType = flowerType;
    }

    public FlowerType getType() {
        return this.flowerType;
    }

    public void setType(FlowerType type) {
        this.flowerType = type;
    }

    public void setSepalLength(double sepalLength) {
        assert (sepalLength > 0);
        this.sepalLength = sepalLength;
    }

    public double getSepalLength(double sepalLength) {
        return this.sepalLength;
    }
}
