/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;

import components.*;
import components.dtos.StudentGradeDTO;
import structures.ArrayList;
import structures.Queue;

/**
 * Clase encargada de manejar la persistencia de solicitudes de calificaciones
 * agregadas en el sistema, utilizando una cola almacenando datos del tipo
 * Request, ademas de mantener un "historial" de acciones realizadas para que el
 * sistema permita realizar la opcion "deshacer ultima opcion" correctamente
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class PersistenceRequests {

    private Queue<Request> requests;
    private PersistenceActions persistenceActions;

    /**
     * Constructor que inicializa la cola de solicitudes vacia y establece la
     * persistencia de acciones al valor de su parametro
     *
     * @param persistenceActions
     */
    public PersistenceRequests(PersistenceActions persistenceActions) {
        this.requests = new Queue<>();
        this.persistenceActions = persistenceActions;
    }

    /**
     * Agrega una nueva solicitud a la cola
     *
     * @param request solicitud a agregar
     */
    public void addRequest(Request request) {
        requests.enqueue(request);
    }

    /**
     * Devuelve la siguiente solicitud sin eliminarla de la cola
     *
     * @return la proxima solicitud almacenada en la cola
     */
    public Request getNextRequest() {
        return requests.peek();
    }

    /**
     * Procesa la siguente accion en la cola y registra la accion
     * correspondiente. Dependiendo del tipo de solicitud, realiza una accion
     * sobre las calificaciones del estudiante
     *
     * @return
     */
    public ArrayList<Double> processNextRequest() {
        Request request = requests.dequeue();
        StudentGradeDTO studentGradeDTO = (StudentGradeDTO) request.getData();
        Double grade = studentGradeDTO.getGrade();
        if (request.getType() == Request.Type.addGrade) {
            studentGradeDTO.getStudent().addGrade(grade);
            persistenceActions.addAction(new Action(Action.Type.addGrade, studentGradeDTO, "Calificacion añadida"));
        } else if (request.getType() == Request.Type.removeGrade) {
            studentGradeDTO.getStudent().updateGrade(0.0, studentGradeDTO.getIndex());
            persistenceActions.addAction(new Action(Action.Type.updateGrade, studentGradeDTO, "Calificacion eliminada"));
        } else if (request.getType() == Request.Type.updateGrade) {
            studentGradeDTO.getStudent().updateGrade(studentGradeDTO.getGrade(), studentGradeDTO.getIndex());
            persistenceActions.addAction(new Action(Action.Type.updateGrade, studentGradeDTO, "Calificacion actualizada"));
        } else if (request.getType() == Request.Type.listGrades) {
            persistenceActions.addAction(new Action(Action.Type.listGrades, studentGradeDTO, null));
            return studentGradeDTO.getStudent().listGrades();
        }
        return null;
    }
}
