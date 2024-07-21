package tech.nocountry.mvp.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class LoginDTO {
    private String userName;
    private String email;
    private String password;

}