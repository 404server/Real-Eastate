package session.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_user_profile")
@Data
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile")
    private int idProfile;

    @Column(name = "first_name", nullable = false)
    @NotEmpty(message = "First name is required")
    @Size(min = 1, max = 35, message = "First name must be between 1 and 35 characters long")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotEmpty(message = "Last name is required")
    @Size(min = 1, max = 35, message = "Last Name must be between 1 and 35 characters long")
    private String lastName;

    @Column(name = "phone_number", nullable = false)
    @NotEmpty(message = "Phone number is required")

    private String phoneNumber;

    @NotEmpty(message = "Address is required")
    @Column(nullable = false)
    private String address;

    private String about;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private UserAccount user;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "profile")
    private ProfilePicture profilePicture;

    public UserProfile() {
    }

    public UserProfile(String firstName, String lastName, String phoneNumber, String address,
                       String about, UserAccount user, ProfilePicture profilePicture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.about = about;
        this.user = user;
        this.profilePicture = profilePicture;
    }


}