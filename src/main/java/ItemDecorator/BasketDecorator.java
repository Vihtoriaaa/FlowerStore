package ItemDecorator;

import flowers.Item;

public class BasketDecorator extends Decorator {
    public BasketDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 4;
    }

    @Override
    public String getDescription() {
        return "Basket Decoration";
    }
}
