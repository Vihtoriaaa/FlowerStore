package payment;

public class CreditCardPaymentStrategy implements Payment {
    public boolean pay(double price) {
        System.out.println("Payment with credit cad done.");
        return true;
    }
}
