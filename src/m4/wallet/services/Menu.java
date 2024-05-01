package m4.wallet.services;

import m4.wallet.entities.Currency;
import m4.wallet.entities.User;
import m4.wallet.entities.Wallet;

import java.util.Scanner;

/***
 * Clase con las interfaces de Consola del Sistema.
 */
public class Menu {

    /***
     * Metodo con el Menu Inicial de la aplicacion, partiendo con la bienvenida y el Login.
     */
    public static void login(){
        boolean isLog = false;
        String loginEmail;
        String loginPwd;

        Login lg = new Login();
        UserServices us = new UserServices();

        Scanner sc = new Scanner(System.in);


        do {
            do {
                System.out.println("Inicio de Sesion");
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Ingrese Correo Electronico");
                loginEmail = sc.nextLine();
                if (loginEmail.isBlank()) {
                    System.out.println("Debe ingresar un valor");
                    System.out.println("Intente nuevamente");
                } else {
                    do {
                        System.out.println("Ingrese Contraseña");
                        loginPwd = sc.nextLine();
                        if (loginPwd.isBlank()) {
                            System.out.println("Debe ingresar un valor");
                            System.out.println("Intente nuevamente");
                        } else {
                            int login = lg.login(loginEmail,loginPwd);
                            if ( login == 0){
                                System.out.println("Login Exitoso");
                                isLog = true;
                                mainMenu(us.userLookupByMail(loginEmail));
                            }else {
                                lg.loginErrorReader(login);
                            }
                        }
                    } while (loginPwd.isBlank());
                }
            } while (loginEmail.isBlank());
        }while(!isLog);

        sc.close();


    }

    /***
     * Metodo con la vista principal de la aplicacion tras iniciar Sesion.
     * Incluye los Datos del usuario y las operaciones que se pueden realizar.
     * @param user User. Corresponde al usuario que inicio sesion
     */
    public static void mainMenu(User user){

        DataConnector dc = new DataConnector();
        WalletServices ws = new WalletServices();
        DataValidator dv = new DataValidator();
        Scanner sc = new Scanner(System.in);

        int option = -1;
        Currency usd = dc.getCurrencies().get(1);
        String usdSymbol = usd.getSymbol();

        Wallet wallet = ws.getWalletByUser(user);
        wallet.loadContacts();

        do {
            System.out.println("*********************AlkeWallet*********************");
            System.out.println("Bienvenid@: " + user.getFirstName() + " " + user.getLastName());
            System.out.println("Saldo en cuenta: " + wallet.getAccount().getCurrency().getSymbol() + wallet.getAccount().getBalance());
            System.out.println("Saldo (en USD): " + usdSymbol + wallet.showAsNewCurrency(usd));
            int validation;
            do {
                System.out.println("Seleccione una operacion: ");
                System.out.println("// 1.Depositar // 2.Transferir // 3.Salir //");
                String res = sc.nextLine();
                validation = dv.validateNumber(res);
                if (validation == 0) {
                    option = Integer.parseInt(res);
                } else {
                    dv.errorValidator(validation);
                }
            }while(validation != 0);

            switch (option){
                case 1:
                    deposit(wallet);
                    break;
                case 2:
                    transfer(wallet);
                    break;
                case 3:
                    System.out.println("Hasta Luego");
            }

        }while(option != 3);


    }

    /***
     * Menu correspondiente a las operacion de carga de saldo en la cuenta.
     * @param wallet Wallet. Billetera con la que se va a trabajar.
     */
    public static void deposit(Wallet wallet){
        Scanner sc = new Scanner(System.in);
        DataValidator dv = new DataValidator();

        int validInput;

        System.out.println("Depositos");
        System.out.println("***********************************************");
        do{
        System.out.println("Ingrese Monto a Agregar a la Cuenta");
        System.out.println("Saldo Actual: "+wallet.getAccount().getBalance());
        String res = sc.nextLine();
        validInput = dv.validateNumber(res);
        if(validInput == 0){
            double amount = Double.parseDouble(res);
            wallet.deposit(amount);
        }else{
            dv.errorValidator(validInput);
        }}while(validInput != 0);



    }

    /***
     * Menu para transferir fondos a otro usuario.
     * @param wallet Wallet. Billetera con la que se va a trabajar.
     */
    public static void transfer(Wallet wallet){

        Scanner sc = new Scanner(System.in);
        DataValidator dv = new DataValidator();
        TransactionValidator ts = new TransactionValidator();

        int validInput;
        double amount;

        System.out.println("Transferencias");
        System.out.println("***********************************************");
        do{
            System.out.println("Ingrese Monto a Transferir");
            System.out.println("Saldo Disponible: "+wallet.getAccount().getBalance());
            String res = sc.nextLine();
            validInput = dv.validateNumber(res);
            if(validInput == 0){

                amount = Double.parseDouble(res);
                int validContact = 0;
                do{
                    int index = 0;
                    System.out.println("Seleccione Contacto a Transferir");
                    for(User u: wallet.getContacts().getContacts()){
                        System.out.println((index+1 )+"._ "+u.getFirstName()+" "+u.getLastName());
                        index++;
                    }
                    String contactNum = sc.nextLine();
                    int contactValidator = dv.validateNumber(contactNum);
                    if(contactValidator == 0){
                        int contact = Integer.parseInt(contactNum);
                        if(contact >= 1 && contact <= wallet.getContacts().getContacts().size()){
                            if(ts.validateTransfer(amount,wallet.getAccount().getBalance()) == 0){
                                User chosenContact = wallet.getContacts().getContacts().get(contact - 1);
                                validContact = 0;
                                wallet.transfer(chosenContact,amount);
                            }else {
                                System.out.println("Fondos insuficientes");
                            }


                        }else {
                            System.out.println("Debe ingresar una opcion valida");
                            validContact = 1;
                        }
                    }else {
                        dv.errorValidator(contactValidator);
                    }


                }while(validContact != 0);

            }else{
                dv.errorValidator(validInput);
            }}while(validInput != 0);



    }
}
