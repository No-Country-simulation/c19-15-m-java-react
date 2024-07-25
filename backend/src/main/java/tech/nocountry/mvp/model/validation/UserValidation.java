package tech.nocountry.mvp.model.validation;

import tech.nocountry.mvp.domain.Doctor;
import tech.nocountry.mvp.domain.Patient;
import tech.nocountry.mvp.model.dto.ResponseDTO;

import java.util.regex.Pattern;

public class UserValidation {
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
    private static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[a-zA-Z]).{8,16}$";

    public ResponseDTO validate(Patient user) {
       ResponseDTO response = new ResponseDTO();
       boolean isValid = true;
       if (!isValidEmail(user.getEmail())) {
           response.addMessage("El correo no tiene formato válido.");
           isValid = false;
       }
       if (user.getPassword() == null||
               !user.getPassword().matches(PASSWORD_REGEX)){
           response.addMessage("La contraseña debe tener entre 8 y 16 caracteres, al menos un número, una minúscula y una mayúscula.");
           isValid = false;
       }
       if (isValid) {
           response.addMessage("Datos correctos.");
       }
        return response;
    }

    private boolean isValidEmail(String email) {
        return email != null && EMAIL_REGEX.matcher(email).matches();
    }

}