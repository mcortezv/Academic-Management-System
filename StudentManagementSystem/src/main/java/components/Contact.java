/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

/**
 *
 * @author Sebas
 */
public class Contact {
    private String phoneNumber;
    private String eMail;
    private String zipCode;
    
    /**
     * 
     * @param phoneNumber
     * @param eMail
     * @param zipCode 
     */
    public Contact(String phoneNumber, String eMail, String zipCode){
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Contacto{" + "Numero de telefono: " + phoneNumber + ", Correo Electronico: " + eMail + ", Codigo Postal: " + zipCode + '}';
    }
    
    
}
