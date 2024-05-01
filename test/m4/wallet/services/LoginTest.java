package m4.wallet.services;

import m4.wallet.entities.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LoginTest {

    String email = "demo@wallet.cl";
    String pwd = "123456";
    Login testLogin = new Login();


    LoginTest(){
       MockitoAnnotations.openMocks(this);
    }

    @Test
    void login() {

        UserServices testUs = Mockito.mock(UserServices.class);
        User testUser = Mockito.mock(User.class);

        when(testUs.userIsRegistered(email)).thenReturn(1);
        when(testUs.userLookupByMail(email)).thenReturn(testUser);
        when(testUser.getPassword()).thenReturn("123456");
        int testResult = testLogin.login(email,pwd);
        assertEquals(testResult,0);
    }
}