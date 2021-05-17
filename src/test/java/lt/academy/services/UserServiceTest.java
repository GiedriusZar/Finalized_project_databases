package lt.academy.services;

import lt.academy.entities.User;
import lt.academy.hibernate.HibernateConfiguration;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {

    @BeforeEach
    void beforeEach() {
UserService userService = new UserService();


    }

    @AfterEach
    void tearDown() {

    }


    @Test
    public void save() {
        UserService userService = new UserService();
        User user = new User("TestName", "TestSurname", "1234567891234567", "None", null);
        userService.save(user);
        assertEquals(user.getCardNo().length(), 16);
    }
}
