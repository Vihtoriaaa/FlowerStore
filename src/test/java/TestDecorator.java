import flowers.Flower;
import flowers.FlowerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ItemDecorator.*;


class TestDecorator {
    private Flower flower;

    @BeforeEach
    void setUp() {
        flower = new Flower(FlowerType.TULIP);
        flower.setPrice(22);
    }

    @Test
    void getBasketDecorator() {
        BasketDecorator bask = new BasketDecorator(flower);
        assertEquals(26, bask.getPrice());
        flower.setPrice(15);
        assertEquals(19, bask.getPrice());
    }

    @Test
    void getPaperDecorator() {
        PaperDecorator bask = new PaperDecorator(flower);
        assertEquals(35, bask.getPrice());
        flower.setPrice(9);
        assertEquals(22, bask.getPrice());
    }

    @Test
    void getRibbonDecorator() {
        RibbonDecorator bask = new RibbonDecorator(flower);
        assertEquals(62, bask.getPrice());
        flower.setPrice(100);
        assertEquals(140, bask.getPrice());
    }
}