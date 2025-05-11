/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validators;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author Cortez, Manuel;
 */
public class Validator {

    // 4 Numeros seguidos de 4 letras mayusculas
    public static boolean validateId(String id) {
        String regex = "^\\d{4}[A-Z]{4}$";
        return validarRegex(id, regex);
    }

    // Solo letras y espacios, primera letra en mayuscula
    public static boolean validateName(String name) {
        String regex = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+(\\s[A-ZÁÉÍÓÚÑa-záéíóúñ]+)+$";
        return validarRegex(name, regex);
    }

    // Solo numeros, entre 7 y 15 digitos
    public static boolean validatePhone(String phone) {
        String regex = "^\\d{7,15}$";
        return validarRegex(phone, regex);
    }

    // Valida Correo Electronico
    public static boolean validateEmail(String email) {
        String regex = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}$";
        return validarRegex(email, regex);
    }

    // Letras y espacios, 3 a 50 caracteres
    public static boolean validateStreet(String street) {
        String regex = "^[A-ZÁÉÍÓÚÑa-záéíóúñ\\s]{3,50}$";
        return validarRegex(street, regex);
    }

    // Nmeros y opcionalmente letra
    public static boolean validateStreetNumber(String number) {
        String regex = "^[0-9]+[A-Za-z]?$";
        return validarRegex(number, regex);
    }

    // Letras y espacios, 2 a 50 caracteres
    public static boolean validateDistric(String district) {
        String regex = "^[A-ZÁÉÍÓÚÑa-záéíóúñ\\s]{2,50}$";
        return validarRegex(district, regex);
    }

    // Letras, numeros y espacios, 5 a 50 caracteres
    public static boolean validateCourseName(String courseName) {
        String regex = "^[A-ZÁÉÍÓÚÑa-záéíóúñ\\s\\d]{5,50}$";
        return validarRegex(courseName, regex);
    }

    // 0 a 100
    public static boolean validateGrade(int grade) {
        return grade >= 0 && grade <= 100;
    }

    // 0.0 a 10.0 con 1 decimal
    public static boolean validateDecimalGrade(double grade) {
        return grade >= 0.0 && grade <= 10.0 && (grade * 10) % 10 == 0;
    }

    private static boolean validarRegex(String valor, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(valor);
        return matcher.matches();
    }
}