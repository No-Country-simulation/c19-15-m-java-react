package tech.nocountry.mvp.model.validation;

import tech.nocountry.mvp.domain.Patient;
import tech.nocountry.mvp.model.dto.ResponseDTO;

public class UserValidation {
    public ResponseDTO validate(Patient user) {
       ResponseDTO response = new ResponseDTO();
       if (user.getUserName() == null ||
               user.getUserName().length() < 3 ||
               user.getUserName().length() > 15) {
           response.setMessage("El nombre de usuario debe ser de entre 4 y 10 caracteres");
       }
       if (user.getPassword() == null||
               !user.getPassword().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[a-zA-Z]).{8,16}$")){
           response.setMessage("La contraseña debe tener entre 8 y 16 caracteres, al menos un número, una minúscula y una mayúscula.");
       }
        return response;
    }
}