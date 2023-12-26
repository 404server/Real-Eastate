package session.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_house_picture")
@Data
public class HousePicture {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_picture")
  private int idPicture;

  @Column(name = "file_name", nullable = false)
  private String fileName;

  @Column(name = "file_type", nullable = false)
  private String fileType;

  @Lob
  @Column(nullable = false)
  private String image;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "id_house")
  private Apartments house;

  public HousePicture() {
  }



}