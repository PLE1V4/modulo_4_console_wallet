package m4.wallet.entities;

/***
 * Clase que represeta la cuenta de los usuarios del Sistema
 */
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    /***
     * Constructor de la clase usuario
     * @param id tipo Int. Identificador Unico del Usuario
     * @param firstName tipo String. Corresponde al nombre del usuario
     * @param lastName tipo String. Corresponde al apellido del usuario
     * @param email tipo String. Corresponde al correo electronico del usuario
     * @param password tipo String. Corresponde a la contraseña del usuario
     */
    public User(int id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
