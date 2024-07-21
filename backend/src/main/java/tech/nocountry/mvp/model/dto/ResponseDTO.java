package tech.nocountry.mvp.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    private String jwt;
    private String message;
}