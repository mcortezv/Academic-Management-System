/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;
import components.Student;
import structures.ArrayList;
import structures.CircularDoubleLinkedList;

/**
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class PersistenceWaitingListCourses {
    private CircularDoubleLinkedList<Student> waitingListCourses;

    public PersistenceWaitingListCourses(){
        this.waitingListCourses = new CircularDoubleLinkedList<>();
    }

    public void enrollStudentWaitingList(Student student){
        waitingListCourses.add(student);
    }

    public ArrayList<Student> getList(){
        return waitingListCourses.getList();
    }
}