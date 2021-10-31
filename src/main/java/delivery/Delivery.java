package delivery;
import flowers.Item;
import java.util.List;

public interface Delivery {
    void deliver(List<Item> items);
}
