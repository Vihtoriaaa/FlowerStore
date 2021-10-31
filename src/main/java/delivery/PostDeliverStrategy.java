package delivery;
import flowers.Item;
import java.util.List;

public class PostDeliverStrategy implements Delivery {
    public void deliver(List<Item> items) {
        System.out.println("Next item(s) will be delivered by post:");
        String description = "Bouquet with ";
        int roses = 0, tulips = 0, chamomiles = 0, other = 0;
        for (Item item: items)
            if (item.getDescription().equals("ROSE")){
                roses += 1;
            } else if (item.getDescription().equals("CHAMOMILE")){
                chamomiles += 1;
            } else if (item.getDescription().equals("TULIP")){
                tulips += 1;
            } else {
                other += 1;
            }
        description += roses + " roses, " + tulips + " tulips, " + chamomiles + " chamomiles, " + other + " " +  items.get(items.size() - 1).getDescription();
        System.out.println(description);
    }
}
