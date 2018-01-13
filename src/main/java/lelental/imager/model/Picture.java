package lelental.imager.model;

import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "picture")
@Data
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "AddedDate")
    private Date addedDate;
    @Column(name = "Image_Data")
    private byte[] pictureData;
    @Column
    private String encoded;
    @ManyToOne
    private User user;


}
