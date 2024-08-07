package tech.nocountry.mvp.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DoctorPasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "Sophiagarcia1";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println(encodedPassword);
    }
}