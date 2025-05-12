/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;
import components.Course;
import structures.CircularDoubleLinkedList;

/**
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class PersistenceWaitingListCourses {
    private CircularDoubleLinkedList<Course> waitingListCourses;

    public PersistenceWaitingListCourses(){
        this.waitingListCourses = new CircularDoubleLinkedList<Course>();
    }
}