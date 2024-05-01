package m4.wallet.services;

import m4.wallet.entities.User;

/***
 * Clase para consultas respecto a los Usuarios de la aplicacion.
 */
public class UserServices  implements UserServicesOperations {

    DataConnector dc = new DataConnector();

    /***
     * Impementacion de metodo para verificar is un usuario esta registrado utilizando su email.
     * @param email String. Correo electronico ingresado por el usuario
     * @return int. Codigo de error. 0 si no exite. 1 si esta.
     */
    @Override
    public int userIsRegistered(String email) {
        int registered = 0;
        for (User u: dc.getUsers()){
            if (u.getEmail().equals(email)) {
                registered = 1;
                break;
            };
        }
        return registered;
    }

    /***
     * Implementacion de metodo que retorna un usuario de la aplicacion utilizando su Email.
     * @param email Email del usuario a buscar
     * @return User. Objeto usuario encontrado con el correo electronico.
     */
    @Override
    public User userLookupByMail(String email) {
        User user = null;
        for(User u: dc.getUsers()){
            if(u.getEmail().equals(email)){
                user = u;
            }
        }
        return user;
    }
}
