import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import database.*;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionTest {
    Connection connect_one;
    Connection connect_two;

    @BeforeEach
    void setUp() {
        connect_one = Connection.getConnection();
        connect_two = Connection.getConnection();
    }

    @Test
    void getConnection() {
        assertEquals(connect_one, connect_two);
    }
}