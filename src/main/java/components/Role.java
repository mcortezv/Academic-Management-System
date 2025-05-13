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
     * Enum que define los roles predefinidos del sistema
     */
    public enum RoleType {
        STUDENT("Estudiante"),
        TUTOR("Tutor");

        private final String roleName;

        RoleType(String roleName) {
            this.roleName = roleName;
        }

        public String getRoleName() {
            return roleName;
        }

    }

    /**
     * Constructor que establece el nombre del rol a partir de un nombre
     * predefinido
     *
     * @param roleType
     */
    public Role(RoleType roleType) {
        this.name = roleType.getRoleName();
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
