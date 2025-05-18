/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;
import components.Contact;
import components.Student;
import structures.CircularLinkedList;

/**
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public final class PersistenceRoles {

    private final CircularLinkedList<Student> roles;

    public PersistenceRoles() {
        this.roles = new CircularLinkedList<>();
        populateRoles();
    }

    public Student rotateRole() {
        return roles.rotateNode().getValue();
    }

    public void populateRoles() {
        Contact datosContacto = new Contact("6681118936", "sebastian@gmail.com", "81271");
        Student student1 = new Student("2222BBBB", "Sebas", datosContacto);
        Student student2 = new Student("1234AAAA", "manuel", datosContacto);
        roles.add(student1);
        roles.add(student2);
    }
}
