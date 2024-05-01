package m4.wallet.services;

import m4.wallet.entities.User;

/***
 * Interfaz con los metodos que tiene que tener toda clase que consulte usuarios almacenados
 */
public interface UserServicesOperations {

    /***
     * Metodo para verificar si un usuario existe
     * @param email String. Correo a buscar
     * @return Int. codigo de exito/error
     */
    int userIsRegistered(String email);

    /***
     * Metodo que retorna un objeto usuario indicando un email
     * @param email String. Email del usuario a buscar
     * @return User. Objeto usuario encontrado.
     */
    User userLookupByMail(String email);

}
