package ItemDecorator;

import flowers.Item;

public abstract class Decorator implements Item {
    private final Item item;

    public Decorator(Item item) {
        this.item = item;
    }

    public String getDescription() {
        return item.getDescription();
    }

    public double getPrice() {
        return item.getPrice();
    }
}
