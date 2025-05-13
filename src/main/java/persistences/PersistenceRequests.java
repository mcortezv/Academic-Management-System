/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;

import components.Action;
import components.Request;
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
        if (request.getType() == Request.Type.addGrade) {
            request.getStudent().addGrade((Double) request.getData());
            persistenceActions.addAction(new Action(Action.Type.addGrade, request.getStudent(), request.getData()));
        } else if (request.getType() == Request.Type.removeGrade) {
            request.getStudent().updateGrade(0.0, (int) request.getData());
            persistenceActions.addAction(new Action(Action.Type.updateGrade, request.getStudent(), request.getData()));
        } else if (request.getType() == Request.Type.updateGrade) {
            request.getStudent().updateGrade((Double) request.getData(), request.getIndex());
            persistenceActions.addAction(new Action(Action.Type.updateGrade, request.getStudent(), request.getData(), request.getIndex()));
        } else if (request.getType() == Request.Type.listGrades) {
            persistenceActions.addAction(new Action(Action.Type.listGrades, request.getStudent()));
            return request.getStudent().listGrades();

        }
        return null;
    }

}
