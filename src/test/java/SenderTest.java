import org.junit.jupiter.api.Test;
import users.*;

import static org.junit.jupiter.api.Assertions.*;

class SenderTest {
    Sender user_one = new Sender();
    Sender user_two = new Sender();
    Sender user_three = new Sender();

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
        assertInstanceOf(Sender.class, user_one);
        assertInstanceOf(Sender.class, user_two);
    }
}