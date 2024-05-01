package m4.wallet.services;


import m4.wallet.entities.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class UserServicesTest {

    UserServices testUs = new UserServices();
    DataConnector dc = new DataConnector();
    User u = Mockito.mock(User.class);

    UserServicesTest(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void userIsRegistered()
    {
        String email = "test";
        Mockito.when(u.getEmail()).thenReturn("test");
        int result = testUs.userIsRegistered(email);
        assertEquals(result,1);
    }

    @Test
    void userLookupByMail() {
    }
}