package curso.ej33;

public class Message implements Validable {

    private String text;

    public Message() {
    }

    public Message(String text) {
        this.text = text;
    }

    // Getters & Setters

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // Validable
    
    @Override
    public void validate(ErrorSet errors) {
        if (text.length() > 140) {
            errors.addError("text", "cannot be longer than 140 chars.");
        }
    }
}
