/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;
import components.Role;
import components.Student;
import structures.CircularLinkedList;

/**
 *
 * @author Sebas
 */
public class PersistenceRoles {
    private CircularLinkedList<Role> roles;

    public PersistenceRoles(){
        this.roles = new CircularLinkedList<>();
    }

    public Student next(){
        return null;
    }
}