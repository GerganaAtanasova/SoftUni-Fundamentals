package bg.softuni.mobilele.model.dto;

import bg.softuni.mobilele.model.validation.UniqueUserEmail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterDto {

    @NotBlank(message = "User email should be provided")
    @Email(message = "User email should be valid")
    @UniqueUserEmail(message = "User email should be unique")
    private String email;

    @NotBlank(message = "First name should be provided.")
    @Size(min = 2, max = 20,message = "First name should be between 2 and 20 symbols")
    private String firstName;

    @NotBlank(message = "Last name should be provided.")
    @Size(min = 2, max = 20, message = "Last name should be between 2 and 20 symbols")
    private String lastName;

    @Size(min = 5, message = "Password should be minimum 5 symbols.")
    @NotBlank(message = "Password should be provided.")
    private String password;

    private String confirmPassword;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
