/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;

import components.Action;
import components.Request;
import components.dtos.StudentGradeDTO;
import structures.ArrayList;
import structures.Queue;

/**
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class PersistenceRequests {

    private Queue<Request> requests;
    private PersistenceActions persistenceActions;

    public PersistenceRequests(PersistenceActions persistenceActions) {
        this.requests = new Queue<>();
        this.persistenceActions = persistenceActions;
    }

    public void addRequest(Request request) {
        requests.enqueue(request);
    }

    public ArrayList<Double> processNextRequest() {
        Request request = requests.dequeue();
        StudentGradeDTO studentGradeDTO = (StudentGradeDTO) request.getData();
        Double grade = studentGradeDTO.getGrade();
        if (request.getType() == Request.Type.addGrade) {
            studentGradeDTO.getStudent().addGrade(grade);
            persistenceActions.addAction(new Action(Action.Type.addGrade, studentGradeDTO));
        } else if (request.getType() == Request.Type.removeGrade) {
            studentGradeDTO.getStudent().updateGrade(0.0, studentGradeDTO.getIndex());
            persistenceActions.addAction(new Action(Action.Type.updateGrade, studentGradeDTO));
        } else if (request.getType() == Request.Type.updateGrade) {
            studentGradeDTO.getStudent().updateGrade(studentGradeDTO.getGrade(), studentGradeDTO.getIndex());
            persistenceActions.addAction(new Action(Action.Type.updateGrade, studentGradeDTO));
        } else if (request.getType() == Request.Type.listGrades) {
            persistenceActions.addAction(new Action(Action.Type.listGrades, studentGradeDTO));
            return studentGradeDTO.getStudent().listGrades();
        }
        return null;
    }
}