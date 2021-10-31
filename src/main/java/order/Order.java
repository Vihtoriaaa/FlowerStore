package order;
import delivery.Delivery;
import flowers.Item;
import payment.Payment;
import java.util.ArrayList;


public class Order {
    public ArrayList<Item> items = new ArrayList<>();
    private Payment payment;
    private Delivery delivery;

    public void setPaymentStrategy(Payment payment){
        this.payment = payment;
    }

    public void setDeliveryStrategy(Delivery delivery){
        this.delivery = delivery;
    }

    public double calculateTotalPrice(){
        double sum = 0;
        for (Item item: items){
            sum += item.getPrice();
        }
        return sum;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public void processOrder(){
        double paymentSum = calculateTotalPrice();
        if (payment.pay(paymentSum)){
            delivery.deliver(items);
        }
    }
}
