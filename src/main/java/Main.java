import java.util.Scanner;
import ItemDecorator.*;
import delivery.*;
import flowers.*;
import order.*;
import payment.*;
import users.*;


public class Main {
    private static final Store newStore = new Store();

    public static void main(String[] args) {
        System.out.println("Welcome to store Victory Pobeditelnitsa!\n");
        newStore.Create_Storage();
        Order order = new Order();
        Item bucket = new FlowerBucket();
        Scanner sc = new Scanner(System.in);
        System.out.println("How much you want to spend on the bouquet?");
        int money = sc.nextInt();
        newStore.search(money);
        order.items.addAll(newStore.flower_order);
        Scanner scan = new Scanner(System.in);
        System.out.println("\nWhat do you want to decorate?\nPaper, Basket or Ribbon");
        String answer = scan.next();
        switch (answer) {
            case "Paper":
                order.addItem(new PaperDecorator(bucket));
                break;
            case "Basket":
                order.addItem(new BasketDecorator(bucket));
                break;
            case "Ribbon":
                order.addItem(new RibbonDecorator(bucket));
                break;
        }
        System.out.println("Total sum is equal to " + order.calculateTotalPrice());
        System.out.println("\nHow do you want to pay?\nPayPal or CreditCard");
        String answer_pay = scan.next();
        if (answer_pay.equals("PayPal")){
            order.setPaymentStrategy(new PayPalPaymentStrategy());
        } else if (answer_pay.equals("CreditCard")){
            order.setPaymentStrategy(new CreditCardPaymentStrategy());
        } else {
            order.setPaymentStrategy(null);
        }
        System.out.println("\nHow do you want to deliver your order?\nDHL or PostDeliver");
        String del_answer = scan.next();
        if (del_answer.equals("DHL")){
            order.setDeliveryStrategy(new DHLDeliveryStrategy());
        } else if (del_answer.equals("PostDeliver")){
            order.setDeliveryStrategy(new PostDeliverStrategy());
        } else {
            order.setDeliveryStrategy(null);
        }
        System.out.println("\nWant to send an order or to receive?");
        String ord_answer = scan.next();
        if (ord_answer.equals("receive")){
            User user = new Receiver();
            order.addUser(user);
        } else if (ord_answer.equals("send")){
            User user = new Sender();
            order.addUser(user);
        }
        order.processOrder();
        System.out.println("Goodbye! Have a nice day :-)");
    }
}
