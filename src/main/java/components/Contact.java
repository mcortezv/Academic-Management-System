/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

/**
 *  Clase que contiene los datos de contacto pertenecientes al estudiante
 * 
 * @author Sebas
 */
public class Contact {
    private String phoneNumber;
    private String eMail;
    private String zipCode;
    
    /**
     * Constructor que inicializa los atributos de la instancia al valor de sus parametros
     * @param phoneNumber
     * @param eMail
     * @param zipCode 
     */
    public Contact(String phoneNumber, String eMail, String zipCode){
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.zipCode = zipCode;
    }
    /**
     * Regresa una cadena de texto con el numero de telefono  
     * @return numero de telefono
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * Regresa una cadena de texto con el correo electronico  
     * @return correo electronico
     */
    public String geteMail() {
        return eMail;
    }
    /**
    * Regresa una cadena de texto con el código postal
     * @return codigo postal
     */
    public String getZipCode() {
        return zipCode;
    }
    /**
     * Metodo que establece a la instancia el atributo phoneNumber al valor de su parametro
     * @param phoneNumber 
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * * Metodo que establece a la instancia el atributo eMail al valor de su parametro
     * @param eMail 
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    /**
     * Metodo que establece a la instancia el atributo zipCode al valor de su parametro
     * @param zipCode 
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Metodo que regresa una cadena de texto con todos los atributos de la instancia 
     * @return cadena de texto con la informacion del contacto
     */
    @Override
    public String toString() {
        return "Contacto{" + "Numero de telefono: " + phoneNumber + ", Correo Electronico: " + eMail + ", Codigo Postal: " + zipCode + '}';
    }
    
    
}
