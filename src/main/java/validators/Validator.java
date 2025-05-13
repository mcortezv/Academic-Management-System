/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Clase validadora que utiliza expresiones regulares para validar los datos de
 * entrada del usuario
 *
 * @author Cortez, Manuel; Escárcega, David; Escalante, Sebastian.
 */
public class Validator {

    /**
     * Valida que el id esté compuesto por cuatro numeros seguidos de cuatro
     * letras mayusculas
     *
     * @param id a vallidar
     * @return boolean
     */
    public static boolean validateId(String id) {
        String regex = "^\\d{4}[A-Z]{4}$";
        return validarRegex(id, regex);
    }

    /**
     * Valida que el nombre esté compuesto solo por letras, la primera
     * mayuscula, ademas de permitir espacios
     *
     * @param name a validar
     * @return boolean
     */
    public static boolean validateName(String name) {
        String regex = "^[A-Za-zÁÉÍÓÚÑáéíóúñ]+(\\s[A-Za-zÁÉÍÓÚÑáéíóúñ]+)*$";
        return validarRegex(name, regex);
    }

    /**
     * Valida que el numero esté compuesto solo de numeros, entre 7 y 15 digitos
     *
     * @param phone a validar
     * @return boolean
     */
    public static boolean validatePhone(String phone) {
        String regex = "^\\d{7,15}$";
        return validarRegex(phone, regex);
    }

    /**
     * Valida que el correo electronico cumpla el formato establecido: parte
     * local, arroba, dominio
     *
     * @param email a validar
     * @return boolean
     */
    public static boolean validateEmail(String email) {
        String regex = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}$";
        return validarRegex(email, regex);
    }

    /**
     * Valida que la calle esté compuesta solo de letras, permitiendo espacios y
     * dando un limite minimo de 3 caractetes y 50 caracteres como maximo
     *
     * @param street a validar
     * @return boolean
     */
    public static boolean validateStreet(String street) {
        String regex = "^[A-ZÁÉÍÓÚÑa-záéíóúñ\\s]{3,50}$";
        return validarRegex(street, regex);
    }

    /**
     * Valida que el numero de la calle este compuesto por numeros, y letras de
     * forma opcional
     *
     * @param number a validar
     * @return boolean
     */
    public static boolean validateStreetNumber(String number) {
        String regex = "^[A-Za-z0-9]+$";
        return validarRegex(number, regex);
    }

    /**
     * Valida que el distrito esté compuesto solo de letras, permitiendo
     * espacios y dando un limite minimo de 2 caractetes y 50 caracteres como
     * maximo
     *
     * @param district a validar
     * @return boolean
     */
    public static boolean validateDistric(String district) {
        String regex = "^[A-ZÁÉÍÓÚÑa-záéíóúñ\\s]{2,50}$";
        return validarRegex(district, regex);
    }

    /**
     * Valida que el curso esté compuesto solo de letras, permitiendo espacios y
     * dando un limite minimo de 5 caractetes y 50 caracteres como maximo
     *
     * @param courseName a validar
     * @return boolean
     */
    public static boolean validateCourseName(String courseName) {
        String regex = "^[A-ZÁÉÍÓÚÑa-záéíóúñ\\s\\d]{5,50}$";
        return validarRegex(courseName, regex);
    }

    /**
     * Valida que la calificacion ingresada sea un numero dentro del rango 0 a
     * 100
     *
     * @param grade a validar
     * @return boolean
     */
    public static boolean validateGrade(int grade) {
        return grade >= 0 && grade <= 100;
    }

    /**
     * Valida que el decimal de la calificacion se encuentre del rango 0.0 a
     * 10.0 con 1 decimal
     *
     * @param grade a validar
     * @return boolean
     */
    public static boolean validateDecimalGrade(double grade) {
        return grade >= 0.0 && grade <= 10.0 && (grade * 10) % 10 == 0;
    }

    /**
     * Valida que un valor cumpla con una expresion regular
     *
     * @param valor del texto que se desea validar
     * @param regex la expresion regular que define el formato esperado
     * @return boolean
     */
    private static boolean validarRegex(String valor, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(valor);
        return matcher.matches();
    }
}
