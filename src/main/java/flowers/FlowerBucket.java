package flowers;
import java.util.ArrayList;
import java.util.List;

public class FlowerBucket implements Item {
    public List<FlowerPack> flowerPackList = new ArrayList<>();
    String descriptionString = "";
    private double price;

    public FlowerBucket() {
        this.price = 0;
        this.descriptionString = this.getDescription();
    }

    public void addFlowerPack(FlowerPack flowerPack) {
        flowerPackList.add(flowerPack);
        this.price += flowerPack.getPrice();
        this.descriptionString += flowerPack.desc + ", ";
    }

    public double getPrice() {
        double price = 0;
        for (FlowerPack flowerPack: flowerPackList) {
            price += flowerPack.getPrice();}
        return price;
    }
    public String getDescription() {;
        return this.descriptionString;
    }
}
