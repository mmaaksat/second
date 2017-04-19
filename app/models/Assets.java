package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import javax.persistence.*;
import play.data.validation.Constraints;

import java.util.List;


@Entity
@Table(name = "Assets")
public class Assets extends Model{

    @Id
    private Long id;

    @Column
    @Constraints.Required
    private String name;


}
