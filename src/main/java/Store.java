import java.util.ArrayList;
import java.util.*;

public class Store {
    public Store() {}

    ArrayList<Flower> flower_store = new ArrayList<Flower>();
    Map<FlowerType, Integer> flower_prices = new HashMap<FlowerType, Integer>();
    Random rand = new Random();

    public void Create_Storage() {
        flower_prices.put(FlowerType.CHAMOMILE, 15);
        flower_prices.put(FlowerType.ROSE, 25);
        flower_prices.put(FlowerType.TULIP, 20);
        for (int ind = 0; ind < 200; ind++) {
            Flower rand_flower = new Flower(FlowerType.getRandomType());
            rand_flower.setColor(FlowerColor.getRandomColor());
            rand_flower.setSepalLength(rand.nextInt(70));
            rand_flower.setPrice(flower_prices.get(rand_flower.getFlowerType()));
            flower_store.add(rand_flower);
        }
    }
    public void search(int money){
        int roses_quantity = 0, tulip_quantity = 0, chamomile_quantity = 0, bucket_sum = 0;;
        FlowerBucket bucket = new FlowerBucket();
        while (money > bucket.getPrice()){
            Flower bucket_flower = flower_store.get(rand.nextInt(flower_store.size()));
            if (bucket_flower.getPrice() > money - bucket_sum){
                break;
            }
            bucket_sum += bucket_flower.getPrice();
            if (bucket_flower.getFlowerType() == FlowerType.ROSE) {
                roses_quantity += 1;
            } else if (bucket_flower.getFlowerType() == FlowerType.TULIP) {
                tulip_quantity += 1;
            } else if (bucket_flower.getFlowerType() == FlowerType.CHAMOMILE) {
                chamomile_quantity += 1;
            }
            FlowerPack pack = new FlowerPack(bucket_flower, 1);
            bucket.addFlowerPack(pack);
            flower_store.remove(bucket_flower);
        }
        System.out.println("We formed you a bucket for the price " + bucket_sum);
        System.out.println("The flower bucket looks like this:");
        System.out.println(roses_quantity + " roses, " + tulip_quantity + " tulips, " + chamomile_quantity + " chamomiles.");
        if (bucket_sum != money){
            System.out.println("Here is your change " + (money-bucket_sum) + ".");
        }
    }
}

