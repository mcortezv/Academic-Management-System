/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

/**
 * Clase que representa un rol en el sistema
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class Role {

    private String name;

    /**
     * Constructor que establece los atributos de la instancia al valor de sus
     * parametros
     *
     * @param name
     */
    public Role(String name) {
        this.name = name;
    }

    /**
     * Metodo que regresa una cadena de texto con el nombre del rol
     *
     * @return name nombre
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo que establece el nombre de la instancia del rol al valor de su
     * parametro
     *
     * @param name nombre
     */
    public void setName(String name) {
        this.name = name;
    }
}
