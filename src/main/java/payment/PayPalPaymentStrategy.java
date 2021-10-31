package payment;

public class PayPalPaymentStrategy implements Payment {
    public boolean pay(double price) {
        System.out.println("Payment with PayPal done.");
        return true;
    }
}
