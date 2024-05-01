package m4.wallet.services;

/***
 * Clase que maneja el inicio de sesion de un usuario.
 */
public class Login {

    UserServices us = new UserServices();

    /***
     * Constructor vacio para instanciar la clase
     */
    public Login() {
    }

    /***
     * Metodo que recibe los parametros de inicio de sesion, y verifica si el usuario esta registrado o no
     * @param email String. Correo electronico ingresado por el usuario a verificar
     * @param password String. Contrasea Ingresada por el Usuario  a verificar
     * @return INT. Codigo de error segun el resultado de la verificacion. 0 si es exitosa.
     */
    public int login(String email, String password){

        int result;

        if(us.userIsRegistered(email) == 1)
        {
            String pwd = us.userLookupByMail(email).getPassword();
            if(pwd.equals(password)){
                result = 0;
            }else {
                result = 1;
            }
        }else{
            result = 2;
        }

        return result;

    }

    /***
     * Metodo que recibe un codigo de error desde metodo Login() e imprime un mensaje segun corresponda
     * @param error Int, codigo de error de Login().
     */

    public void loginErrorReader(int error){

        switch(error){
            case 1:
                System.out.println("Contraseña Incorrecta");
                System.out.println("Intente nuevamente....");
                break;
            case 2:
                System.out.println("Correo no registrado");
                System.out.println("Intente nuevamente....");
                break;

        }
    }
}
