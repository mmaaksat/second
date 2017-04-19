package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import javax.persistence.*;
import play.data.validation.Constraints;

import java.util.List;


@Entity
@Table(name = "user")
public class User extends Model{

    @Id
    private Long id;

    @Column
    @Constraints.Required
    private String login;

    @Column
    private String password;

    @Column
    private Long roleId;

    @Column
    private Long assetsOrOilId;

    @OneToMany(mappedBy="user")
    List<OilFields> oilFields;

    @Column
    private Long type;

}
