import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import order.*;

import static org.junit.jupiter.api.Assertions.*;

class FastOrderConstructorTest {

    Order order;

    @BeforeEach
    void setUp() {
        order = FastOrderConstructor.createOrder(FastOrderConstructor.ROSE_BUCKET, 5, 5, "DHL", "Card");
    }

    @Test
    void createOrder() {
        assertEquals(50, order.calculateTotalPrice());

        order = FastOrderConstructor.createOrder(FastOrderConstructor.TULIP_BUCKET, 10, 10, "Post", "Card");
        assertEquals(100, order.calculateTotalPrice());

        order = FastOrderConstructor.createOrder(FastOrderConstructor.CHAMOMILE_BUCKET, 9, 7, "DHL", "PayPal");
        assertEquals(70, order.calculateTotalPrice());
    }
}