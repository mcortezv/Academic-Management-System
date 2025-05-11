/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

/**
 *
 * @author Sebas
 */
public class Action {
    public enum Type {
        addStudent,
        searchStudent,
        removeStudent,
        addCourse,
        removeCourse,
        listCourses,
        enrollStudentInCourse,
        showEnrolledStudentsInCourse,
        showWaitingListForCourse,
        submitGradesRequest,
        processNextRequest,
        listStudents,
        rotateRoles,
    }
    private final Type type;
    private final Object data;
    /**
     * 
     * @param type
     * @param data
     */
    public Action(Type type, Object data){
        this.type = type;
        this.data = data;
    }

    public Type getType(){
        return this.type;
    }

    public Object getData(){
        return this.data;
    }
}
