package samuelfsd.com.br.myexpenses.domain.exception;

public class ResourceBadRequestException extends RuntimeException {
    public ResourceBadRequestException( String msg) {
        super(msg);
    }

}
