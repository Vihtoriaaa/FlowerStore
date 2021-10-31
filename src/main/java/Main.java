import java.util.Scanner;
import ItemDecorator.BasketDecorator;
import ItemDecorator.PaperDecorator;
import ItemDecorator.RibbonDecorator;
import delivery.DHLDeliveryStrategy;
import delivery.PostDeliverStrategy;
import flowers.*;
import order.Order;
import payment.CreditCardPaymentStrategy;
import payment.PayPalPaymentStrategy;

public class Main {
    private static final Store newStore = new Store();

    public static void main(String[] args) {
        System.out.println("Welcome to store Victory Pobeditelnitsa!");
        newStore.Create_Storage();
        Order order = new Order();
        Item bucket = new FlowerBucket();
        Scanner sc = new Scanner(System.in);
        System.out.println("How much you want to spend on the bouquet?");
        int money = sc.nextInt();
        newStore.search(money);
        order.items.addAll(newStore.flower_order);
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want to decorate?\nPaper, Basket or Ribbon");
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
        System.out.println("How do you want to pay?\nPayPal or CreditCard");
        String answer_pay = scan.next();
        if (answer_pay.equals("PayPal")){
            order.setPaymentStrategy(new PayPalPaymentStrategy());
        } else if (answer_pay.equals("CreditCard")){
            order.setPaymentStrategy(new CreditCardPaymentStrategy());
        }
        System.out.println("How do you want to deliver your order?\nDHL or PostDeliver");
        String del_answer = scan.next();
        if (del_answer.equals("DHL")){
            order.setDeliveryStrategy(new DHLDeliveryStrategy());
        } else if (del_answer.equals("PostDeliver")){
            order.setDeliveryStrategy(new PostDeliverStrategy());
        }
        order.processOrder();
        System.out.println("Goodbye! Have a nice day :-)");
    }
}
