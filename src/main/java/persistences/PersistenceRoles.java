/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;
import components.Student;
import structures.CircularLinkedList;

/**
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class PersistenceRoles {
    private CircularLinkedList<Student> roles;

    public PersistenceRoles(){
        this.roles = new CircularLinkedList<>();
    }

    public Student rotateRole(){
        return roles.rotateNode().getValue();
    }
}