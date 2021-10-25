import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FlowerPack {
    private int amount;
    private Flower flower;
    public void setFlower(Flower flower) {
        this.flower = flower;}

    public Flower getFlower() {
        return flower;}

    public void setAmount(int quantity) {
        this.amount = quantity;}

    public int getAmount() {
        return amount;}

    public double getPrice() {
        return flower.getPrice() * amount;
    }

    public FlowerPack(Flower flower, int amount) {
        this.flower = flower;
        this.amount = amount;
    }

}
