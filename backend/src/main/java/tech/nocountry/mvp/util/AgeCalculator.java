package tech.nocountry.mvp.util;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {
    public static int calculateAge(LocalDate birthDate) {
        if (birthDate == null) {
            return 0; // O lanza una excepción si la fecha de nacimiento es nula
        }
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }
}