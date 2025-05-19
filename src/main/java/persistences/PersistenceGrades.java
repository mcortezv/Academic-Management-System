/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistences;
import structures.ArrayList;

/**
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class PersistenceGrades {
    private ArrayList<Double> grades;

    public PersistenceGrades(){
        this.grades = new ArrayList<>(10);
    }

    public void addGrade(Double grade){
        grades.add(grade);
    }

    public void updateGrade(Double grade, int index){
        grades.set(grade, index);
    }

    public void removeGrade(Double grade){
        grades.remove(grade);
    }

    public Double getAverage(int index, Double sum) {
        if (grades.numObjects == 0) {
            return 0.0;
        }
        if (index == grades.numObjects) {
            return sum / grades.numObjects;
        }
        return getAverage(index + 1, sum + grades.get(index));
    }


    public ArrayList<Double> listGrades(){
        return grades;
    }
}
