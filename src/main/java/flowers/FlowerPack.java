package flowers;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FlowerPack {
    private int amount;
    private Item flower;
    public String desc;
    public void setFlower(Item flower) {
        this.flower = flower;}

    public Item getFlower() {
        return flower;}

    public void setAmount(int quantity) {
        this.amount = quantity;}

    public int getAmount() {
        return amount;}

    public double getPrice() {
        return flower.getPrice() * amount;
    }

    public FlowerPack(Item flower, int amount) {
        this.flower = flower;
        this.amount = amount;
        this.desc = flower.getDescription();
    }
}
