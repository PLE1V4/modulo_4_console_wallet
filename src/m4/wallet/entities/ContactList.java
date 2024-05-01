package m4.wallet.entities;

import java.util.ArrayList;
import java.util.Objects;

/***
 * Clase que almacena la lista de contactos a Transferir de una WalleT
 */
public class ContactList {

    private ArrayList<User> contacts = new ArrayList<>();

    /***
     * Metodo que devuelve la lista de Contactos como un ArrayList
     * @return ArrayList<User>
     */
    public ArrayList<User> getContacts() {
        return contacts;
    }

    /***
     * Metodo que agrega un nuevo contacto a la lista de Contactos
     * @param user (parametro de Tipo User)
     */
    public void addContact(User user) {
        this.getContacts().add(user);
    }

    /***
     * Metodo que crea una lista de contactos a partir del la lista de usuarios de la aplicacion
     * @param  de tipo User corresponde al usuario a excluir de la lista de contactos
     * @param userList de tipo ArrayList<User>, es la lista de usuarios que se debe revisar para crear la lista
     * @return un objeto de tipo ContactList
     */
    public ContactList fillContacts(User user,ArrayList<User> userList){

        ContactList contactos = new ContactList();

       for(User u: userList)
       {
           if(!Objects.equals(u,user)){
               contactos.addContact(u);
           }
       }

        return contactos;
    }
}
