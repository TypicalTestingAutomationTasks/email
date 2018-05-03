package entities;

import lombok.Data;
import utils.PropertyReader;

@Data
public class Letter {
    private String body;
    private String sender;
    private String subject;

    public Letter(final String newBody, final String newSender, final String newSubject) {
        this.body = newBody;
        this.sender = newSender;
        this.subject = newSubject;
    }

    public static class LetterBuilder {
        private String nestedBody;
        private String nestedSender;
        private String nestedSubject;

        public LetterBuilder() {
            this.nestedBody = setBody();
            this.nestedSender = setSender();
            this.nestedSubject = setSubject();
        }

        private String setBody() {
            if(nestedBody == null) {
                return PropertyReader
                        .getPropertyFromFile("properties/letter.properties", "body");
            } else {
                return nestedBody;
            }
        }

        private String setSender() {
            if(nestedSender == null) {
                return PropertyReader
                        .getPropertyFromFile("properties/letter.properties", "sender");
            } else {
                return nestedSender;
            }
        }

        private String setSubject() {
            if(nestedSubject == null) {
                return PropertyReader
                        .getPropertyFromFile("properties/letter.properties", "subject");
            } else {
                return nestedSubject;
            }
        }

        public Letter createLetter() {
            return new Letter(nestedBody, nestedSender, nestedSubject);
        }
    }
}
