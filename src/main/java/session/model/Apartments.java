package session.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "tb_house")
@Data
public class Apartments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_house")
    private int idHouse;

    @NotBlank(message = "Type is required")
    @Column(nullable = false)
    private String type;

    @NotBlank(message = "Description is required")
    @Column(nullable = false)
    private String info;

    @Getter
    @NotEmpty(message = "Year is required")
    @Size(min = 4, max = 4, message = "Year must be 4 characters long")
    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private String status;

    @Getter
    @Column(nullable = false)
    @Digits(integer = 10, fraction = 2)
    @Positive(message = "Price can't below 0 or Negative number")
    private int price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private UserAccount user;

    @Getter
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "house")
    private HousePicture housePicture;


    public Apartments() {
    }



}