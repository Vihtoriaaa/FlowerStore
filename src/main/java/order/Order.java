package order;
import delivery.Delivery;
import flowers.Item;
import payment.Payment;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import users.*;


public class Order {
    public ArrayList<Item> items = new ArrayList<>();
    private Payment payment;
    private Delivery delivery;
    List<User> users = new LinkedList<>();

    public void setPaymentStrategy(Payment payment){
        this.payment = payment;
    }

    public Payment getPaymentStrategy(){
        return this.payment;
    }

    public void setDeliveryStrategy(Delivery delivery){
        this.delivery = delivery;
    }

    public Delivery setDeliveryStrategy(){
        return this.delivery;
    }

    public double calculateTotalPrice(){
        double sum = 0;
        for (Item item: items){
            sum += item.getPrice();
        }
        return sum;
    }

    public void addUser(User user){
        users.add(user);
    }
    public void removeUser(User user){
        users.remove(user);
    }
    public void notifyUsers(){
        for (User user : users) {
            user.update("yes");
        }
    }
    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public void processOrder(){
        double paymentSum = calculateTotalPrice();
        if((payment == null) || (delivery == null)){
            System.out.println("Error. Set payment and delivery to process order");
            notifyUsers("no");
            return;
        }
        else if(items.isEmpty()){
            System.out.println("Error. Items list is empty");
            notifyUsers("no");
            return;
        }
        else if ((payment!=null) && (delivery !=null) && (payment.pay(paymentSum))){
            delivery.deliver(items);
            notifyUsers("yes");
        }
    }
    private void notifyUsers(String status){
        for (User user : users) {
            user.update(status);
        }
    }
}
