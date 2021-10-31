import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import payment.*;

public class TestPayment {

    @Test
    void TestPayPal() {
        PayPalPaymentStrategy paypal = new PayPalPaymentStrategy();
        assertEquals(true, paypal.pay(1000.5));
        assertEquals(true, paypal.pay(0.5));
    }

    @Test
    void TestCreditCart() {
        CreditCardPaymentStrategy credit = new CreditCardPaymentStrategy();
        assertEquals(true, credit.pay(5436.763234));
        assertEquals(true, credit.pay(0.00));
    }
}