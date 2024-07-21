package tech.nocountry.mvp.service.jwtSecurity;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWTClaimsSet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.util.UUID;

public interface IJWTUtilityService {
    public String generateJWT(UUID userId) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, JOSEException;
    public JWTClaimsSet parseJWT(String jwt) throws JOSEException, IOException, NoSuchAlgorithmException, InvalidKeySpecException, ParseException;
}