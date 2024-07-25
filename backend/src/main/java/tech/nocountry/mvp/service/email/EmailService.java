package tech.nocountry.mvp.service.email;

public interface EmailService {
    public void sendSimpleMessage(String to, String subject, String text);
}