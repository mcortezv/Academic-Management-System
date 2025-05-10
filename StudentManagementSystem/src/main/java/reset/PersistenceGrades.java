/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reset;
import structures.ArrayList;

/**
 *
 * @author Sebas
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

    public Double getAverage(int index, Double sum){
        if (index == grades.numObjects){
            return sum / grades.numObjects;
        }
        return getAverage(index + 1, sum + grades.get(index));
    }

    public ArrayList<Double> listGrades(){
        return grades;
    }
}
