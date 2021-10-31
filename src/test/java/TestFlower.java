import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TestFlower {
    private Flower flower;

    @BeforeEach
    void setUp() {
        flower = new Flower(FlowerType.ROSE);
        flower.setPrice(10);
        flower.setSepalLength(28);
        flower.setColor(FlowerColor.RED);
    }

    @Test
    void getPrice() {
        assertEquals(10, flower.getPrice());
        flower.setPrice(33.3);
        assertEquals(33.3, flower.getPrice());
    }

    @Test
    void getColor() {
        assertEquals(FlowerColor.RED, flower.getColor());
        flower.setColor(FlowerColor.YELLOW);
        assertEquals(FlowerColor.YELLOW, flower.getColor());
    }

    @Test
    void getType() {
        assertEquals(FlowerType.ROSE, flower.getType());
        flower.setType(FlowerType.CHAMOMILE);
        assertEquals(FlowerType.CHAMOMILE, flower.getType());
    }

    @Test
    void getSepalLength() {
        assertEquals(28, flower.getSepalLength());
        flower.setSepalLength(50);
        assertEquals(50, flower.getSepalLength());
    }
}
