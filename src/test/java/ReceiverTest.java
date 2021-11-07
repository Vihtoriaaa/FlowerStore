import org.junit.jupiter.api.Test;
import users.*;

import static org.junit.jupiter.api.Assertions.*;

class ReceiverTest {
    Receiver user_one = new Receiver();
    Receiver user_two = new Receiver();
    Receiver user_three = new Receiver();

    @Test
    void getId() {
        assertEquals(1, user_two.getId() - user_one.getId());
        assertEquals(2, user_three.getId() - user_one.getId());
        assertEquals(0, user_three.getId() - user_three.getId());
    }

    @Test
    void checkInstance(){
        assertInstanceOf(User.class, user_one);
        assertInstanceOf(User.class, user_three);
        assertInstanceOf(Receiver.class, user_one);
        assertInstanceOf(Receiver.class, user_two);
    }
}