package za.co.itq.assesment.domain;


import java.util.UUID;

public class UserResponseDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String emailAddress;

    public UserResponseDto toUpperCase() {
        this.id = this.id;
        this.firstName = this.firstName.toUpperCase();
        this.lastName = this.lastName.toUpperCase();
        this.emailAddress = this.getEmailAddress().toUpperCase();
        return this;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
