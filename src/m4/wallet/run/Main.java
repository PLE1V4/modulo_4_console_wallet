package m4.wallet.run;

import m4.wallet.services.AppData;
import m4.wallet.services.Menu;
import m4.wallet.services.UserServices;



public class Main {



    public static void main(String[] args) {

        UserServices us = new UserServices();

        AppData.initializeData();

        System.out.println("Bienvenido a AlkeWallet");
        System.out.println("-------------------------------------------------------------------");

        Menu.login();



    }

}
