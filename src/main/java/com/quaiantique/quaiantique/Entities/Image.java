package com.quaiantique.quaiantique.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;
    private String title;
    private String type;
    @Lob
    private byte[] image;

    public Image(String title, String type, byte[] image) {
        this.title = title;
        this.image = image;
        this.type= type;
      }
    
}
