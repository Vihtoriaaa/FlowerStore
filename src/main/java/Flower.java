import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;


@Getter @Setter
public class Flower {
    private double sepalLength;
    private FlowerColor color;
    private FlowerType flowerType;
    private double price;

    public Flower() {}
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
