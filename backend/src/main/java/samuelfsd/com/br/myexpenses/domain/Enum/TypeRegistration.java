package samuelfsd.com.br.myexpenses.domain.Enum;
public enum TypeRegistration {
    PAYABLE("A pagar"),
    RECEIVED("A receber");

    private String value;

    private TypeRegistration(String value) {
        this.value = value;
    }

    private String getValue() {
        return this.value;
    }

}