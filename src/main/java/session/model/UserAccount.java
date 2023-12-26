package session.model;

import lombok.Data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_user")
@Data
public class UserAccount {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_user")
  private int idUser;

  @NotEmpty(message = "Username is required")
  @Size(min = 3, max = 15, message = "Username must be between 3 and 15 characters long")
  @Column(nullable = false)
  private String username;

  @NotEmpty(message = "Password is required")
  @Size(min = 5, message = "Password must be greater or equal to 5")
  @Column(nullable = false)
  private String password;

  private String role;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
  private UserProfile profile;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
  private List<Role> roles;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
  private List<Apartments> houses;


  public UserAccount() {
  }

  public UserAccount(String username, String password) {
    this.username = username;
    this.password = password;
  }


}