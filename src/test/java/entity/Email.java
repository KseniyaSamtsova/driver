package entity;

import java.util.Objects;

public class Email {

    private String recipientEmail;
    private String subject;
    private String textMessage;

    public Email() {
    }

    public Email(String recipientEmail, String subject, String textMessage) {
        this.recipientEmail = recipientEmail;
        this.subject = subject;
        this.textMessage = textMessage;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Email email = (Email) o;
        return Objects.equals(recipientEmail, email.recipientEmail) && Objects.equals(subject, email.subject) && Objects
                .equals(textMessage, email.textMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipientEmail, subject, textMessage);
    }

    @Override
    public String toString() {
        return "Email{" + "recipientEmail='" + recipientEmail + '\'' + ", subject='" + subject + '\''
                + ", textMessage='" + textMessage + '\'' + '}';
    }
}
