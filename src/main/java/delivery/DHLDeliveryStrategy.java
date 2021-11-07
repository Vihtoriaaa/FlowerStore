package delivery;
import flowers.Item;
import java.util.List;

public class DHLDeliveryStrategy implements Delivery {
    public void deliver(List<Item> items) {
        System.out.println("\nNext item(s) will be delivered by DHL:");
        String desc = "Bouquet with ";
        int rose_count = 0, tulip_counter = 0, chamomile_count = 0, other = 0;
        for (Item item: items)
            if (item.getDescription().equals("ROSE")){
                rose_count += 1;
            } else if (item.getDescription().equals("CHAMOMILE")){
                chamomile_count += 1;
            } else if (item.getDescription().equals("TULIP")){
                tulip_counter += 1;
            } else {
                other += 1;
            }
        desc += rose_count + " roses, " + tulip_counter + " tulips, " + chamomile_count + " chamomiles, " + other + " " +  items.get(items.size() - 1).getDescription();
        System.out.println(desc);
    }
}
