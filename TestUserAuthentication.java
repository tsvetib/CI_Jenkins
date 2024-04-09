import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUserAuthentication {

    @Test
    public void testMockSuccessfulAuthentication() {
        User user = new MockUserSuccess19316("test_user", "password");
        assertTrue(user.authenticate("password"));
    }

    @Test
    public void testMockUnsuccessfulAuthentication() {
        User user = new MockUserFail19316("test_user", "password");
        assertFalse(user.authenticate("wrong_password"));
    }
}
