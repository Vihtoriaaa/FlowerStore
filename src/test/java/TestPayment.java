import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import payment.*;
import org.junit.jupiter.api.BeforeEach;


public class TestPayment {
    private PayPalPaymentStrategy paypal;
    private CreditCardPaymentStrategy credit;

    @BeforeEach
    void setUp() {
        paypal = new PayPalPaymentStrategy();
        credit = new CreditCardPaymentStrategy();
    }

    @Test
    void TestPayPal() {
        assertEquals(true, paypal.pay(1000.5));
        assertEquals(true, paypal.pay(0.5));
    }

    @Test
    void TestCreditCart() {
        assertEquals(true, credit.pay(5436.763234));
        assertEquals(true, credit.pay(0.00));
    }
}
