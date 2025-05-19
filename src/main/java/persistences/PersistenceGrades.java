/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;

import structures.ArrayList;

/**
 * Clase encargada de gestionar una lista de calificaciones utilizando un
 * arreglo dinamico para almacenarlas
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class PersistenceGrades {

    private ArrayList<Double> grades;

    /**
     * Constructor que inicializa el arreglo dinamico de calificaciones vacio
     * con un tamanio de 10
     */
    public PersistenceGrades() {
        this.grades = new ArrayList<>(10);
    }

    /**
     * Agrega una nueva calificacion a la lista
     *
     * @param grade nueva calificacion
     */
    public void addGrade(Double grade) {
        grades.add(grade);
    }

    /**
     * Actualiza una calificacion de la lista por medio de un indice
     *
     * @param grade calificacion a actualizar
     * @param index indice al cual aplicar el cambio
     */
    public void updateGrade(Double grade, int index) {
        grades.set(grade, index);
    }

    /**
     * Elimina una calificacion de la lista
     *
     * @param grade calificacion a eliminar
     */
    public void removeGrade(Double grade) {
        grades.remove(grade);
    }

    /**
     * Devuelve el promedio de una lista de calificaciones usando recursividad
     *
     * @param index indice del cual continuar la recursividad
     * @param sum suma de todos los elementos del arreglo
     * @return promedio de las calificaciones almacenadads en la lista
     */
    public Double getAverage(int index, Double sum) {
        if (grades.numObjects == 0) {
            return 0.0;
        }
        if (index == grades.numObjects) {
            return sum / grades.numObjects;
        }
        Double grade = grades.get(index);
        if (grade != null) {
            sum += grade;
        }
        return getAverage(index + 1, sum);
    }

    /**
     * Devuelve una lista de elementos de tipo Double con las calificaciones
     *
     * @return grades las calificaciones a mostrar
     */
    public ArrayList<Double> listGrades() {
        return grades;
    }
}
