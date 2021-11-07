package payment;

public class CreditCardPaymentStrategy implements Payment {
    public boolean pay(double price) {
        System.out.println("Payment with credit card done.");
        return true;
    }
}
