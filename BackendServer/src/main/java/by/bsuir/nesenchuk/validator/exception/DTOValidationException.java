package by.bsuir.nesenchuk.validator.exception;

import java.util.List;

public class DTOValidationException extends RuntimeException {
    private static final long serialVersionUID = 189354203964808239L;

    private List<String> messages;

    public DTOValidationException() {
    }

    public DTOValidationException(List<String> messages) {
        this.messages = messages;
    }

    public DTOValidationException(Throwable cause) {
        super(cause);
    }

    public DTOValidationException(Throwable cause, List<String> messages) {
        super(cause);
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }
}
