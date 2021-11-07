import flowers.*;
import java.util.ArrayList;
import java.util.*;

public class Store {
    public ArrayList<Item> flower_order;
    public int tulip_quantity, chamomile_quantity, roses_quantity;
    public double total_price;
    ArrayList<Item> flower_store = new ArrayList<>();
    Map<FlowerType, Integer> flower_prices = new HashMap<>();
    Random rand = new Random();

    public Store() {
        this.total_price = 0;
        this.roses_quantity = 0;
        this.tulip_quantity = 0;
        this.chamomile_quantity = 0;
        this.flower_order = new ArrayList<>();}

    public void Create_Storage() {
        flower_prices.put(FlowerType.CHAMOMILE, 15);
        flower_prices.put(FlowerType.ROSE, 25);
        flower_prices.put(FlowerType.TULIP, 20);
        for (int ind = 0; ind < 1000; ind++) {
            Flower rand_flower = new Flower(FlowerType.getRandomType());
            rand_flower.setColor(FlowerColor.getRandomColor());
            rand_flower.setSepalLength(rand.nextInt(70));
            rand_flower.setPrice(flower_prices.get(rand_flower.getFlowerType()));
            flower_store.add(rand_flower);}
    }
    public void search(int money){
        int bucket_sum = 0;
        FlowerBucket bucket = new FlowerBucket();
        while (money > bucket.getPrice()){
            Flower bucket_flower = (Flower) flower_store.get(rand.nextInt(flower_store.size()));
            if (bucket_flower.getPrice() > money - bucket_sum){
                break;}
            bucket_sum += bucket_flower.getPrice();
            this.flower_order.add(bucket_flower);
            if (bucket_flower.getFlowerType() == FlowerType.ROSE) {
                this.roses_quantity += 1;
            } else if (bucket_flower.getFlowerType() == FlowerType.TULIP) {
                this.tulip_quantity += 1;
            } else if (bucket_flower.getFlowerType() == FlowerType.CHAMOMILE) {
                this.chamomile_quantity += 1;}
            FlowerPack pack = new FlowerPack(bucket_flower, 1);
            bucket.addFlowerPack(pack);
            flower_store.remove(bucket_flower);}
        System.out.println("We formed you a bucket for the price " + bucket_sum);
        System.out.println("The flower bucket looks like this:");
        System.out.println(this.roses_quantity + " roses, " + this.tulip_quantity + " tulips, " + this.chamomile_quantity + " chamomiles.");
        if (bucket_sum != money){
            System.out.println("Your change is " + (money - bucket_sum) + ".");}
        this.total_price = bucket_sum;
    }
}

