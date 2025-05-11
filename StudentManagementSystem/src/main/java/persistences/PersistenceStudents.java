/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;
import components.Student;
import structures.BinarySearchTree;

/**
 *
 * @author Sebas
 */
public class PersistenceStudents {
    private BinarySearchTree<Student> students;

    public PersistenceStudents(){
        this.students = new BinarySearchTree<Student>();
    }

    public void addStudent(Student student){
        students.insert(students.raiz, student);
    }

    public void removeStudent(Student student){
        students.remove(student);
    }

    public Student searchStudent(String id){
        return students.get(id);
    }

    public BinarySearchTree<Student> listStudents(){
        return students;
    }
}