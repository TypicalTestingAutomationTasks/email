package entities;

import lombok.Data;
import utils.PropertyReader;

@Data
public class Email {
    private String email;
    private String password;

    public Email(final String newEmail, final String newPassword) {
        this.email = newEmail;
        this.password = newPassword;
    }

    public static class EmailBuilder {
        private String nestedEmail;
        private String nestedPassword;

        public EmailBuilder() {
            this.nestedEmail = setEmail();
            this.nestedPassword = setPassword();
        }

        private String setEmail() {
            if(nestedEmail == null) {
                return PropertyReader
                        .getPropertyFromFile("properties/email.properties", "email");
            } else {
                return nestedEmail;
            }
        }

        private String setPassword() {
            if(nestedPassword == null) {
                return PropertyReader
                        .getPropertyFromFile("properties/email.properties", "password");
            } else {
                return nestedPassword;
            }
        }

        public Email createEmail() {
            return new Email(nestedEmail, nestedPassword);
        }
    }
}
