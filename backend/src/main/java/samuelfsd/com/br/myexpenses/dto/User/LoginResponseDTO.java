package samuelfsd.com.br.myexpenses.dto.User;

public class LoginResponseDTO {
    private String token;
    private UserResponseDTO user;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserResponseDTO getUser() {
        return user;
    }

    public void setUser(UserResponseDTO user) {
        this.user = user;
    }
}
