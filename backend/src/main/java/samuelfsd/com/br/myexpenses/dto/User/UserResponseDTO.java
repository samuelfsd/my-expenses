package samuelfsd.com.br.myexpenses.dto.User;

import java.util.Date;

public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;

    private String profilePhoto;

    private Date created_at;
    private Date dateInactivation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public Date getDateInactivation() {
        return dateInactivation;
    }

    public void setDateInactivation(Date dateInactivation) {
        this.dateInactivation = dateInactivation;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
