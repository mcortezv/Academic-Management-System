/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;

import components.Contact;
import components.Student;
import structures.CircularLinkedList;

/**
 * Clase encargado de almacenar la persistencia de estudiantes utilizados como
 * "roles" para los cursos disponibles enel sistema, almacenandolos en una lista
 * enlazada circular
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public final class PersistenceRoles {

    private final CircularLinkedList<Student> roles;

    /**
     * Constructor que inicializa la lista de roles como vacia
     */
    public PersistenceRoles() {
        this.roles = new CircularLinkedList<>();
        populateRoles();
    }

    /**
     * Rota el siguiente estudiante en la lista de roles y lo devuelve
     *
     * @return estudiante con el rol de tutor
     */
    public Student rotateRole() {
        var node = roles.rotateNode();
        if (node.getValue() != null) {
            return node.getValue();
        }
        return null;
    }

    /**
     *
     * @return
     */
    public Student undoRotateRol() {
        var node = roles.undoRotateNode();
        return node.getValue();
    }

    /**
     * Metodo auxiliar que permite agregar estudiantes al sistema y establecer
     * los mismos con un rol designado a algun curso en el sistema
     */
    public void populateRoles() {
        Contact datosContacto = new Contact("6681118936", "sebastian@gmail.com", "81271");
        Student student1 = new Student("2222BBBB", "Sebas", datosContacto);
        Student student2 = new Student("1234AAAA", "manuel", datosContacto);
        Student student3 = new Student("5555CCCC","david",datosContacto);
        roles.add(student1);
        roles.add(student2);
        roles.add(student3);
    }
}
