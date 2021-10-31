import flowers.Flower;
import flowers.FlowerType;
import order.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestOrder {
    private Order order;
    private Flower flower;

    @BeforeEach
    void setUp() {
        order = new Order();
        flower = new Flower(FlowerType.ROSE);
        flower.setPrice(50);
        order.addItem(flower);
    }

    @Test
    void TestTotalPrice() {
        assertEquals(50, order.calculateTotalPrice());
        Flower flower2 = new Flower(FlowerType.TULIP);
        flower2.setPrice(90);
        order.addItem(flower2);
        assertEquals(140, order.calculateTotalPrice());
    }

    @Test
    void TestRemoveItem() {;
        assertEquals(50, order.calculateTotalPrice());
        order.removeItem(flower);
        assertEquals(0, order.calculateTotalPrice());
    }

    @Test
    void TestAddItem() {
        assertEquals(50, order.calculateTotalPrice());
        Flower flower2 = new Flower(FlowerType.CHAMOMILE);
        flower2.setPrice(5);
        order.addItem(flower2);
        assertEquals(55, order.calculateTotalPrice());
    }
}