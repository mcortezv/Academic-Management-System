/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;
import persistences.PersistenceGrades;
import structures.ArrayList;
import interfaces.Identificable;
import java.util.Random;
import validators.Validator;

/**
 * Clase que representa un estudiante dentro del sistema
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public final class Student implements Identificable {
    private String id;
    private String fullName;
    private Contact contactDetails;
    private PersistenceGrades grades;

    /**
     * Constructor vacio del estudiante
     */
    public Student() {
        this.id = generateRandomId();
    }

    /**
     Constructor que establece los atributos de la instancia al valor de sus
     * parametros
     * @param fullName
     * @param contactDetails
     */
    public Student(String fullName, Contact contactDetails) {
        this.id = generateRandomId();
        this.contactDetails = contactDetails;

    }

    /**
     * Constructor que establece los atributos de la instancia al valor de sus
     * parametros
     *
     * @param id
     * @param fullName
     * @param contactDetails
     * @param grades
     */
    public Student(String id, String fullName, Contact contactDetails, PersistenceGrades grades) {
        this.id = generateRandomId();
        this.fullName = fullName;
        this.contactDetails = contactDetails;
        this.grades = grades;
    }

    /**
     * Obtiene el id del estudiante
     *
     * @return id del estudiante
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Obtiene el nombre del estudiante
     *
     * @return nombre del estudiante
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Obtiene la instancia del contacto del estudiante
     *
     * @return instancia del contacto
     */
    public Contact getContactDetails() {
        return contactDetails;
    }

    /**
     * Establece el id del estudiante al valor de su parametro
     *
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Establece el nombre completo del estudiante al valor de su parametro
     *
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Establece el contacto del estudiante al valor de su parametro
     *
     * @param contactDetails
     */
    public void setContactDetails(Contact contactDetails) {
        this.contactDetails = contactDetails;
    }

    /**
     * Agrega la calificacion obtenida del parametro al arreglo de
     * calificaciones del estudiante
     *
     * @param grade
     */
    public void addGrade(Double grade) {
        grades.addGrade(grade);
    }

    /**
     * Actualiza una calificacion obtenida del parametro
     *
     * @param grade
     * @param index
     */
    public void updateGrade(Double grade, int index) {
        grades.updateGrade(grade, index);
    }

    /**
     * Calcula el promedio del calificacion del estudiante
     *
     * @return average
     */
    @Override
    public Double getAverage() {
        return grades.getAverage(0, 0.0);
    }

    /**
     * Lista todas las calificaciones del estudiante
     *
     * @return grades
     */
    public ArrayList<Double> listGrades() {
        return grades.listGrades();
    }

    /**
     * Compara la instancia del estudiante con otro objeto que implementa la
     * interfaz
     *
     * @param o el objeto con el cual se compara el estudiante
     * @return
     */
    @Override
    public int compareTo(Identificable o) {
        return this.id.compareTo(o.getId());
    }

    /**
     * Metodo que regresa un id generado aleatoreamente y valida que cumpla con
     * el formato establecido para el id en el sistema
     *
     * @return id aleatorio
     */
    public String generateRandomId() {
        Random random = new Random();
        String numbers = String.format("%04d", random.nextInt(10000));
        String letters = "";
        for (int i = 0; i < 4; i++) {
            char letter = (char) (random.nextInt(26) + 'A');
            letters += letter;
        }
        String id = numbers + letters;
        if (Validator.validateId(id)) {
            return id;
        } else {
            return generateRandomId();
        }
    }

    /**
     * Metodo que regresa una cadena de texto con todos los atributos de la
     * instancia
     *
     * @return
     */
    @Override
    public String toString() {
        return "Estudiante{" + "Matricula: " + id + ", Nombre Completo: " + fullName + ", Datos de Contecto: " + contactDetails + '}';
    }

}
